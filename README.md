# CRUD de Clientes API

Este projeto é uma API REST desenvolvida com Spring Boot para gerenciar clientes. A API permite buscar, cadastrar, atualizar e remover clientes, garantindo validações e tratamento de erros adequado.

## 📌 Funcionalidades

- 🔍 **Busca paginada de clientes**
- 🔍 **Busca de cliente por ID**
- ➕ **Cadastro de um novo cliente**
- ✏️ **Atualização de um cliente existente**
- ❌ **Remoção de um cliente**
- ⚠️ **Tratamento de erros e validação de dados**

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database** (banco de dados em memória para testes)
- **Maven** (gerenciamento de dependências)

## 🔥 Endpoints da API

### 🧑 Clientes

#### 🔍 Listar todos os clientes (paginado)

**GET /clients?page=0&size=6&sort=name**\
Retorna uma lista paginada de clientes.

#### 🔍 Buscar um cliente por ID

**GET /clients/{id}**\
Retorna os detalhes do cliente especificado.

#### ➕ Cadastrar um novo cliente

**POST /clients**

```json
{
 "name": "Maria Silva",
 "cpf": "12345678901",
 "income": 6500.0,
 "birthDate": "1994-07-20",
 "children": 2
}
```

#### ✏️ Atualizar um cliente existente

**PUT /clients/{id}**

```json
{
 "name": "Maria Silva",
 "cpf": "12345678901",
 "income": 6500.0,
 "birthDate": "1994-07-20",
 "children": 2
}
```

#### ❌ Remover um cliente

**DELETE /clients/{id}**

## ⚠️ Tratamento de Erros

- **404 - Recurso não encontrado** (quando o ID informado não existe)
- **422 - Erro de validação** (quando um campo obrigatório está vazio ou inválido)
- **400 - Erro de integridade referencial** (quando há problemas ao deletar um cliente)

## 🛠️ Como Executar o Projeto

### **Pré-requisitos:**

- Java 17 instalado
- Maven instalado

### **Passos para execução:**

1. Clone o repositório:

```sh
git clone https://github.com/SEU_USUARIO/CRUD-clientes.git
```

2. Acesse a pasta do projeto:

```sh
cd CRUD-clientes
```

3. Execute o projeto com Maven:

```sh
mvn spring-boot:run
```

4. Acesse a API no navegador ou Postman:

```
http://localhost:8080/clients
```

---

Este projeto segue as boas práticas de desenvolvimento e está pronto para ser testado e validado! 🚀

