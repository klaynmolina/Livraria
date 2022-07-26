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

import com.molina.Bookstore.entities.Livro;
import com.molina.Bookstore.repositories.LivroRepository;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping
	public List<Livro> listarLivros(){
		List<Livro> listaDeLivros = livroRepository.findAll();
		return listaDeLivros;
	}
	
	@GetMapping(value = "/{id}")
	public Livro listarLivroPorId(@PathVariable Long id) {
		Livro livro = livroRepository.findById(id).get();
		return livro;
	}
	
	@PostMapping
	public Livro adicionarLivro(@RequestBody Livro livro) {
		Livro novoLivro = livroRepository.save(livro);
		return novoLivro;
	}
	
	@DeleteMapping(value = "/{id}")
	public Livro deletarLivro(@PathVariable Long id) {
		Livro livro = livroRepository.findById(id).get();
		livroRepository.deleteById(id);				
		return livro;		
	}
	
	@PutMapping(value = "/{id}")
	public Livro atualizarLivro(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
		Livro livro = livroRepository.findById(id).get();
		livro.setNome(livroAtualizado.getNome());
		livro.setCategoria(livroAtualizado.getCategoria());
		livroRepository.save(livro);		
		return livro;		
	}
}
