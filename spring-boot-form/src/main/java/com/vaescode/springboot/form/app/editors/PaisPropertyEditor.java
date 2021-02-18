package com.vaescode.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaescode.springboot.form.app.services.PaisService;

@Component
public class PaisPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private PaisService service;

	@Override
	public void setAsText(String idString) throws IllegalArgumentException {
		//Sin el if la funcionalidad del método es la misma ya que al cachar la excepción el valor ingresado lo enviamos a null
		if (idString != null && idString.length() > 0) {
			try {
				Integer id = Integer.parseInt(idString);
				this.setValue(service.obtenerPorId(id));
			} catch (NumberFormatException e) {
				setValue(null);
			}
		} else {
			setValue(null);
		}
	}

}
