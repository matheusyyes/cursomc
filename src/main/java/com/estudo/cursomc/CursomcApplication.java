package com.estudo.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.estudo.cursomc.domain.Categoria;
import com.estudo.cursomc.repositories.CategoriaRepository;
import com.estudo.cursomc.resources.CategoriaResource;
import com.estudo.cursomc.services.CategoriaService;

@SpringBootApplication
@ComponentScan(basePackageClasses = {CategoriaResource.class, CategoriaService.class})
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		repository.saveAll(Arrays.asList(cat1,cat2));
		
	}

}
