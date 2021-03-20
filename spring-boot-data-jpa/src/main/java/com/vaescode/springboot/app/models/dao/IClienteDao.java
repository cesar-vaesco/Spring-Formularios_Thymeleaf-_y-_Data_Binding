package com.vaescode.springboot.app.models.dao;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.vaescode.springboot.app.models.entity.Cliente;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long>{

	Page<Cliente> findAll(Pageable pageable);

	
	  
	
}
