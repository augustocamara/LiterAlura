# 📚 Gutendex Catalog - Sistema de Gerenciamento de Livros e Autores

Este é um projeto desenvolvido em Java com Spring Boot que consome a API pública do [Gutendex](https://gutendex.com/), armazena livros e autores em um banco de dados PostgreSQL e permite consultas interativas via linha de comando (CLI). Ele utiliza a biblioteca **Jackson** para o mapeamento de dados JSON para objetos Java e **Spring Data JPA** para persistência.

---

## 🔧 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Jackson (para desserialização JSON)
- IntelliJ IDEA
- Maven

---

## 🚀 Funcionalidades

### 📖 1. Buscar livro por título

- Consulta a API Gutendex com base no título fornecido.
- Se o livro já estiver cadastrado no banco de dados, o sistema informa que já existe.
- Armazena os dados do livro e do autor (caso ainda não existam).
- Exibe o resultado com formatação:

```
----- LIVRO -----
Título: Emma
Autor: Austen, Jane
Idioma: en
Número de Downloads: 5564
```

---

### 📚 2. Listar todos os livros

- Mostra todos os livros já buscados e armazenados no banco de dados.

---

### 🌍 3. Listar livros por idioma

- Permite filtrar todos os livros de acordo com o idioma em que foram escritos.
- Considera apenas o primeiro idioma da lista retornada pela API.

---

### 🧑‍💼 4. Listar todos os autores

- Exibe uma listagem com todos os autores cadastrados no sistema.
- Formato de exibição:

```
----- AUTOR -----
Nome: Jane Austen
Nascimento: 1775
Falecimento: 1817
```

---

### 📅 5. Listar autores vivos em determinado ano (com livros)

- Usuário insere um ano, e o sistema lista todos os autores vivos naquele ano, junto com seus livros, **ordenados por título**:

```
----- AUTOR -----
Nome: Jane Austen
Nascimento: 1775
Falecimento: 1817

Livros:
📖 Emma
📖 Pride and Prejudice
```

---

## 🗂 Estrutura do Projeto

```plaintext
src
└── main
    ├── java
    │   └── com.exemplo.gutendex
    │       ├── model
    │       │   ├── Livro.java
    │       │   └── Autor.java
    │       ├── repository
    │       │   ├── LivroRepository.java
    │       │   └── AutorRepository.java
    │       ├── service
    │       │   └── LivroService.java
    │       ├── dto
    │       │   ├── DadosAutor.java
    │       │   ├── DadosLivro.java
    │       │   └── DadosApi.java
    │       ├── LiterAluraApplication.java
    │       └── GutendexClient.java
    └── resources
        └── application.properties
```

---

## 🛠 Como Executar o Projeto

1. **Configure o banco PostgreSQL** com uma base chamada `gutendex`.
2. Atualize o `application.properties` com suas credenciais:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/gutendex
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. **Rode a aplicação no IntelliJ** ou outro IDE.
4. O menu será exibido no console:

```
1 - Buscar livro por título
2 - Listar livros
3 - Listar livros por idioma
4 - Listar autores
5 - Listar autores vivos em determinado ano
0 - Sair
```

---

## 🧪 Testes e Validações

- Validação de duplicação de livros por título.
- Consulta segura de autores e livros sem exceções.
- Correção do problema de N+1 selects com uso de `findByAutorId`.
- Layout de exibição claro e organizado no terminal.

---

## 💡 Melhorias Futuras

- Integração com interface gráfica (Swing ou Web).
- Paginação e ordenação nas consultas.
- Integração com cache local para reduzir chamadas à API externa.

---

## 👨‍💻 Autor

Desenvolvido por **José Augusto da Silva Câmara**  
Email: augustocamara4@gmail.com  
LinkedIn: [https://www.linkedin.com/in/augusto-c%C3%A2mara-desenvolvedor/]

---

## 📝 Licença

Este projeto é open-source para fins educacionais.
