package mini.blog.desafio.molde;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	@OneToMany(mappedBy = "autor")
	@JsonIgnore
	List<Post> posts= new ArrayList<>();
	public Long getId() {
		return id;
	}
	public List<Post> getPosts() {
		return posts;
	}
	
}
