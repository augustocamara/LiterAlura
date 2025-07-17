📚 Gutendex Catálogo
Projeto Java com Spring Boot que permite buscar livros e autores a partir da API pública Gutendex, armazená-los em um banco de dados PostgreSQL e realizar consultas interativas pelo terminal.

✅ Funcionalidades
🔎 Busca de livro por título na API Gutendex e persistência dos dados no banco de dados.

📄 Listagem de todos os livros salvos.

🌍 Filtragem de livros por idioma.

👤 Listagem de todos os autores cadastrados.

📅 Consulta de autores vivos em determinado ano.

🧠 Tecnologias Utilizadas
Java 17+

Spring Boot 3

Spring Data JPA

Jackson (mapeamento JSON)

PostgreSQL

API Gutendex

Maven

⚙️ Configuração do Ambiente
Banco de dados: PostgreSQL

Crie um banco de dados chamado gutendex:

sql
Copiar
Editar
CREATE DATABASE gutendex;
Configure o arquivo application.properties:

properties
Copiar
Editar
spring.datasource.url=jdbc:postgresql://localhost:5432/gutendex
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Instale as dependências via Maven:

bash
Copiar
Editar
mvn clean install
Execute o projeto:

bash
Copiar
Editar
mvn spring-boot:run
🖥️ Como Utilizar
Ao iniciar o sistema, será exibido um menu interativo no terminal:

markdown
Copiar
Editar
==== MENU ====
1. Buscar e salvar livro por título
2. Listar todos os livros
3. Listar livros por idioma
4. Listar autores
5. Listar autores vivos em um ano
0. Sair
   Exemplos de uso:
   Buscar livro por título: Digite 1 e insira o título do livro, como Sherlock Holmes.

Filtrar por idioma: Digite 3 e insira o idioma em código ISO (ex: en, pt, fr).

Autores vivos em determinado ano: Digite 5 e informe um ano como 1900.

🧩 Estrutura de Entidades
📘 Livro
id: Long

titulo: String

idioma: String (apenas o primeiro idioma listado)

downloads: Integer

autor: Autor

👤 Autor
id: Long

nome: String

anoNascimento: Integer

anoFalecimento: Integer (pode ser null)

🔄 Exemplo de JSON recebido da API
json
Copiar
Editar
{
"title": "The Adventures of Sherlock Holmes",
"languages": ["en"],
"download_count": 12000,
"authors": [
{
"name": "Arthur Conan Doyle",
"birth_year": 1859,
"death_year": 1930
}
]
}
