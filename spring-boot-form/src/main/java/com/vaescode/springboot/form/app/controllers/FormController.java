package com.vaescode.springboot.form.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

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
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("_nombre_");
		usuario.setApellido("_apellido_");
		usuario.setIdentificador("123.456.789-X");
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
