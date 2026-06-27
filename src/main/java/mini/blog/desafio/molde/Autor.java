package mini.blog.desafio.molde;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy = "autor")
	List<Post> posts= new ArrayList<>();
	public Long getId() {
		return id;
	}
	public List<Post> getPosts() {
		return posts;
	}
	
}
