	package com.andreandrada.cursoPds1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andreandrada.cursoPds1.domain.Categoria;
import com.andreandrada.cursoPds1.repositories.CategoriaRepository;

@SpringBootApplication
public class CursoPds1Application implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoPds1Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Categoria cat1= new Categoria(null, "Informática");
		Categoria cat2=new Categoria(null, "Escritório");
		
	}
	
	
}
