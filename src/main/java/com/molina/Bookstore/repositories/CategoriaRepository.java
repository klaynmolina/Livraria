package com.molina.Bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.molina.Bookstore.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
