Sistema Bancário - Aplicando Padrões de Projeto
Este projeto é uma simulação de um sistema bancário simples desenvolvido com Spring Boot e os padrões de projeto Chain of Responsibility, Proxy e Facade.

Objetivo
Demonstrar a aplicação prática de padrões de projeto em um cenário real de operações bancárias, como saque, usando boas práticas de arquitetura.

Estrutura do Projeto
1. BancoController
Endpoint REST para operações bancárias
Rota: POST /api/banco/sacar
2. BancoService
Orquestra o fluxo entre controller, repositórios e fachada
3. BancoFacade
Aplica o padrão Facade
Encapsula a execução de regras de negócio de forma simples para o serviço
4. Handlers da Chain of Responsibility
Handler	Responsabilidade
AutenticacaoHandler	Verifica se o cliente está autenticado
SaldoHandler	Verifica se há saldo suficiente na conta
LimiteDiarioHandler	Verifica se o valor ultrapassa o limite diario
5. ServicoBancarioProxy
Aplica o padrão Proxy para controlar o acesso à lógica de negócio
6. ServicoBancarioReal
Realiza de fato a operação bancária
Como Executar
Execute com:
mvn spring-boot:run
Os testes automáticos rodam ao iniciar a aplicação:
[RESULTADO 1] Operação realizada com sucesso.
[RESULTADO 2] Operação bloqueada por segurança.
[RESULTADO 3] Operação bloqueada por segurança.
Acesse também via REST usando ferramentas como Postman:
POST /api/banco/sacar
{
  "clienteId": 1,
  "valor": 200.0
}
Tecnologias Utilizadas
Java 17
Spring Boot 3.4.5
Spring Web
Spring Data JPA
H2 Database (em memória)
Lombok
Swagger / Springdoc
Padrões Aplicados
✅ Facade
Oculta a complexidade dos processos bancários.

✅ Chain of Responsibility
Permite validar as regras de forma desacoplada e flexível.

✅ Proxy
Controla o acesso ao serviço real e registra logs.

Autor
David Rodrigues - Projeto para estudos de arquitetura com padrões de projeto em Java.

Screenshots
(Adicionar prints do terminal ou Postman aqui se desejar.)

Melhorias Futuras
Persistência real em banco PostgreSQL
Autenticação com Spring Security
Testes unitários e integração
Swagger completo para documentação REST
