package com.estudo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.cursomc.domain.Pedido;
import com.estudo.cursomc.repositories.PedidoRepository;
import com.estudo.cursomc.services.exception.ObjectNotFoundException;


@Service
public class PedidoService {

	@Autowired
	PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		
		Optional<Pedido> cat = repo.findById(id);
		
		return cat.orElseThrow(() -> new ObjectNotFoundException(  "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	
}
