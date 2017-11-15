package com.andreandrada.cursoPds1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreandrada.cursoPds1.domain.Categoria;
import com.andreandrada.cursoPds1.repositories.CategoriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;	
	
	public Categoria buscar(Integer id) throws ObjectNotFoundException {
		Categoria obj= repo.findOne(id);
		if (obj == null) {
				throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id
						+ ", Tipo: " + Categoria.class.getName());
					
			
		}
		return obj;
	}
}
