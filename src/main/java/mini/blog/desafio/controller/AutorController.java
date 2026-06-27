package mini.blog.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mini.blog.desafio.molde.Autor;
import mini.blog.desafio.service.AutorService;

@RestController
@RequestMapping("/Autor")
public class AutorController {
	@Autowired
	private AutorService autorService;
	
	@PostMapping("/salvar")
	public Autor salvar(@RequestBody Autor autor) {
		autor=autorService.salvar(autor);
		return autor;
	}
}
