package mini.blog.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;

import mini.blog.desafio.molde.Autor;
import mini.blog.desafio.repository.AutorRepository;

public class AutorService {
	@Autowired
	private AutorRepository repository;
	public Autor salvar(Autor autor) {
		autor=repository.save(autor);
		return autor;
	}
}
