package com.fabiodc.cursocm.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.fabiodc.cursocm.domain.Cliente;
import com.fabiodc.cursocm.domain.enums.TipoCliente;
import com.fabiodc.cursocm.dto.ClienteDTO;
import com.fabiodc.cursocm.repositories.ClienteRepository;
import com.fabiodc.cursocm.resources.exceptions.FieldMessage;
import com.fabiodc.cursocm.services.validation.utils.BR;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {
  
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
    public void initialize(ClienteUpdate ann) {

    }

	@Override

	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId =Integer.parseInt(map.get("id"));
        
		List<FieldMessage> list = new ArrayList<>();
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if(aux != null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "email já existente"));
		}
		
       // inclua os testes aqui, inserindo erros na lista
       for (FieldMessage e : list) {
           context.disableDefaultConstraintViolation();
           context.buildConstraintViolationWithTemplate(e.getMessage())
           .addPropertyNode(e.getFieldName()).addConstraintViolation();
     }
    return list.isEmpty();
   }
}