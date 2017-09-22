package com.andreandrada.cursoPds1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreandrada.cursoPds1.domain.Categoria;
import com.andreandrada.cursoPds1.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;	
	
	public Categoria buscar(Integer id) {
		Categoria obj= repo.findOne(id);
		return obj;
	}
}
