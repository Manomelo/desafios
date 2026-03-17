# desafio-magalu-backend

# Magalu - Desafio de Programação

Este é um desafio de desenvolvimento de software que testa sua capacidade de construir uma API REST com agendamento de comunicações, integrando diferentes partes de um sistema backend!

## 1. Introdução

Sua missão, caso você aceite, é criar uma API REST que permita **agendar, consultar e cancelar envios de comunicações**. Para este desafio, a API deve ser criada utilizando-se de Java e Spring Boot, com persistência em banco de dados relacional.

Um bom lugar para se começar é o [Spring Starter](https://start.spring.io/).

>**Dica:** Não existe uma forma certa ou errada de resolver o desafio! Vamos avaliar coisas como a qualidade do seu código, o quão fácil é de compreender o código, organização do projeto, quantidade e qualidade dos testes, preocupação com segurança e vários outros fatores :)

## 2. Definição do desafio

Neste desafio você deve **criar uma API REST** no [GitHub](https://github.com/) ou [GitLab](https://gitlab.com/). **Leia com atenção todas as instruções a seguir!**

### 2.1. Restrições Técnicas

Seu projeto:

- **DEVE** estar no [GitHub](https://github.com/) ou [GitLab](https://gitlab.com/)
- **NÃO DEVE** fazer _fork_ de nenhum outro projeto
- **DEVE** ter pelo menos 1 commit por cada endpoint (mínimo de 3 commits)
    - Queremos ver a evolução do seu projeto com o tempo ;)
- Todos os commits **DEVEM** ser feitos pelo mesmo usuário que criou o projeto
- **DEVE** seguir exatamente os _endpoints_ descritos a seguir
- **DEVE** aceitar e responder com objetos exatamente como descritos a seguir
- **DEVE** utilizar um banco de dados relacional (como MySQL, PostgreSQL, H2, ...) para persistência
- **DEVE** aceitar e responder apenas com [JSON](https://www.json.org/json-pt.html)

>**Atenção!** Por motivos de segurança, não podemos aceitar projetos enviados como arquivos. Você **DEVE** disponibilizar seu projeto publicamente para que possamos acessá-lo e corrigi-lo! Após receber uma resposta de nós, sinta-se livre para tornar seu projeto **privado** :)

### 2.2. Endpoints da API

A seguir serão especificados os endpoints que devem estar presentes na sua API e a funcionalidade esperada de cada um deles.

#### 2.2.1. Agendar Comunicação: `POST /api/agendamento`

Este é o endpoint que irá receber e registrar um novo agendamento de comunicação. Cada agendamento consiste de um `destinatario`, uma `mensagem`, um `tipoComunicacao` e uma `dataHoraEnvio`:

```json
{
    "destinatario": "exemplo@email.com",
    "mensagem": "Olá! Sua consulta está confirmada.",
    "tipoComunicacao": "EMAIL",
    "dataHoraEnvio": "2026-04-01T10:00:00"
}
```

Os campos no JSON acima significam o seguinte:

| Campo             | Significado                                                              | Obrigatório? |
|-------------------|--------------------------------------------------------------------------|--------------|
| `destinatario`    | **Endereço de destino** da comunicação (e-mail, número, token, etc.)     | Sim          |
| `mensagem`        | **Conteúdo** da mensagem a ser enviada                                   | Sim          |
| `tipoComunicacao` | **Canal de envio**: `EMAIL`, `SMS`, `PUSH` ou `WHATSAPP`                 | Sim          |
| `dataHoraEnvio`   | **Data/Hora** em que a comunicação deve ser enviada (deve ser futura)    | Sim          |

A API só aceitará agendamentos que:

1. Tenham todos os campos obrigatórios preenchidos
2. A `dataHoraEnvio` **DEVE** ser uma data futura
3. O `tipoComunicacao` **DEVE** ser um dos valores válidos do enum: `EMAIL`, `SMS`, `PUSH`, `WHATSAPP`

Como resposta, espera-se que este endpoint responda com:

- `200 OK` com o corpo do agendamento criado
    - Um JSON com os campos `id`, `destinatario`, `mensagem`, `tipoComunicacao`, `dataHoraEnvio`, `statusAgendamento` e `criadoEm`
    - O `statusAgendamento` deve ser iniciado como `AGENDADO`
- `400 Bad Request` sem nenhum corpo
    - A API não compreendeu a requisição do cliente (por exemplo: um JSON inválido ou campos inválidos)

#### 2.2.2. Consultar Agendamento: `GET /api/agendamento/{id}`

Este endpoint deve retornar os dados de um agendamento específico pelo seu `id`.

Como resposta, espera-se que este endpoint responda com:

- `200 OK` com os dados do agendamento

```json
{
    "id": 1,
    "destinatario": "exemplo@email.com",
    "mensagem": "Olá! Sua consulta está confirmada.",
    "tipoComunicacao": "EMAIL",
    "dataHoraEnvio": "2026-04-01T10:00:00",
    "statusAgendamento": "AGENDADO",
    "criadoEm": "2026-03-17T09:00:00"
}
```

Os campos no JSON acima significam o seguinte:

| Campo                | Significado                                                                   | Obrigatório? |
|----------------------|-------------------------------------------------------------------------------|--------------|
| `id`                 | **Identificador único** do agendamento                                        | Sim          |
| `destinatario`       | **Endereço de destino** da comunicação                                        | Sim          |
| `mensagem`           | **Conteúdo** da mensagem                                                      | Sim          |
| `tipoComunicacao`    | **Canal de envio**: `EMAIL`, `SMS`, `PUSH` ou `WHATSAPP`                      | Sim          |
| `dataHoraEnvio`      | **Data/Hora** agendada para o envio                                           | Sim          |
| `statusAgendamento`  | **Status atual**: `AGENDADO`, `ENVIADO`, `CANCELADO` ou `CONFIRMADO`          | Sim          |
| `criadoEm`           | **Data/Hora** em que o agendamento foi criado                                 | Sim          |

- `404 Not Found` sem nenhum corpo
    - Nenhum agendamento foi encontrado com o `id` informado

#### 2.2.3. Cancelar Agendamento: `DELETE /api/agendamento/{id}`

Este endpoint deve **remover** um agendamento pelo seu `id`.

Como resposta, espera-se que este endpoint responda com:

- `204 No Content` sem nenhum corpo
    - O agendamento foi removido com sucesso
- `404 Not Found` sem nenhum corpo
    - Nenhum agendamento foi encontrado com o `id` informado

## 4. Extras

Vamos propor a seguir alguns desafios extras caso você queira testar seus conhecimentos ao máximo! Nenhum desses requisitos é obrigatório, mas são desejados e podem ser um diferencial!

1. **Testes automatizados:** Sejam unitários e/ou funcionais, testes automatizados são importantes e ajudam a evitar problemas no futuro. Se você fizer testes automatizados, atente-se na efetividade dos seus testes! Por exemplo, testar apenas os "caminhos felizes" não é muito efetivo.
2. **Containerização:** Você consegue criar meios para disponibilizar sua aplicação como um container? _OBS: Não é necessário publicar o container da sua aplicação!_
3. **Logs:** Sua aplicação informa o que está acontecendo enquanto ela trabalha? Isso é útil para ajudar as pessoas desenvolvedoras a solucionar eventuais problemas que possam ocorrer.
4. **Observabilidade:** Sua API tem algum endpoint para verificação da saúde da aplicação (healthcheck)?
5. **Tratamento de Erros:** O Spring Boot dá às pessoas desenvolvedoras ferramentas para se melhorar o tratamento de erros padrão. Você consegue alterar os erros padrão para retornar _quais_ erros ocorreram?
6. **Documentação da API:** Você consegue documentar sua API? Existem [ferramentas](https://swagger.io/) e [padrões](http://raml.org/) que podem te ajudar com isso!
7. **Documentação do Sistema:** Sua aplicação provavelmente precisa ser construída antes de ser executada. Você consegue documentar como outra pessoa que pegou sua aplicação pela primeira vez pode construir e executar sua aplicação?
8. **Cancelamento lógico:** Em vez de remover fisicamente o registro do banco, você consegue apenas alterar o `statusAgendamento` para `CANCELADO`?