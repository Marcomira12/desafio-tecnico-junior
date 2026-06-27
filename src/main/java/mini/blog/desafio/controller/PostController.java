package mini.blog.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;
import mini.blog.desafio.molde.Post;
import mini.blog.desafio.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostService postService;

	@PostMapping("/posts")
	public ResponseEntity<Object> criarPost(@RequestBody Post post) {
		try {
			postService.salvar(post);
			return ResponseEntity.ok().body(post);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar Post");
		}
	}

	@GetMapping("/posts")
	public ResponseEntity<Object> findAll() {
		try {
			List<Post> posts = postService.findAll();
			return ResponseEntity.ok().body(posts);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao retornar os posts");
		}
	}

	@GetMapping("/posts/{id}")
	public ResponseEntity<Object> getPost(@PathVariable("id") Long id) {
		try {
			Post post = postService.buscarPost(id);
			return ResponseEntity.ok().body(post);
		} catch (Exception e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}

	@PutMapping("/posts/{id}")
	public ResponseEntity<Object> atualizarPost(@PathVariable("id") Long id,@RequestBody Post post) {
		try {
			post.setId(id);
			post=postService.atualizar(post);
			return ResponseEntity.ok(postService.atualizar(post));
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<Object> deletar(@PathVariable("id") Long id){
		try {
			postService.delete(id);
			return ResponseEntity.ok().body("Post deletado");
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}

}
