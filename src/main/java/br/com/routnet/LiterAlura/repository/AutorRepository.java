package br.com.routnet.LiterAlura.repository;


import br.com.routnet.LiterAlura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByAnoNascimentoLessThanEqualAndAnoFalecimentoGreaterThanEqualOrAnoFalecimentoIsNullOrderByNomeAsc(Integer ano1, Integer ano2);
}
