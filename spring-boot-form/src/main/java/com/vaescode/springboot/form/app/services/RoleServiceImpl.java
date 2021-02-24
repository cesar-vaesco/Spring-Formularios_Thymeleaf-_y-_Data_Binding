package com.vaescode.springboot.form.app.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vaescode.springboot.form.app.model.domain.Pais;
import com.vaescode.springboot.form.app.model.domain.Role;

@Service
public class RoleServiceImpl implements RoleService {

	//private List<Pais> lista;
	private List<Role> roles;
	
	
	
	public RoleServiceImpl() {
		this.roles = new ArrayList<>();
		this.roles.add(new Role(1,"Administrador","ROLE_ADMIN"));
		this.roles.add(new Role(2,"Usuario","ROLE_USER"));
		this.roles.add(new Role(3,"Moderador","ROLE_MODERATOR"));
		this.roles.add(new Role(4,"qa","ROLE_QA"));
		this.roles.add(new Role(5,"Desarrollador","ROLE_DEVELOPER"));
	}

	@Override
	public List<Role> listar() {
		return roles;
	}

	@Override
	public Role obtenerPorId(Integer id) {
		Role resultado = null;
		for (Role role : roles) {
			if(id== role.getId()) {
				resultado = role;
				break;
			}
		}
		return resultado;
	}

}
