# Desafio Back-End Nubank

![Foto de Capa](img/foto-de-capa.png)

[![licence mit](https://img.shields.io/badge/licence-MIT-blue.svg)](./LICENSE)
[![Conventional Commits](https://img.shields.io/badge/Conventional%20Commits-1.0.0-%23FE5196?logo=conventionalcommits&logoColor=white)](https://conventionalcommits.org)

## Sumário
- [Desafio Back-End Nubank](#desafio-back-end-nubank)
  - [Sumário](#sumário)
  - [Introdução](#introdução)
    - [Requisitos Técnicos](#requisitos-técnicos)
    - [Requisitos de Código](#requisitos-de-código)
    - [Diferenciais (Não obrigatórios)](#diferenciais-não-obrigatórios)
  - [Tecnologias Usadas](#tecnologias-usadas)
  - [Licença](#licença)

## Introdução
Construa uma API REST para gerenciamento de clientes e seus contatos. Cada cliente pode ter um ou mais contatos associados.

### Requisitos Técnicos

A aplicação deve conter:

- Cadastro de Cliente: `POST /clientes`
- Cadastro de Contato associado a um cliente existente: `POST /contatos`
- Listagem de todos os clientes com seus contatos: `GET /clientes`
- Listagem de contatos de um cliente específico: `GET /clientes/{id}/contatos`
- Uso do **Spring Boot** + **Spring Data JPA**
- Banco de Dados **PostgreSQL**
- Entidades **Cliente** e **Contato** com relacionamento `@OneToMany` / `@ManyToOne`

### Requisitos de Código

Esperamos que o código siga boas práticas de desenvolvimento, incluindo:

- Separação de responsabilidades (`controller`, `service`, `repository`)
- Uso de **DTOs** para entrada e saída de dados
- Tratamento adequado de erros
- Uso de **Lombok**

### Diferenciais (Não obrigatórios)

- Uso de **Docker** para subir o PostgreSQL
- **Testes automatizados**
- Documentação com **Swagger**

## Tecnologias Usadas
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)&nbsp;
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)&nbsp;
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-007396?style=for-the-badge&logo=hibernate&logoColor=white)&nbsp;
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-336791?style=for-the-badge&logo=postgresql&logoColor=white)&nbsp;
![Lombok](https://img.shields.io/badge/Lombok-FF0000?style=for-the-badge&logo=lombok&logoColor=white)&nbsp;
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)&nbsp;

# API de Gerenciamento de Clientes e Contatos

Uma API REST desenvolvida em Spring Boot para gerenciamento de clientes e seus contatos, seguindo as melhores práticas de desenvolvimento.

---

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **Validation API**
- **Docker**

---

## Estrutura do Projeto
```
desafio-nubank/
├── src/main/java/io/github/eduardopec/desafio_nubank/
│ ├── controller/ # Camada de controle
│ │ ├── ClienteController.java
│ │ ├── ContatoController.java
│ │ └── exceptions/ # Tratamento de exceções
│ ├── service/ # Camada de serviço
│ │ ├── ClienteService.java
│ │ ├── ContatoService.java
│ │ └── exceptions/ # Exceções de negócio
│ ├── repository/ # Camada de persistência
│ │ ├── ClienteRepository.java
│ │ └── ContatoRepository.java
│ ├── model/ # Entidades JPA
│ │ ├── Cliente.java
│ │ └── Contato.java
│ ├── model/dto/ # Objetos de transferência
│ │ ├── ClienteRequestDTO.java
│ │ ├── ClienteResponseDTO.java
│ │ ├── ContatoRequestDTO.java
│ │ └── ContatoResponseDTO.java
│ └── DesafioNubankApplication.java
├── src/main/resources/
│ └── application.yml # Configurações da aplicação
└── README.md
```

---

## Arquitetura

A aplicação segue o padrão **MVC** com separação de responsabilidades:

- **Controller**: Recebe requisições HTTP e retorna respostas
- **Service**: Contém a lógica de negócio
- **Repository**: Responsável pela persistência de dados
- **DTO**: Padrão para transferência de dados entre camadas
- **Entity**: Representação das tabelas do banco de dados

**Camadas organizadas seguindo princípios de Clean Architecture**, garantindo baixo acoplamento e alta coesão entre componentes.

---

## Endpoints da API

### Clientes

| Método | Endpoint | Descrição | Status de Sucesso |
|--------|----------|-----------|------------------|
| `POST` | `/clientes` | Cadastrar novo cliente | `201 Created` |
| `GET` | `/clientes` | Listar todos os clientes | `200 OK` |
| `GET` | `/clientes/{id}` | Buscar cliente por ID | `200 OK` |

### Contatos

| Método | Endpoint | Descrição | Status de Sucesso |
|--------|----------|-----------|------------------|
| `POST` | `/contatos` | Cadastrar novo contato | `201 Created` |
| `GET` | `/contatos` | Listar todos os contatos | `200 OK` |
| `GET` | `/contatos/cliente/{clienteId}` | Listar contatos de um cliente | `200 OK` |

---

### Tratamento de Erros
- `404 Not Found` → Recurso não encontrado  
- `409 Conflict` → Recurso duplicado  
- `422 Unprocessable Entity` → Erros de validação de campos  

**Exemplo de resposta de erro:**
```json
{
  "timestamp": "2025-11-10T14:22:01Z",
  "status": 422,
  "error": "Dados inválidos",
  "message": "Um ou mais campos estão inválidos",
  "path": "/clientes"
}
```

---

## 🧩 Banco de Dados

- **Banco:** PostgreSQL  
- **Porta:** `5433`  
- **Database:** `clientmanager`  
- **Usuário:** `postgres`  
- **Senha:** `postgres`

> As configurações podem ser alteradas no arquivo [`application.yaml`](src/main/resources/application.yaml).

---

## Como Executar o Projeto

### Clonar o repositório
```bash
git clone https://github.com/EduardoPec/desafio-backend-nubank.git
cd desafio-backend-nubank
```

# Compilar e executar
```
./mvnw spring-boot:run
```

# Ou compilar primeiro
```
./mvnw clean compile
./mvnw spring-boot:run
```

---

### Pré-requisitos
- Java 17 ou superior
- Maven 3.6+
- PostgreSQL

---


## Licença
Este projeto está sob a [Licença MIT](./LICENSE.md). Consulte o arquivo [LICENSE.md](LICENSE.md) para obter mais detalhes.
