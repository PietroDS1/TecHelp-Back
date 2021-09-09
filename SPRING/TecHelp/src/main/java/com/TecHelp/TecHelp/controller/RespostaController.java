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

import com.TecHelp.TecHelp.model.Resposta;
import com.TecHelp.TecHelp.repository.RespostaRepository;

@RestController
@RequestMapping("/resposta")
@CrossOrigin(origins = "*", allowedHeaders = "*" )
public class RespostaController {
		
		@Autowired
		private RespostaRepository repository;
		
		@GetMapping
		public ResponseEntity<List<Resposta>> GetALL (){
			return ResponseEntity.ok(repository.findAll());
		}

		@GetMapping("/{id}")
		public ResponseEntity<Resposta> GetById(@PathVariable long id){
			return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping("/comentario/{comentario}")
		public ResponseEntity<List<Resposta>> GetByComentario(@PathVariable String comentario){
			return ResponseEntity.ok(repository.findAllByComentarioContainingIgnoreCase(comentario));
			
		}
		
		@GetMapping("/imagem/{imagem}")
		public ResponseEntity<List<Resposta>> GetByImagem(@PathVariable String imagem){
			return ResponseEntity.ok(repository.findAllByImagemContainingIgnoreCase(imagem));
			
		}
		
		@PostMapping
		public ResponseEntity<Resposta> post (@RequestBody Resposta resposta){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(resposta));
		}
		@PutMapping
		public ResponseEntity<Resposta> put (@RequestBody Resposta resposta){
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(resposta));
		}
		
		@DeleteMapping("/{id}")
		public void delete(@PathVariable long id) {
			repository.deleteById(id);
		}
		
		
}
	

