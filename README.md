# Sistema Acadêmico para Cadastro de Alunos, Notas e Boletins (Java - MVC)

Sistema de Cadastro de Alunos, Notas, Faltas e Geração de Boletins desenvolvido em Java com o padrão de arquitetura MVC (Model-View-Controller).

## 📌 Sobre o Projeto

Este projeto consiste em uma aplicação Java desktop que permite gerenciar o cadastro de alunos de forma simples e eficiente. Desenvolvido com foco em organização de código e boas práticas, o sistema segue a arquitetura MVC para facilitar a manutenção e escalabilidade do código.

### 🔧 Funcionalidades

- Cadastro de alunos
- Registro de notas
- Controle de faltas
- Geração de boletins
- Integração com banco de dados
- Operações completas de CRUD (Create, Read, Update, Delete)

## 🧩 Arquitetura MVC

O sistema está dividido em três camadas principais:

- **Model:** Representa os dados e a lógica de negócio (ex: classes `Aluno`, `Curso`, `Boletim`, etc.).
- **View:** Interface gráfica desenvolvida com `JFrame` e `JPanel`.
- **Controller:** Responsável pela comunicação entre a interface e os dados, controlando toda a lógica da aplicação.

## 🗃️ Banco de Dados

O sistema realiza conexões com banco de dados (ex: MySQL) para persistência dos dados dos alunos, cursos, notas e boletins. A estrutura permite inserção, atualização, remoção e listagem de registros com total integração à interface gráfica.

## 📸 Prints do Projeto

### Tela Principal do Sistema  
![Tela Principal do Sistema](https://img001.prntscr.com/file/img001/my1mMGl6S-an2kbOwUZeAA.png)

### Tela de Preenchimento do Curso  
![Tela de Preenchimento do Curso](https://img001.prntscr.com/file/img001/kWefjL_ZSZOwSocFZ0ErjA.png)

### Lançamento de Notas e Faltas  
![Lançamento de Notas e Faltas](https://img001.prntscr.com/file/img001/FQHTGWb8RAKA0aVwL8ULtQ.png)

### Geração do Boletim  
![Geração do Boletim](https://img001.prntscr.com/file/img001/yqHhYjinTEOWRpKGVYd3Qg.png)

## 🚀 Tecnologias Utilizadas

- Java SE
- Swing (GUI)
- JDBC (conexão com banco de dados)
- IDE: Eclipse
- Padrão MVC
