package com.estudo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.cursomc.domain.Cliente;
import com.estudo.cursomc.repositories.ClienteRepository;
import com.estudo.cursomc.services.exception.ObjectNotFoundException;


@Service
public class ClienteService {

	@Autowired
	ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		
		Optional<Cliente> cat = repo.findById(id);
		
		return cat.orElseThrow(() -> new ObjectNotFoundException(  "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
}
