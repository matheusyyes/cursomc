package com.estudo.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.estudo.cursomc.domain.Categoria;
import com.estudo.cursomc.domain.Produto;
import com.estudo.cursomc.repositories.CategoriaRepository;
import com.estudo.cursomc.repositories.ProdutoRepository;
import com.estudo.cursomc.services.exception.ObjectNotFoundException;


@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repo;
	
	@Autowired
	CategoriaRepository repoCat;
	
	public Produto find(Integer id) {
		
		Optional<Produto> cat = repo.findById(id);
		
		return cat.orElseThrow(() -> new ObjectNotFoundException(  "Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public Page<Produto> search(String nome,List<Integer> ids, Integer page, Integer linesPerPage, String ordeBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction) , ordeBy);
		List<Categoria>categorias = repoCat.findAllById(ids);
		return repo.search(nome, categorias, pageRequest);
	}
	
}
