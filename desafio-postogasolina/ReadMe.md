# Desafio Técnico Júnior #1 – Cadastro e Consulta de Abastecimentos

## ■ Objetivo

Desenvolver uma aplicação simples em **Java** para cadastro e consulta de abastecimentos em um posto de combustível, com armazenamento em banco de dados e exibição dos dados via **Java Swing** ou **API REST**.

---

## ■ Funcionalidades Implementadas

**■ Operações básicas (Criar, Listar, Alterar, Deletar) de Tipos de Combustível:**
- Nome - Texto
- Preço por litro

**■ Operações básicas (Criar, Listar, Alterar, Deletar) de Bombas de Combustível** (relacionadas a um tipo de combustível):
- Nome da bomba
- Combustível que abastece

**■ Operações básicas (Criar, Listar, Alterar, Deletar) de Abastecimentos** (com data, volume abastecido e valor total):
- Bomba que foi realizado o abastecimento
- Data do abastecimento
- Quantidade em valores
- Litragem

**■** Consulta de todos os dados cadastrados (via Java Swing ou API)  
**■** Persistência dos dados (ao menos em tempo de execução)

---

## ■ Requisitos Atendidos

- Projeto Java com estrutura organizada (usando Maven ou Gradle)
- Relacionamentos entre entidades corretamente implementados
- Interface gráfica Java Swing ou API HTTP para cadastro e consulta
- Código comentado e organizado

---

## ■ Diferenciais Implementados

- API RESTful simples com rotas GET, POST, PUT
- Boas práticas de organização de código (DAO, camada de serviço, etc.)
- Persistência dos dados (em caso de restart da aplicação manter os dados)

---

## ■ O que será avaliado

- Sua comunicação, especialmente ao surgir dúvidas ou obstáculos durante o desenvolvimento.
- O processo de desenvolvimento como um todo, e não apenas o resultado final.
- A clareza e organização dos commits realizados.
- Sua capacidade de estruturar a solução em etapas, mesmo que nem todos os requisitos sejam concluídos.

---

## ■ Dicas para se sair bem

- Divida o desafio em pequenas partes e implemente com calma, focando em cada funcionalidade por vez.
- Use commits claros e objetivos, indicando exatamente o que foi alterado ou implementado.
- Em caso de dúvida, comunique-se — mostrar que você sabe buscar soluções é um ponto positivo.
- Mesmo que não finalize 100% dos requisitos, a qualidade do seu processo será levada em conta.