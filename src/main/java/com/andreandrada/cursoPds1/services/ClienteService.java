package com.andreandrada.cursoPds1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreandrada.cursoPds1.domain.Cliente;
import com.andreandrada.cursoPds1.repositories.ClienteRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;	
	
	public Cliente buscar(Integer id) throws ObjectNotFoundException {
		Cliente obj= repo.findOne(id);
		if (obj == null) {
				throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id
						+ ", Tipo: " + Cliente.class.getName());
					
			
		}
		return obj;
	}
}
