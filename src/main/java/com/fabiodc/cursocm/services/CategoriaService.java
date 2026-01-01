package com.fabiodc.cursocm.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiodc.cursocm.domain.Categoria;
import com.fabiodc.cursocm.repositories.CategoriaRepository;
import com.fabiodc.cursocm.services.exceptions.ObjectNotFoundException;
@Service
public class CategoriaService{
	@Autowired
    private CategoriaRepository repo;
	public Categoria buscar(Integer id){
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> 
	    new ObjectNotFoundException(
	        "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()
	    )
	);
	}
}
