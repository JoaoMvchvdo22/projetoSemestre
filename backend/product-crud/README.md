# API Rest - Email Sender

## Para rodar essa aplicação é nescessário:

- Java SDK 17
- [Intellij IDEA Community](https://www.jetbrains.com/pt-br/idea/) (suggested)
- [Lombok plugin](https://projectlombok.org/)

## Como rodar localmente:

- Entrar no localhost:8080/h2-console e configurar a datasource url para:
  - datasource.url=jdbc:h2:mem:product-crud

## ENDPOINTS:

  - GET localhost:8080/product (retorna todos os prdutos cadastarados)

  - POST localhost:8080/product (cria produto //usar request body json como exemplo abaixo)
    - {
         "name":"Nome do produto",
         "description":"Descrição do produto",
         "price":10000
      }
  
  - PUT localhost:8080/product/{id} (Atualiza o produto do id informado // usar request body json como exemplo abaixo)
    - {
          "name":"Nome do produto",
          "description":"Descrição do produto",
          "price":10000
      } 