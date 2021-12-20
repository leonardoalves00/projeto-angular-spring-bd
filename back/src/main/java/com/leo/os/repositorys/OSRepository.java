package com.leo.os.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leo.os.model.OS;

@Repository
public interface OSRepository extends JpaRepository<OS, Integer>{
	
}
