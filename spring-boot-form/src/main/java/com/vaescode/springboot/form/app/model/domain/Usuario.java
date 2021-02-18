package com.vaescode.springboot.form.app.model.domain;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Email;
//import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//import org.springframework.format.annotation.DateTimeFormat;

import com.vaescode.springboot.form.app.validator.IdentificadorRegex;
import com.vaescode.springboot.form.app.validator.Requerido;

public class Usuario {
	
	/*
	 * [0-9] es igual a [\\d]
	 * [.,] indica que la expresión puede llevar o coma o punto pero no los dos
	 * */
	//@Pattern(regexp ="[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
	@IdentificadorRegex
	private String identificador;

	//@NotEmpty(message = "el campo 'nombre' no puede ir vacío")
	private String nombre;

	//@NotBlank
	@Requerido
	private String apellido;

	@NotBlank
	@Size(min = 3, max = 8)
	private String username;

	@NotEmpty
	private String password;

	@NotEmpty(message = "el campo 'correo' no puede ir vacío")
	@Email
	private String email;

	@NotNull
	@Min(5)
	@Max(5000)
	private Integer cuenta;
	
	@NotNull
	@Past
	//(@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	
	@Valid
	private Pais pais;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCuenta() {
		return cuenta;
	}

	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	

}
