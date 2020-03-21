package com.estudo.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.estudo.cursomc.domain.Categoria;
import com.estudo.cursomc.dto.CategoriaDTO;
import com.estudo.cursomc.repositories.CategoriaRepository;
import com.estudo.cursomc.services.exception.DataIntegrityException;
import com.estudo.cursomc.services.exception.ObjectNotFoundException;


@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		
		Optional<Categoria> cat = repo.findById(id);
		
		return cat.orElseThrow(() -> new ObjectNotFoundException(  "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}

	public Categoria update(Categoria obj) {

		find(obj.getId());
		
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		
		try {
		repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
			
		}
	}

	public List<Categoria> findAll() {
		return repo.findAll();
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String ordeBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction) , ordeBy);
		return repo.findAll(pageRequest);
	}
	
	public Categoria fromDTO(CategoriaDTO objDTO) {
		
		return new Categoria(objDTO.getId(), objDTO.getNome());
		
	}
}
