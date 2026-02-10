package com.fabiodc.cursocm.services;

import java.nio.channels.UnsupportedAddressTypeException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fabiodc.cursocm.domain.Cliente;
import com.fabiodc.cursocm.dto.ClienteDTO;
import com.fabiodc.cursocm.repositories.ClienteRepository;
import com.fabiodc.cursocm.services.exceptions.DataIntegrityException;
import com.fabiodc.cursocm.services.exceptions.ObjectNotFoundException;
@Service
public class ClienteService{
	@Autowired
    private ClienteRepository repo;
	public Cliente find(Integer id){
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> 
	    new ObjectNotFoundException(
	        "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()
	    )
	);
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	public void delete (Integer id) {
		find(id);
		try {
		repo.deleteById(id);
	}catch(DataIntegrityViolationException e) {
		throw new DataIntegrityException("Não é Possível Excluir porque há entidades relacionadas");
	}
	}
	
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		Sort sort = Sort.by(
	            Sort.Direction.valueOf(direction.toUpperCase()),
	            orderBy
	    );
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, sort);
        return repo.findAll(pageRequest);
	}
	
     public Cliente fromDTO(ClienteDTO objDto){
    	return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
     }
     
     private void updateData(Cliente newObj, Cliente obj) {
    	 newObj.setNome(obj.getNome());
    	 newObj.setEmail(obj.getEmail());
     }
}
