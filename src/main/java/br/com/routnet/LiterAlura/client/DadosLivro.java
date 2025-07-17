package br.com.routnet.LiterAlura.client;

import br.com.routnet.LiterAlura.model.Livro;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosLivro {
    private String title;
    @JsonAlias("languages")
    private List<String> idiomas;
    private int download_count;
    private List<DadosAutor> authors;

    public Livro toLivro() {
        Livro livro = new Livro();
        livro.setTitulo(title);
        livro.setIdioma(idiomas != null && !idiomas.isEmpty() ? idiomas.get(0) : "desconhecido");
        livro.setDownloads(download_count);
        if (authors != null && !authors.isEmpty()) {
            livro.setAutor(authors.get(0).toAutor());
        }
        return livro;
    }

    // Getters e Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public List<String> getIdiomas() { return idiomas; }
    public void setIdiomas(List<String> idiomas) { this.idiomas = idiomas; }
    public int getDownload_count() { return download_count; }
    public void setDownload_count(int download_count) { this.download_count = download_count; }
    public List<DadosAutor> getAuthors() { return authors; }
    public void setAuthors(List<DadosAutor> authors) { this.authors = authors; }
}