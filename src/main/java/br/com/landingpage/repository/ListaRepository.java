package br.com.landingpage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.landingpage.model.Lista;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Long>{

}
