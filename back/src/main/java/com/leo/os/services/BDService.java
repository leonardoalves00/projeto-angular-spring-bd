package com.leo.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.leo.os.model.Cliente;
import com.leo.os.model.OS;
import com.leo.os.model.Tecnico;
import com.leo.os.model.enums.Prioridade;
import com.leo.os.model.enums.Status;
import com.leo.os.repositorys.ClienteRepository;
import com.leo.os.repositorys.OSRepository;
import com.leo.os.repositorys.TecnicoRepository;

@Service
public class BDService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private OSRepository osRepository;
	
	public void instanciaDB() {
		Tecnico t1 = new Tecnico(null, "leonardo alves", "61433158337", "(85)989969896");
		Cliente c1 = new Cliente(null, "Maria do bairro", "264.002.750-61", "(85)933333333");
		
		OS os1 = new OS(null, Prioridade.ALTA, "teste OS", Status.ANDAMENTO, t1, c1);
		
		t1.getList().add(os1);
		c1.getList().add(os1);
		
		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}
	
}
