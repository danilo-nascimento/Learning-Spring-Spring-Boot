# Introdução ao Spring Boot

## Definições

- POJO: Plain old Java Object
- JavaBeans: Objetos simples com getters e setters
- Spring Beans: POJOs configurados no contexto da aplicação
- DTO: Bean usado para state estado entre layers

## Inverse of Control (IoC)

É um design pattern conhecido pela Sigla IoC é um Pattern que prega para usarmos o controle das instancias de uma determinada classe ser tratada externamente e não dentro da classe em questão, ou seja, Inverter o controle de uma classe delegando para uma outra classe, interface, componente, serviço, etc.

## O que é um boilerplate

Um conjunto de códigos padrão que são utilizados sempre


## TODO

- [ ] [Artigo com exemplo JS para melhor entendimento](https://blog.codecasts.com.br/dependency-injection-container-javascript-49e9eb2c399c)
- [ ] [Artigo com exemplos](http://www.linhadecodigo.com.br/artigo/3418/inversao-de-controle-ioc-e-injecao-de-dependencia-di-diferencas.aspx)
- [ ] O que são Servlets
- [ ] O que são JPA e Hibernates
- [ ] [Spring Data](https://spring.io/projects/spring-data)
- [ ] org.springframework.stereotype.Repository ?
- [ ] Anotações do Spring
- [ ] application.properties

## Porque usar Spring Boot

![Motivos de uso](imagens/porque-usar-spring-boot-001.png)

![Components chaves](imagens/componentes-chaves-001.png)

![Configuração inicial](imagens/exemplo-configuracao-inicial-001.png)

Após gerar o arquivo compactado, descompacte no diretório de destino e importe o projeto na IDE.

Para adicionar a index.html:
- crie o arquivo em src/resources/static
- No terminal, execute o comando para gerar o arquivo .jar:

```
mvn clean package
```

- Para executar o jar e iniciar o servidor, execute o comando:
```
java -jar target/{fileName}.jar
```
A anotação que define o ponto de partida do Spring é @SpringBootAplication:

```java
@SpringBootApplication
public class SpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApplication.class, args);
	}

}
```

## Spring Data

Os arquivos referentes ao banco de dados (data.sql e schema.sql) devem ficar em: src/main/resources

Para utilizar o banco de dados, adicione no arquivo application.properties:
```
spring.jpa.hibernate.ddl-auto=none
logging.level.org.springframework.jdbc.datasource.init.ScriptUtils=debug
```
Execute o comando para atualizar o banco de dados:
```
mvn clean package
```
Ele funciona com banco de dados SQL ou NoSQL

As classes, interfaces, etc que são referentes aos dados, devem ficar dentro do seus próprios pacotes data:

```java
package com.danilo.nascimento.learningspring.data.entity;
package com.danilo.nascimento.learningspring.data.repository;
```

São utilizadas anotações para definir:
- **Gerenciamento do banco de dados:**
  - Entidades
  - Colunas
  - Chaves Primárias
  - etc
- **REST**
  - Verbos
  - Recursos (Endpoints)