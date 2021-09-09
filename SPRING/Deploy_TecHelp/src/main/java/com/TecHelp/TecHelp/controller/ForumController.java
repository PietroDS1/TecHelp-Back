package com.TecHelp.TecHelp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TecHelp.TecHelp.model.Forum;
import com.TecHelp.TecHelp.repository.ForumRepository;


@RestController
@RequestMapping("/forum")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ForumController {	

		@Autowired
		private ForumRepository repository;

		@GetMapping
		public ResponseEntity<List<Forum>> GetAll() {
			return ResponseEntity.ok(repository.findAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Forum> GetById(@PathVariable long id) {
			return repository.findById(id)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping("/imagem/{imagem}")
		public ResponseEntity<List<Forum>> GetByImagem (@PathVariable String imagem){
			return ResponseEntity.ok(repository.findAllByImagemContainingIgnoreCase(imagem));
		}
		
		@GetMapping("/titulo/{titulo}")
		public ResponseEntity<List<Forum>> GetByTitulo (@PathVariable String titulo){
			return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
		}
		
		@GetMapping("/publicacao/{publicacao}")
		public ResponseEntity<List<Forum>> GetByPublicacao (@PathVariable String publicacao){
			return ResponseEntity.ok(repository.findAllByPublicacaoContainingIgnoreCase(publicacao));
		}
		
		@PostMapping("/adm/{adm}")
		public ResponseEntity<Forum> Post (@RequestBody Forum forum){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(forum));
		}
		
		@PutMapping
		public ResponseEntity<Forum> Put (@RequestBody Forum forum){
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(forum));
		}
		
		@DeleteMapping("/{id}")
		public void Delete (@PathVariable long id) {
			repository.deleteById(id);
		}

	}



