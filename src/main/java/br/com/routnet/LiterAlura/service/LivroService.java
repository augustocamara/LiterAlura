package br.com.routnet.LiterAlura.service;

import br.com.routnet.LiterAlura.client.GutendexClient;
import br.com.routnet.LiterAlura.model.Livro;
import br.com.routnet.LiterAlura.repository.AutorRepository;
import br.com.routnet.LiterAlura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {
    @Autowired private LivroRepository livroRepo;
    @Autowired private AutorRepository autorRepo;
    @Autowired private GutendexClient client;

    public void buscarSalvarLivro(String titulo) {
        Optional<Livro> livroExistente = livroRepo.findByTituloIgnoreCase(titulo);
        if (livroExistente.isPresent()) {
            System.out.println("⚠️ O livro \"" + titulo + "\" já está cadastrado no banco de dados.");
            System.out.println(livroExistente.get());
            return;
        }
        Livro livro = client.buscaLivroPorTitulo(titulo);
        if (livro != null) {
            livroRepo.save(livro);
            System.out.println("✅ Livro salvo com sucesso!");
            System.out.println(livro);
        } else {
            System.out.println("❌ Livro não encontrado na API.");
        }
    }

    public void listarTodosLivros() {
        livroRepo.findAll().forEach(System.out::println);
    }

    public void listarLivrosPorIdioma(String idioma) {
        livroRepo.findByIdioma(idioma).forEach(System.out::println);
    }

    public void listarAutores() {
        autorRepo.findAll().forEach(System.out::println);
    }

    public void listarAutoresVivosNoAno(int ano) {
        autorRepo.findByAnoNascimentoLessThanEqualAndAnoFalecimentoGreaterThanEqualOrAnoFalecimentoIsNullOrderByNomeAsc(ano, ano)
                .forEach(System.out::println);
    }
    public void listarAutoresVivosComLivros(int ano) {
        var autores = autorRepo
                .findByAnoNascimentoLessThanEqualAndAnoFalecimentoGreaterThanEqualOrAnoFalecimentoIsNullOrderByNomeAsc(ano, ano);

        if (autores.isEmpty()) {
            System.out.println("Nenhum autor encontrado vivo no ano " + ano);
            return;
        }

        for (var autor : autores) {
            System.out.println("\n👤 " + autor);
            var livros = livroRepo.findAll().stream()
                    .filter(l -> l.getAutor() != null && l.getAutor().getId().equals(autor.getId()))
                    .toList();

            if (livros.isEmpty()) {
                System.out.println("  📚 Nenhum livro cadastrado para este autor.");
            } else {
                livros.forEach(livro -> System.out.println("  📖 " + livro.getTitulo()));
            }
        }
    }

}


