# Esse é um projeto sobre a construção de uma API RESTful 👨‍💻


```
Realizei este projeto com as seguintes tecnologias:

Java - SpringBoot (JPA, PostgreSQL Driver, Lombok, Dev Tools)
Gradle - Gerenciador de dependências
PostgreSQL - Banco de Dados
RailWay - Hospedagem
Figma - Design do projeto
MVC e Design Patterns
```



## Diagrama de Classes (Domínio da API)

```mermaid
classDiagram
  class User {
    -String name
    -Account account
    -Feature[] features
    -Card card
    -News[] news
  }

  class Account {
    -String number
    -String agency
    -Number balance
    -Number limit
  }

  class Feature {
    -String icon
    -String description
  }

  class Card {
    -String number
    -Number limit
  }

  class News {
    -String icon
    -String description
  }

  User "1" *-- "1" Account
  User "1" *-- "N" Feature
  User "1" *-- "1" Card
  User "1" *-- "N" News
```



```

```