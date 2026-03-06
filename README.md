
# 📚 Biblioteca API - Spring Boot

## 🎯 Objetivo da atividade
Com base no diagrama da Biblioteca apresentado em aula, esta aplicação foi desenvolvida em **Spring Boot** para representar as entidades **Usuário**, **CarteiraBiblioteca** e **Empréstimo**, respeitando os relacionamentos definidos no modelo.

A API permite:
- Criar, listar, atualizar e excluir **Usuários**.
- Criar e associar uma **CarteiraBiblioteca** a um Usuário (**relacionamento 1:1**).
- Registrar **Empréstimos** para um Usuário (**relacionamento 1:N**).
- Listar os **Empréstimos** de um determinado usuário.
- CRUD completo para **Usuário** e **Empréstimo**.
- **CarteiraBiblioteca** apenas com criação (POST).

---

## 🏗️ Modelagem das Entidades

### Usuário (`UserEntity`)
- `id`
- `name`
- `email` (único)
- `password`
- Relacionamento **1:1** com `LibraryWalletEntity`
- Relacionamento **1:N** com `LoanEntity`

### CarteiraBiblioteca (`LibraryWalletEntity`)
- `libraryWalletNumber`
- `emissionDate`
- `isValid`
- Relacionamento **1:1** com `UserEntity`

### Empréstimo (`LoanEntity`)
- `id`
- `loanDate`
- `returnDate` (pode ser `null` até devolução)
- Relacionamento **N:1** com `UserEntity`

---

## 🔗 Relacionamentos
- **Usuário ↔ CarteiraBiblioteca** → 1:1
- **Usuário ↔ Empréstimo** → 1:N

---

## 🚀 Endpoints

### Usuário
- `POST /user/create` → Criar usuário
- `GET /user/find/{id}` → Buscar usuário por ID
- `PUT /user/update/{id}` → Atualizar usuário
- `DELETE /user/delete/{id}` → Excluir usuário

### CarteiraBiblioteca
- `POST /wallet/create/{userId}` → Criar carteira vinculada a um usuário

### Empréstimo
- `POST /loan/create/{userId}` → Criar empréstimo para um usuário
- `GET /loan/list/{userId}` → Listar todos os empréstimos de um usuário
- `PUT /loan/return/{userId}/{loanId}` → Registrar devolução de um empréstimo

---

## 📌 Exemplos de Requisição

### Criar Usuário
```json
POST /user/create
{
  "name": "João Silva",
  "email": "joao@email.com",
  "password": "123456"
}
```

### Criar Carteira
```http
POST /wallet/create/1
```

### Criar Empréstimo
```http
POST /loan/create/1
```

### Devolver Empréstimo
```http
PUT /loan/return/1/5
```

---

## 🛠️ Tecnologias Utilizadas
- Java 25
- Spring Web
- Spring Data JPA
- MySQL driver
- Lombok
- Validation
- DevTools

---

## ✅ Conclusão
Este projeto demonstra a compreensão de:
- Modelagem de entidades e relacionamentos com JPA.
- Criação de endpoints REST utilizando Spring Boot.
- Implementação de regras de negócio como **todo usuário deve ter uma carteira** e **empréstimos vinculados a usuários**.  
