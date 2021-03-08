package com.vaescode.springboot.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vaescode.springboot.app.models.dao.IClienteDao;
import com.vaescode.springboot.app.models.entity.Cliente;

@Controller
public class ClienteController {
	
	@Autowired
	@Qualifier
	private IClienteDao clienteDao;
	
	
	@GetMapping("/listar")
	public String listar(Model model){
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		return "listar";
	}

}
