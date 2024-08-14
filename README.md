# AWS SES Email Service - Uber Coding Challenge

Este repositório contém a implementação do desafio de Serviço de Email (SES) desafio da Uber utilizando AWS SES, Spring Boot e Java. Pode ser consultado [neste link](https://github.com/uber-archive/coding-challenge-tools/blob/master/coding_challenge.md).

## Descrição do Projeto

Este projeto é uma API RESTful que permite o envio de e-mails utilizando o Amazon SES (Simple Email Service). A aplicação foi desenvolvida utilizando o framework Spring Boot e o SDK da Amazon para integração com o SES.

## Estrutura do Projeto

O projeto está organizado da seguinte maneira:

- **adapters**: Contém a interface que define o contrato para envio de e-mails.
  - `EmailSenderGateway`: Interface responsável por definir o método `sendEmail(String to, String subject, String body);` para envio de e-mails.

- **application**: Contém a lógica de negócio.
  - `EmailSenderService`: Implementa a lógica de envio de e-mails, utilizando a interface `EmailSenderGateway`.

- **controller**: Contém os controladores REST.
  - `EmailSenderController`: Controlador REST responsável por receber as requisições de envio de e-mail e chamar o serviço `EmailSenderService`.

- **core**: Contém classes centrais da aplicação, como exceções, DTOs e casos de uso.
  - `EmailRequest`: DTO (Data Transfer Object) usado para receber os dados do e-mail via API.
  - `EmailSenderUserCase`: Interface que define o contrato de envio de e-mail dentro do caso de uso.
  - **exceptions**: Pacote que contém as classes de exceções customizadas da aplicação.

- **infra**: Contém as configurações e implementações de infraestrutura, como a integração com o Amazon SES.
  - `AWSSesConfig`: Classe de configuração do AWS SES.
  - `ses`: Pacote que contém a implementação específica do envio de e-mails usando o SES da AWS.
    - `SesEmailSender`: Implementação concreta da interface `EmailSenderGateway` para enviar e-mails usando o SES.

## Tecnologias Utilizadas

- **Java 22**
- **Spring Boot**
- **Amazon SES (Simple Email Service)**
- **Amazon SDK**
- **Maven**

## Funcionalidades

- Envio de e-mails através do Amazon SES.
- API RESTful com endpoints para enviar e-mails.

## Como Executar o Projeto

### Pré-requisitos

- JDK 22+
- Maven
- Conta na AWS com acesso ao SES configurado

### Configuração do AWS SES

1. Configure suas credenciais da AWS no arquivo `application.properties` ou através de variáveis de ambiente:
    ```properties
    aws.accessKeyId=YOUR_ACCESS_KEY
    aws.secretKey=YOUR_SECRET_KEY
    aws.region=YOUR_AWS_REGION
    ```

2. Verifique se o serviço SES está configurado corretamente na sua conta AWS.

### Executando o Projeto

1. Clone o repositório:
    ```bash
    git clone https://github.com/seu-usuario/seu-repositorio.git
    ```
    
2. Navegue até o diretório do projeto:
    ```bash
    cd seu-repositorio
    ```

3. Compile e execute o projeto utilizando Maven:
    ```bash
    mvn spring-boot:run
    ```

4. A API estará disponível em `http://localhost:8080/api/email`.

### Enviando um E-mail

Faça uma requisição POST para o endpoint `/api/email` com o seguinte JSON:

```json
{
    "to": "destinatario@example.com",
    "subject": "Assunto do E-mail",
    "body": "Corpo do e-mail"
}
```

Exemplo usando `curl`:
```bash
curl -X POST http://localhost:8080/api/email \
    -H "Content-Type: application/json" \
    -d '{
        "to": "destinatario@example.com",
        "subject": "Assunto do E-mail",
        "body": "Corpo do e-mail"
    }'
```



