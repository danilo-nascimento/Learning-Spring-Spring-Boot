# Introdução ao Spring Boot

## Definições

- POJO: Plain old Java Object
- JavaBeans: Objetos simples com getters e setters
- Spring Beans: POJOs configurados no contexto da aplicação
- DTO: Bean usado para state estado entre layers
- Utiliza o Tomcat como servidor por padrão

## Inverse of Control (IoC)

É um design pattern conhecido pela Sigla IoC é um Pattern que prega para usarmos o controle das instancias de uma determinada classe ser tratada externamente e não dentro da classe em questão, ou seja, Inverter o controle de uma classe delegando para uma outra classe, interface, componente, serviço, etc.

## O que é um boilerplate

Um conjunto de códigos padrão que são utilizados sempre


## TODO

- [ ] [Artigo com exemplo JS para melhor entendimento do IoC](https://blog.codecasts.com.br/dependency-injection-container-javascript-49e9eb2c399c)
- [ ] [Artigo com exemplos de IoC](http://www.linhadecodigo.com.br/artigo/3418/inversao-de-controle-ioc-e-injecao-de-dependencia-di-diferencas.aspx)
- [ ] O que são Servlets
- [ ] O que são JPA e Hibernates
- [ ] [Spring Data](https://spring.io/projects/spring-data)
- [ ] org.springframework.stereotype.Repository ?
- [ ] Anotações do Spring
- [ ] application.properties
- [ ] [@Autowired](https://blog.algaworks.com/injecao-de-dependencias-com-spring/)
- [ ] [Aspect Oriented Programming](https://docs.spring.io/spring-framework/docs/2.5.x/reference/aop.html)

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

Os bancos de dados incorporados não devem ser usados ​​para cargas de trabalho de produção, pois eles duram apenas enquanto o aplicativo.

Os arquivos referentes ao banco de dados (data.sql e schema.sql) devem ficar em: src/main/resources

Para utilizar o banco de dados, adicione no arquivo application.properties:
```
spring.jpa.hibernate.ddl-auto=none
logging.level.org.springframework.jdbc.datasource.init.ScriptUtils=debug
# Log do banco de dados
logging.level.org.hibernate.engine.jdbc.env.internal.LobCreatorBuilderImpl=error
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

### Gerenciamento do banco de dados

O PostgreSQL precisa estar instalado e com o PATH configurado para usar scripts bash

[Instalar PostgreSQL no Ubuntu](https://www.postgresql.org/download/linux/ubuntu/)

[Solução para o Erro 'http://apt.postgresql.org/pub/repos/apt focal-pgdg InRelease' doesn't support architecture 'i386'](https://askubuntu.com/questions/1230969/skipping-acquire-of-configured-file-in-ubuntu-20-04-lts)

#### Qual a configuração para acessar dados do banco?

1. Crie uma classe responsável pela entidade
1. Na classe, defina a tabela da entidade com as anotações:
    . 
    ```java
    @Entity
    @Table(name = {tableName})
    ``` 
1. No body da classe use as anotações para definir as características da coluna:
    
    ```java
    @Id // No caso de ser a chave primária
    @Column(name = {columnName})
    @GenerateValue(strategy = GenerationType.{Option}) // Uma opção é AUTO. Precisa ver documentação das opções para 
    private {dataType} {fieldName};
    // Caso esteja pegando data do SQL, importe o pacote java.sql.date
    ```
1. Adicione os getters e setters à classe
1. Crie uma interface que extenda CrudRepository:
    
    A classe CrudRepository recebe a classe da entidade criada anteriormente e o tipo de dado da chave primária:

    ```java
    public interface {interfaceName} extends CrudRepository< {entityClass} , {foreinerKey} > {

    }
    ```
1. Adicione a classe principal (com a anotação SpringBootApplications) as anotações e classe controller:

    ```java
    @RestController
    @RequestMapping({endpoint})
    public class {entityName}Controller {
        @AutoWired
        private {entityRepository} {entityRepositoryField}

        @GetMapping
        public Iterable<{entityClass}> get{entityName} {
            return this.{entityRepositoryField}.findAll();
        }
    }
    ```
#### PostgreSQL

Adicione a dependência que irá gerenciar o banco de dados no pom.xml

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
</dependency>
```

Adicione as propriedades no arquivo application.properties:
```
spring.jpa.database=postgresql
spring.datasource.platform=postgres
spring.datasource.url=jdbc:postgresql://localhost:5432/dev
spring.datasource.username=postgres
spring.datasource.password=postgres
```

***

São utilizadas anotações para definir:
- **Gerenciamento do banco de dados:**
  - Entidades
  - Colunas
  - Chaves Primárias
  - etc
- **REST**
  - Verbos
  - Recursos (Endpoints)