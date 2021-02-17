package com.vaescode.springboot.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.vaescode.springboot.form.app.editors.NombreMayusculaEditor;
import com.vaescode.springboot.form.app.model.domain.Usuario;
import com.vaescode.springboot.form.app.validator.UsuarioValidator;

@Controller
@SessionAttributes("usuario")
public class FormController {

	@Autowired
	private UsuarioValidator validador;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		
		//binder.registerCustomEditor permite conversión entre valores de cadena y tipos de objetos personalizados
		binder.registerCustomEditor(Date.class, "fechaNacimiento",new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(String.class, new NombreMayusculaEditor());
		
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("");
		usuario.setApellido("");
		usuario.setIdentificador("");
		model.addAttribute("titulo", "Formulario usuarios");
		model.addAttribute("usuario", usuario);
		return "form";
	}

	@PostMapping("/form")
	public String procesarFormulario(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
		
		//validador.validate(usuario, result);
		model.addAttribute("titulo", "Resultado del form");
		if (result.hasErrors()) {
			/*Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(err -> {
				errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
			});
			
			model.addAttribute("error", errores);*/
			return "form";
		}
		
		model.addAttribute("usuario", usuario);
		status.setComplete();
		return "resultado";
	}
}
