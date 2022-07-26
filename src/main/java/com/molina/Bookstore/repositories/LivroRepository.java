package com.molina.Bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.molina.Bookstore.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
