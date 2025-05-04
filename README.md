# 💰 Sistema Bancário - Padrões de Projeto Chain of Responsibility, Proxy e Facade

Este projeto demonstra a aplicação de **três padrões de projeto** no contexto de um sistema bancário:

- **Chain of Responsibility**: para validação de operações em etapas (autenticação, saldo e limite).
- **Proxy**: para controle de acesso ao serviço bancário real.
- **Facade**: para abstrair a complexidade de chamadas múltiplas e facilitar a execução da operação.

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **H2 Database (em memória)**
- **Lombok**
- **Swagger/OpenAPI** (Springdoc)

---

## 🛠️ Padrões Implementados

### 🔗 Chain of Responsibility
Utilizado para processar requisições de forma sequencial e desacoplada:
- `AutenticacaoHandler`
- `SaldoHandler`
- `LimiteDiarioHandler`

### 🕵️ Proxy
Controle de acesso e logging de operações:
- `ServicoBancarioProxy` protege o `ServicoBancarioReal`

### 🎭 Facade
Interface simples para executar toda a lógica:
- `BancoFacade` centraliza a lógica de validações e execução da operação.

---

## 📦 Como rodar o projeto

1. Clone o repositório:

```bash
git clone https://github.com/odavid062/sistema-bancario-padroes-chain-proxy-facade.git
```

2. Acesse a pasta do projeto:

```bash
cd sistema-bancario-padroes-chain-proxy-facade/Sistema
```

3. Execute com Maven:

```bash
./mvnw spring-boot:run
```
ou
```bash
mvn spring-boot:run
```

---

## 🧪 Testes de Execução

A aplicação faz três testes automaticamente no `CommandLineRunner`:

1. **Saque válido** (cliente autenticado, valor dentro do saldo e do limite)
2. **Saque acima do limite diário** (bloqueado)
3. **Cliente não autenticado** (bloqueado)

---

## 🧠 Autor

Desenvolvido por **David Rodrigues** como parte dos estudos de padrões de projeto com Spring Boot.

---

## 📜 Licença

Este projeto está sob a licença MIT.
