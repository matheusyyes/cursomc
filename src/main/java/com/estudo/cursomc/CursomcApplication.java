package com.estudo.cursomc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.estudo.cursomc.resources.CategoriaResource;

@SpringBootApplication
@ComponentScan(basePackageClasses = {CategoriaResource.class})
public class CursomcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

}
