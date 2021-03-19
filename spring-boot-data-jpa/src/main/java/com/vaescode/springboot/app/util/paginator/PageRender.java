package com.vaescode.springboot.app.util.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {

	private String url;
	private Page<T> page;

	private int totalPaginas;
	private int numerosElementosPorPaginas;

	private int paginaActual;

	private List<PageItem> paginas;

	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.paginas = new ArrayList<PageItem>();

		numerosElementosPorPaginas = page.getSize();
		totalPaginas = page.getTotalPages();
		paginaActual = page.getNumber() + 1;

		int desde, hasta;
		if (totalPaginas <= numerosElementosPorPaginas) {
			desde = 1;
			hasta = totalPaginas;
		} else {
			if (paginaActual <= numerosElementosPorPaginas / 2) {
				desde = 1;
				hasta = numerosElementosPorPaginas;
			} else if (paginaActual >= totalPaginas - numerosElementosPorPaginas / 2) {
				desde = totalPaginas - numerosElementosPorPaginas + 1;
				hasta = numerosElementosPorPaginas;
			} else {
				desde = paginaActual - numerosElementosPorPaginas / 2;
				hasta = numerosElementosPorPaginas;
			}
		}

		for (int i = 0; i < hasta; i++) {
			paginas.add(new PageItem(desde + i, paginaActual == desde + i));
		}
	}

	public String getUrl() {
		return url;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public int getPaginaActual() {
		return paginaActual;
	}

	public List<PageItem> getPaginas() {
		return paginas;
	}

	public boolean isFirst() {
		return page.isFirst();
	}

	public boolean isLast() {
		return page.isLast();
	}

	public boolean isHasNext() {
		return page.hasNext();
	}

	public boolean isHasPrevius() {
		return page.hasPrevious();
	}

}
