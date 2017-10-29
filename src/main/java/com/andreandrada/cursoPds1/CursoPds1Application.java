	package com.andreandrada.cursoPds1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andreandrada.cursoPds1.domain.Categoria;
import com.andreandrada.cursoPds1.domain.Produto;
import com.andreandrada.cursoPds1.repositories.CategoriaRepository;
import com.andreandrada.cursoPds1.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoPds1Application implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoPds1Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Categoria cat1= new Categoria(null, "Informática");
		Categoria cat2=new Categoria(null, "Escritório");
		Categoria cat3=new Categoria(null, "Cama mesa e banho");
		Categoria cat4=new Categoria(null, "Eletrônicos");
		Categoria cat5=new Categoria(null, "Perfumaria");
		Categoria cat6=new Categoria(null, "Jardinagem");
		Categoria cat7=new Categoria(null, "Ferramentas");
		
		Produto p1 = new Produto (null, "Computador",2000.00);
		Produto p2 = new Produto (null, "Impressora", 800.00);	
		Produto p3 = new Produto (null,"Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat2));
		
	
		categoriaRepository.save(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));	
		produtoRepository.save(Arrays.asList(p1, p2, p3));
	}



}
