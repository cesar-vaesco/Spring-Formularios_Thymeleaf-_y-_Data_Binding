package com.vaescode.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vaescode.springboot.form.app.model.domain.Usuario;

@Controller
public class FormController {

	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("titulo", "Formulario usuarios");
		return "form";
	}

	@PostMapping("/form")
	public String procesarFormulario(Model model, @RequestParam(name = "username") String username,
			@RequestParam String password, @RequestParam String email) {
		
		Usuario usuario = new Usuario();
		
		usuario.setUsername(username);
		usuario.setPassword(password);
		usuario.setEmail(email);
		model.addAttribute("titulo", "Resultado del form");
		model.addAttribute("usuario", usuario);
		
		return "resultado";
	}
}
