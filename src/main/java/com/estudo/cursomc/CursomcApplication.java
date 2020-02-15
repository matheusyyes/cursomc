package com.estudo.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.estudo.cursomc.domain.Categoria;
import com.estudo.cursomc.domain.Cidade;
import com.estudo.cursomc.domain.Cliente;
import com.estudo.cursomc.domain.Endereco;
import com.estudo.cursomc.domain.Estado;
import com.estudo.cursomc.domain.Produto;
import com.estudo.cursomc.domain.enums.TipoCliente;
import com.estudo.cursomc.repositories.CategoriaRepository;
import com.estudo.cursomc.repositories.CidadeRepository;
import com.estudo.cursomc.repositories.ClienteRepository;
import com.estudo.cursomc.repositories.EnderecoRepository;
import com.estudo.cursomc.repositories.EstadoRepository;
import com.estudo.cursomc.repositories.ProdutoRepository;
import com.estudo.cursomc.resources.CategoriaResource;
import com.estudo.cursomc.services.CategoriaService;

@SpringBootApplication
@ComponentScan(basePackageClasses = {CategoriaResource.class, CategoriaService.class})
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository repository;
	
	@Autowired
	ProdutoRepository proRepository;
	
	@Autowired
	EstadoRepository estRepository;
	
	@Autowired
	CidadeRepository cidRepository;
	
	@Autowired
	ClienteRepository cliRepository;
	
	@Autowired
	EnderecoRepository endRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		repository.saveAll(Arrays.asList(cat1,cat2));
		proRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null,"São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estRepository.saveAll(Arrays.asList(est1, est2));
		cidRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null,"Matheus","matheus.300miranda@live.com", "4854854577", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("41566891","951982457"));
		
		Endereco e1 = new Endereco(null, "rua flores", "12", "C", "Alphaville", "06528-201", cli1, c2);
		Endereco e2 = new Endereco(null, "av matos", "276", "y", "Barueri", "06598-000", cli1, c1);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		cliRepository.save(cli1);
		endRepository.saveAll(Arrays.asList(e1,e2));
		
	}

}
