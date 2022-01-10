package com.leo.os.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.os.dtos.TecnicoDTO;
import com.leo.os.model.Tecnico;
import com.leo.os.repositorys.TecnicoRepository;
import com.leo.os.services.exceptions.DataViolationException;
import com.leo.os.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = tecnicoRepository.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException
				("Objeto não encontrado! id:" + id + ", Tipo:" + Tecnico.class.getName()));
	}

	public List<Tecnico> findAll() {
		return tecnicoRepository.findAll();
	}
	
	
	public Tecnico create(TecnicoDTO objDTO) {
		if(findByCPF(objDTO) != null) {
			throw new DataViolationException("CPF já cadastrado na base de dados!");
		}
		return tecnicoRepository.save(new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
	}
	
	
	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
		Tecnico velhoObj = findById(id);
		
		if(findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new DataViolationException("CPF já cadastrado na base de dados!");
		}
		
		velhoObj.setNome(objDTO.getNome());
		velhoObj.setCpf(objDTO.getCpf());
		velhoObj.setTelefone(objDTO.getTelefone());
		
		return tecnicoRepository.save(velhoObj);
	}
	
	
	private Tecnico findByCPF(TecnicoDTO objDTO) {
		Tecnico obj = tecnicoRepository.findByCPF(objDTO.getCpf());
		if(obj != null) {
			return obj;
		}
		return null;
	}


}
