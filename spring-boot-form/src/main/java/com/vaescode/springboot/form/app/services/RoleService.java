package com.vaescode.springboot.form.app.services;

import java.util.List;

import com.vaescode.springboot.form.app.model.domain.Role;

public interface RoleService {

	public List<Role> listar();

	public Role obtenerPorId(Integer id);
}
