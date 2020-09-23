<p align="center">
   <img src="./.github/logo.png" alt="Reddit" width="280"/>
</p>

<p align="center">	
   <a href="https://www.linkedin.com/in/nikolaslacerda/">
      <img alt="Nikolas Lacerda" src="https://img.shields.io/badge/-Nikolas Lacerda-FF4300?style=flat&logo=Linkedin&logoColor=white" />
   </a>
  
  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/nikolaslacerda/reddit-clone?color=FF4300">
  
  <img alt="Repository size" src="https://img.shields.io/github/repo-size/nikolaslacerda/reddit-clone?color=FF4300">
  
  <a href="https://github.com/nikolaslacerda/reddit-clone/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/nikolaslacerda/reddit-clone?color=FF4300">
  </a> 
  
  <img alt="License" src="https://img.shields.io/badge/license-MIT-FF4300">
  
</p>

<p align="center">
 <a href="#computer-projeto">Projeto</a> •
    <a href="#art-layout">Layout</a> •
 <a href="#rocket-tecnologias">Tecnologias</a> •
 <a href="#construction_worker-como-executar">Como executar</a>
</p>

## :computer: Projeto

Um pequeno clone do Reddit construído usando Spring Boot, Spring Security com autenticação JWT, Spring Data JPA com PostgreSQL e Spring MVC. O frontend foi construído usando Angular. 

O projeto explora as principais funcionalidades do Reddit, como a criação de subreddits, posts, comentários e votos.

O projeto está hospedado no Heroku e pode ser acessado clicando [aqui](https://web-reddit-clone.herokuapp.com).

## :art: Layout

Home | Post
---|---
| ![home](.github/home-page.png) | ![post](.github/post-page.png) 

Profile | Create Subreddit
---|---
| ![profile](.github/profile-page.png) | ![subreddit](.github/create-subreddit-page.png) | 

## :rocket: Tecnologias

Esse projeto foi desenvolvido com as seguintes tecnologias:

- [Java 8](https://www.java.com/en/)
- [Spring Boot 2.2](https://spring.io/projects/spring-boot)
- [Spring Security](https://spring.io/projects/spring-security)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Hibernate](https://hibernate.org)
- [PostgreSQL](https://www.postgresql.org)
- [Maven](https://maven.apache.org)
- [Angular](https://angular.io)
- [Angular CLI](https://cli.angular.io)
- [Bootstrap](https://getbootstrap.com)

## :construction_worker: Como executar


#### :repeat: Clone o Repositório

```bash

$ git clone https://github.com/nikolaslacerda/reddit-clone.git

```

#### :package: Executando a API

```bash

# Acesse a pasta do server no terminal/cmd:

$ cd reddit-clone/reddit

# Instale as dependências:

$ mvn install

# Execute a aplicação:

$ mvn spring-boot:run

```

O servidor iniciará na porta 8080 - acesse http://localhost:8080

#### :computer: Executando a aplicação web

```bash

# Acesse a pasta web no terminal/cmd:

$ cd reddit-clone/web

# Instale as dependências:

$ npm install

# Execute a aplicação:

$ ng serve

```

A aplicação iniciará na porta 4200 - acesse http://localhost:4200
