package com.vaescode.springboot.form.app.services;

import java.util.List;

import com.vaescode.springboot.form.app.model.domain.Pais;

public interface PaisService {

	public List<Pais> listar();
	public Pais obtenerPorId(Integer id);
}
