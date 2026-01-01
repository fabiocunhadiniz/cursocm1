package com.fabiodc.cursocm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fabiodc.cursocm.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {


}
