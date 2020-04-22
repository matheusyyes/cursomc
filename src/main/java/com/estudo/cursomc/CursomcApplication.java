package com.estudo.cursomc;

import java.text.SimpleDateFormat;
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
import com.estudo.cursomc.domain.ItemPedido;
import com.estudo.cursomc.domain.Pagamento;
import com.estudo.cursomc.domain.PagamentoComBoleto;
import com.estudo.cursomc.domain.PagamentoComCartao;
import com.estudo.cursomc.domain.Pedido;
import com.estudo.cursomc.domain.Produto;
import com.estudo.cursomc.domain.enums.EstadoPagamento;
import com.estudo.cursomc.domain.enums.TipoCliente;
import com.estudo.cursomc.repositories.CategoriaRepository;
import com.estudo.cursomc.repositories.CidadeRepository;
import com.estudo.cursomc.repositories.ClienteRepository;
import com.estudo.cursomc.repositories.EnderecoRepository;
import com.estudo.cursomc.repositories.EstadoRepository;
import com.estudo.cursomc.repositories.ItemPedidoRepository;
import com.estudo.cursomc.repositories.PagamentoRepository;
import com.estudo.cursomc.repositories.PedidoRepository;
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
	
	@Autowired
	PagamentoRepository pagRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"mouse",50.00);
		Produto p4 = new Produto(null,"Mesa de Escritório",330.00);
		Produto p5 = new Produto(null,"Toalha",50.00);
		Produto p6 = new Produto(null,"Colcha",280.00);
		Produto p7 = new Produto(null,"TV true color",1220.00);
		Produto p8 = new Produto(null,"Roçadeira",800.00);
		Produto p9 = new Produto(null,"Abajour",180.00);
		Produto p10 = new Produto(null,"Pendente",180.00);
		Produto p11 = new Produto(null,"Shampoo",90.00);
		
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2,p4));
		cat3.getProdutos().addAll(Arrays.asList(p5,p6));
		cat4.getProdutos().addAll(Arrays.asList(p1,p2,p3,p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9,p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));
		
		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2,cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1,cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));
		
		repository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7));
		proRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10));
		
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
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("15/02/2020 19:50"),cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("14/02/2020 19:00"),cli1, e2);
		
		Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pag1);
		Pagamento pag2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/02/2020 00:00"), null);
		ped2.setPagamento(pag2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagRepository.saveAll(Arrays.asList(pag1,pag2));
		
		ItemPedido ep1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ep2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ep3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ep1,ep2));
		ped2.getItens().addAll(Arrays.asList(ep3));
		
		p1.getItens().addAll(Arrays.asList(ep1));
		p2.getItens().addAll(Arrays.asList(ep3));
		p3.getItens().addAll(Arrays.asList(ep2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ep1,ep2,ep3));
		
	}

}
