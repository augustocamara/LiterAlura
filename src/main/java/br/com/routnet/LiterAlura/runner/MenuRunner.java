package br.com.routnet.LiterAlura.runner;

import br.com.routnet.LiterAlura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuRunner implements CommandLineRunner {

    @Autowired
    private LivroService service;

    @Override
    public void run(String... args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Buscar e salvar livro por título");
            System.out.println("2. Listar todos os livros");
            System.out.println("3. Listar livros por idioma");
            System.out.println("4. Listar autores");
            System.out.println("5. Listar autores vivos em um ano");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Título do livro: ");
                    String titulo = sc.nextLine();
                    service.buscarSalvarLivro(titulo);
                }
                case 2 -> service.listarTodosLivros();
                case 3 -> {
                    System.out.print("Idioma: ");
                    String idioma = sc.nextLine();
                    service.listarLivrosPorIdioma(idioma);
                }
                case 4 -> service.listarAutores();
                case 5 -> {
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();
                    service.listarAutoresVivosComLivros(ano);
                }

                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}
