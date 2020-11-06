package org.generation.blogPessoal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.generation.blogPessoal.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository< Postagem, Long> { 
	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);	
	
	@Query(value = "select * from postagem where ano > 2011", nativeQuery = true)
	List<Postagem> findAllMaior();
	
	@Query(value = "select * from postagem where ano > 2011 order by desc", nativeQuery = true)
	List<Postagem> anoDesc();
	
	@Query(value = "select * from postagem where ano >= 2011 and ano <= 2013", nativeQuery = true)
	List<Postagem> anosAsc();
	
}


