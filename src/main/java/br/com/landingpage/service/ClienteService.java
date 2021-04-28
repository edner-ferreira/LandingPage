package br.com.landingpage.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.landingpage.model.Cliente;

public interface ClienteService {
	
	Cliente save(Cliente cliente);
	
	void deleteById(Long clienteId);
	
	Optional<Cliente> findById(Long id);
	
}
