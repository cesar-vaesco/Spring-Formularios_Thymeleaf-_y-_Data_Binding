package com.vaescode.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vaescode.springboot.form.app.model.domain.Pais;

@Service
public class PaisServiceImpl implements PaisService {
	
	private List<Pais> lista;

	// Llamada ala constructor que permite inicializar nuestra lista
	public PaisServiceImpl() {
		
		this.lista = Arrays.asList(
				new Pais(1,"MX", "México"),
				new Pais(2,"ES","España"), 
				new Pais(3,"CL","Chile"), 
				new Pais(4,"AR","Argentina"),
				new Pais(5,"EC","Ecuador"), 
				new Pais(6,"PR","Perú"), 
				new Pais(7,"CL","Colombia"),
				new Pais(8,"VZ","Venezuela"));
	}

	@Override
	public List<Pais> listar() {
		return lista;
	}

	@Override
	public Pais obtenerPorId(Integer id) {
		Pais resultado = null;
		for (Pais pais : this.lista) {
			if(id == pais.getId()) {
				resultado = pais;
				break;
			}
		}
		return resultado;
	}

}
