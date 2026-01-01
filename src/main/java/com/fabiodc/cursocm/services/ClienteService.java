package com.fabiodc.cursocm.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiodc.cursocm.domain.Cliente;
import com.fabiodc.cursocm.repositories.ClienteRepository;
import com.fabiodc.cursocm.services.exceptions.ObjectNotFoundException;
@Service
public class ClienteService{
	@Autowired
    private ClienteRepository repo;
	public Cliente buscar(Integer id){
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> 
	    new ObjectNotFoundException(
	        "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()
	    )
	);
	}
}
