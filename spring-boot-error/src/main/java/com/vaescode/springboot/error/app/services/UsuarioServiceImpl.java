package com.vaescode.springboot.error.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vaescode.springboot.error.app.models.damain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private List<Usuario> lista;

	public UsuarioServiceImpl() {
		this.lista = new ArrayList<>();
		this.lista.add(new Usuario(1, "César", "Vargas"));
		this.lista.add(new Usuario(2, "Verónica", "Cortéz"));
		this.lista.add(new Usuario(3, "Aurelio Heriberto", "Vargas"));
		this.lista.add(new Usuario(4, "Gloria", "Vargas"));
		this.lista.add(new Usuario(5, "Vanessa", "Vargas"));
		this.lista.add(new Usuario(6, "Aurelio", "Vargas"));
		this.lista.add(new Usuario(7, "Brighith", "Escorcia"));
		this.lista.add(new Usuario(8, "Hilda", "Vargas"));
	}

	@Override
	public List<Usuario> listar() {
		
		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario resultado = null;

		for (Usuario usuario : this.lista) {
			if (usuario.getId().equals(id)) {
				resultado = usuario;
				break;
			}
		}
		return resultado;
	}

	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		Usuario usuario = this.obtenerPorId(id);
		return Optional.ofNullable(usuario);
	}

}
