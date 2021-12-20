package com.leo.os.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leo.os.model.Tecnico;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{
	
}
