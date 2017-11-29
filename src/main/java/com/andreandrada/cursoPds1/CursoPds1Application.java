	package com.andreandrada.cursoPds1;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andreandrada.cursoPds1.domain.Categoria;
import com.andreandrada.cursoPds1.domain.Cidade;
import com.andreandrada.cursoPds1.domain.Cliente;
import com.andreandrada.cursoPds1.domain.Endereco;
import com.andreandrada.cursoPds1.domain.Estado;
import com.andreandrada.cursoPds1.domain.Pagamento;
import com.andreandrada.cursoPds1.domain.PagamentoComBoleto;
import com.andreandrada.cursoPds1.domain.PagamentoComCartao;
import com.andreandrada.cursoPds1.domain.Pedido;
import com.andreandrada.cursoPds1.domain.Produto;
import com.andreandrada.cursoPds1.domain.enums.EstadoPagamento;
import com.andreandrada.cursoPds1.domain.enums.TipoCliente;
import com.andreandrada.cursoPds1.repositories.CategoriaRepository;
import com.andreandrada.cursoPds1.repositories.CidadeRepository;
import com.andreandrada.cursoPds1.repositories.ClienteRepository;
import com.andreandrada.cursoPds1.repositories.EnderecoRepository;
import com.andreandrada.cursoPds1.repositories.EstadoRepository;
import com.andreandrada.cursoPds1.repositories.PagamentoRepository;
import com.andreandrada.cursoPds1.repositories.PedidoRepository;
import com.andreandrada.cursoPds1.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoPds1Application implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
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
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
			
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
	
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.save(Arrays.asList(est1,est2));
		cidadeRepository.save(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null,"Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));	
		
		clienteRepository.save(Arrays.asList(cli1));
		enderecoRepository.save(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(null,sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null,sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1= new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2= new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
				
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.save(Arrays.asList(ped1, ped2));
		pagamentoRepository.save(Arrays.asList(pagto1, pagto2));
		
	}	



}
