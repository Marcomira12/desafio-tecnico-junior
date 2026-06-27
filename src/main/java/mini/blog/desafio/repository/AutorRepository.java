package mini.blog.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mini.blog.desafio.molde.Autor;
@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

}
