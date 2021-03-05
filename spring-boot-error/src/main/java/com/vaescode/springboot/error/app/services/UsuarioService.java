package com.vaescode.springboot.error.app.services;

import java.util.List;

import com.vaescode.springboot.error.app.models.damain.Usuario;

public interface UsuarioService {
	
	public List<Usuario>  listar();
	
	public Usuario obtenerPorId(Integer id);

}
