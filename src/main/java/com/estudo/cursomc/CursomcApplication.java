package com.estudo.cursomc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.estudo.cursomc.resources.CategoriaResource;
import com.estudo.cursomc.services.CategoriaService;

@SpringBootApplication
@ComponentScan(basePackageClasses = {CategoriaResource.class, CategoriaService.class})
public class CursomcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

}
