package com.molina.Bookstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.molina.Bookstore.entities.Categoria;
import com.molina.Bookstore.repositories.CategoriaRepository;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<Categoria> listarCategorias(){
		List<Categoria> listaDeLivros = categoriaRepository.findAll();
		return listaDeLivros;
	}
	
	@GetMapping(value = "/{id}")
	public Categoria listarCategoriaPorId(@PathVariable Long id) {
		Categoria livro = categoriaRepository.findById(id).get();
		return livro;
	}
	
	@PostMapping
	public Categoria adicionarCategoria(@RequestBody Categoria categoria) {
		Categoria novoLivro = categoriaRepository.save(categoria);
		return novoLivro;
	}
	
	@DeleteMapping(value = "/{id}")
	public Categoria deletarCategoriaPorId(@PathVariable Long id) {
		Categoria categoria = categoriaRepository.findById(id).get();
		categoriaRepository.deleteById(id);				
		return categoria;		
	}
	
	@PutMapping(value = "/{id}")
	public Categoria atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoriaAtualizada) {
		Categoria categoria = categoriaRepository.findById(id).get();
		categoria.setNome(categoriaAtualizada.getNome());
		categoriaRepository.save(categoria);		
		return categoria;		
	}

}