package com.leo.os.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.os.dtos.TecnicoDTO;
import com.leo.os.model.Tecnico;
import com.leo.os.services.TecnicoService;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoConntroller {
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){
		TecnicoDTO objDTO = new TecnicoDTO(tecnicoService.findById(id));
		return ResponseEntity.ok().body(objDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<TecnicoDTO>> findAll(){
		
		List<TecnicoDTO> listDTO = tecnicoService.findAll()
				.stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
		/*
		 * List<Tecnico> list = tecnicoService.findAll(); List<TecnicoDTO> listDTO = new
		 * ArrayList<>();
		 * 
		 * for(Tecnico obj : list) { listDTO.add(new TecnicoDTO(obj)); }
		 * 
		 * list.forEach(obj -> listDTO.add(new TecnicoDTO()));
		 */
	}
}
