package mini.blog.desafio.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mini.blog.desafio.molde.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	List<Post> findByAutorId(Long id);
}
