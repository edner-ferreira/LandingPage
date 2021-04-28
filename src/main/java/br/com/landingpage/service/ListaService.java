package br.com.landingpage.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.landingpage.model.Lista;

public interface ListaService {
	
	Lista save(Lista lista);
	
	void deleteById(Long listaId);
	
	Optional<Lista> findById(Long id);
}
