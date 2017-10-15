### Arquitetura

A aplicação foi desenvolvida em [Spring boot](https://projects.spring.io/spring-boot/) usando alguns dos seus starters (WEB, JPA), os dados estão sendo salvos em memória, porém usando um banco de dados que é o [H2](http://www.h2database.com/html/main.html), os testes foram desenvolvidos usando a nova versão do [JUnit](http://junit.org/junit5/) e a documentação para uso das api's foi utilizado o [Swagger](https://swagger.io/).

### Subindo a aplicação

mvn spring-boot:run

Acesse o swagger para usar as api's http://localhost:8080/swagger-ui.html.

Acessar a base de dados http://localhost:8080/h2
