# ERP System API

API REST de um sistema ERP desenvolvido com Java e Spring Boot, simulando um fluxo básico de gestão de usuários, produtos, estoque e pedidos.

## Sobre o projeto

Esse projeto foi desenvolvido com foco em prática de backend, principalmente modelagem de dados e construção de APIs REST com Spring Boot.

A aplicação simula um ERP simples, com operações de cadastro, autenticação e gerenciamento de pedidos, incluindo relacionamento entre entidades e controle de estoque.

## Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Security
- JWT (JSON Web Token)
- Hibernate
- H2 Database
- Maven

## Funcionalidades

- Cadastro e gerenciamento de usuários
- Autenticação com JWT
- CRUD de produtos
- Controle de estoque vinculado a produtos
- Criação e gerenciamento de pedidos
- Associação de pedidos com itens e pagamento
- Cálculo de total do pedido
- Relacionamentos entre entidades (1:1, 1:N, N:N)
- Tratamento global de exceções

## Autenticação

A API utiliza autenticação via JWT.

Fluxo:
- Usuário faz login
- Token JWT é gerado
- Token deve ser enviado nas requisições protegidas

Header obrigatório:

Authorization: Bearer <token>

## Endpoints principais

Autenticação:
POST /auth/login  
POST /auth/register  

Usuários:
GET /usuarios  
GET /usuarios/{id}  
POST /usuarios  
PUT /usuarios/{id}  
DELETE /usuarios/{id}  

Produtos:
GET /produtos  
GET /produtos/{id}  
POST /produtos  
PUT /produtos/{id}  
DELETE /produtos/{id}  

Estoque:
GET /estoque/{id}  
POST /estoque  
PUT /estoque/{id}  

Pedidos:
GET /pedidos  
GET /pedidos/{id}  
POST /pedidos  
PUT /pedidos/{id}  
DELETE /pedidos/{id}  

## Como rodar o projeto

Clonar o repositório:
git clone https://github.com/tailer0549/spring-boot-erp-api.git  

Entrar na pasta:
cd spring-boot-erp-api  

Rodar a aplicação:
./mvnw spring-boot:run  

## Acesso

Aplicação:
http://localhost:8080  

Console H2:
http://localhost:8080/h2-console  

## Observações

Projeto focado no desenvolvimento de backend com Spring Boot, com ênfase em arquitetura em camadas, modelagem de dados e construção de APIs REST com autenticação JWT.
