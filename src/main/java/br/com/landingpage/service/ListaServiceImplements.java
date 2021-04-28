package br.com.landingpage.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.landingpage.model.Lista;
import br.com.landingpage.repository.ListaRepository;

@Service
public class ListaServiceImplements implements ListaService{

	@Autowired
	private ListaRepository listaRepository;
	
	@Override
	public Lista save(Lista lista) {
		return listaRepository.save(lista);
	}

	@Override
	public void deleteById(Long listaId) {
		listaRepository.deleteById(listaId);
	}

	@Override
	public Optional<Lista> findById(Long id) {
		return listaRepository.findById(id);
	}

	
}
