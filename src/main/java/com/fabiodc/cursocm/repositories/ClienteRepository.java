package com.fabiodc.cursocm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fabiodc.cursocm.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


}
