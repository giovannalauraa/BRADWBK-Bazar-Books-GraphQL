# Projeto BazarBooks 

## Descrição

O **BazarBooks** é uma API desenvolvida com Spring Boot Com suporte às abordagens REST e GraphQL, o sistema oferece funcionalidades completas para CRUD de entidades e integração com banco de dados MySQL.

---

## Integrantes e Responsabilidades

### Ana Laura

* Criação da entidade `Author`

### Évelin
* Criação da entidade `Address`

### Giovanna

* Criação da entidade `Notification`

### Soraya

* Criação das entidades `Cart` e `Cart_Item`

---

## 🚀 Como Executar o Projeto

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/bazarbooks.git
```

2. Navegue até o diretório do projeto e instale as dependências:

```bash
cd bazarbooks
mvn clean install
```

3. Configure o banco de dados em `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bazarbooks
spring.datasource.username=root
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
```

4. Execute a aplicação:

```bash
mvn spring-boot:run
```

5. Acesse:

* REST: `http://localhost:8080` (caso tenha controladores REST)
* GraphQL: `http://localhost:8080/graphql`

---

## 📌 Exemplo de Mutation GraphQL

```graphql
mutation {
  createAuthor(name: "J.K. Rowling") {
    id
    name
  }
}
```

---

Projeto desenvolvido como parte da avaliação prática individual do bimestre. ✅
