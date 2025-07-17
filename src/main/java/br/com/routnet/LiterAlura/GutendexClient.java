package br.com.routnet.LiterAlura;

import br.com.routnet.LiterAlura.dto.DadosAPI;
import br.com.routnet.LiterAlura.dto.DadosLivro;
import br.com.routnet.LiterAlura.model.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GutendexClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String URL = "https://gutendex.com/books/?search=";

    public Livro buscaLivroPorTitulo(String titulo) {
        ResponseEntity<DadosAPI> response = restTemplate.getForEntity(URL + titulo, DadosAPI.class);
        if (response.getBody() != null && !response.getBody().results().isEmpty()) {
            DadosLivro dadosLivro = response.getBody().results().get(0);
            return dadosLivro.toLivro();
        }
        return null;
    }
}



