package br.com.routnet.LiterAlura.dto;

import br.com.routnet.LiterAlura.model.Autor;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosAutor {
    private String name;

    @JsonAlias("birth_year")
    private Integer nascimento;

    @JsonAlias("death_year")
    private Integer falecimento;

    public Autor toAutor() {
        Autor autor = new Autor();
        autor.setNome(name);
        autor.setAnoNascimento(nascimento);
        autor.setAnoFalecimento(falecimento);
        return autor;
    }

    // Getters e Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getNascimento() { return nascimento; }
    public void setNascimento(Integer nascimento) { this.nascimento = nascimento; }
    public Integer getFalecimento() { return falecimento; }
    public void setFalecimento(Integer falecimento) { this.falecimento = falecimento; }
}
