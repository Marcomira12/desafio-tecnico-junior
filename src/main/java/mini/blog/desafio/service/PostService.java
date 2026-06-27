package mini.blog.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import mini.blog.desafio.molde.Post;
import mini.blog.desafio.repository.PostRepository;
@Service
public class PostService {
	@Autowired
	private PostRepository repository;
	
	public Post salvar(Post post) {
		post=repository.save(post);
		return post;
	}
	
	public List<Post> findAll(){
		List<Post> post=repository.findAll();
		return post;
	}
	
	public Post buscarPost(Long id) {
		
		 return repository.findById(id)
		            .orElseThrow(() -> new EntityNotFoundException("Post não encontrado"));
		
	}
	@Transactional
	public Post atualizar(Post post) {
		Post postExistente=buscarPost(post.getId());
		postExistente.setAutor(post.getAutor());
		postExistente.setConteudo(post.getConteudo());
		postExistente.setTitulo(post.getTitulo());
		return repository.save(postExistente);
	}
	@Transactional
	public void delete(Long id) {
		buscarPost(id);
		repository.deleteById(id);
		
	}
}
