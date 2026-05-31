# Stock+ Gestão de Patrimônio

> **Projeto Prático: Desenvolvimento para a Disciplina de Linguagem de Programação II (LP2)**

> **Curso: Análise e Desenvolvimento de Sistemas (ADS) — IFSul Campus Venâncio Aires**

---

## Sobre o Projeto

O Stock+ é um sistema de gestão de patrimônio projetado para controlar e organizar de forma eficiente a distribuição de bens materiais dentro de uma instituição ou empresa. O software mapeia a estrutura física através do cadastro de espaços e gerencia os itens alocados em cada um deles, refletindo cenários reais como a organização de bens dentro de salas de aula ou setores administrativos.

---

## Tecnologias Utilizados

- Linguagem: Java
- Paradigma: Orientação a Objetos (POO)
- Interface Gráfica: JavaFX
- Banco de Dados: MySQL

---

## Funcionalidades Principais

O sistema conta com operações completas de CRUD (Cadastrar, Visualizar, Alterar e Excluir) para duas entidades principais que se relacionam entre si:

### 1. Gestão de Espaços
Permite o gerenciamento de locais físicos (como salas de aula e laboratórios). Cada espaço possui os seguintes atributos:
- Código do espaço
- Nome
- Descrição
- Número

### 2. Gestão de Itens (Bens)
Permite o controle individual de cada patrimônio cadastrado no sistema. Cada bem possui os seguintes atributos:
- Código do bem
- Categoria
- Nome
- Descrição
- Valor
- Data de aquisição
- Estado de conservação

### 3. Relacionamento e Vínculo Patrimonial
A arquitetura do sistema foi projetada para suportar um relacionamento de um para muitos (1:N), onde um único espaço físico pode possuir e agrupar múltiplos itens patrimoniais em seu interior.

---

## Pré-Requisitos para Execução do Projeto: 

- Java Development Kit (JDK) compatível com a versão do projeto
- JavaFX SDK configurado na sua IDE ou ambiente de execução
- Servidor MySQL ativo
- (Desenvolvimento e testes realizados em plataforma Mac Silicon)
Colocar Banco src/database

  ---

### Clonar o Repositório:

git clone https://github.com/Alysson-afb/nome-do-repositorio.git
