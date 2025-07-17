package br.com.routnet.LiterAlura.repository;

import br.com.routnet.LiterAlura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByIdioma(String idioma);
    Optional<Livro> findByTituloIgnoreCase(String titulo);
    List<Livro> findByAutorId(Long autorId);


}

