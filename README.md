# Automação de Testes de API com Rest Assured
Desafio de projeto do Bootcamp **GFT Quality Assurance para Mulheres** oferecido pela **DIO** em parceira com o **Grupo GFT**.<br/>

Objetivo: Criar uma collection com Postman, automatizar testes de API utilizando o framework RestAssured + JUnit e gerar reports com o Allure Framework.
<br/><br/><br/>

API usada como base: <a href="https://restful-booker.herokuapp.com/apidoc/index.html#api-Booking"> Restful-booker</a> <br/>
Linguagem: Java <br/>
IDE: IntelliJ <br/>
Bibliotecas e frameworks: Rest Assured, JUnit, Allure Framework<br/>
Outras ferramentas: Postman
<br/><br/>

**1º Passo realizado: Criar collection com Postman**
- Criei a collection Restful-booker com 3 folders: Auth, Booking e Ping
- Com um total de 8 requests, contemplando todos os endpoints descritos na documentação:
  - POST -> Auth - CreateToken
  - GET -> Booking - GetBookingIds
  - GET -> Booking - GetBooking
  - POST -> Booking - CreateBooking
  - PUT -> Booking - UpdateBooking
  - PATCH -> Booking - PartialUpdateBooking
  - DELETE -> Booking - DeleteBooking
  - GET -> Ping - HealthCheck
- Apliquei testes no escopo collection: response time e header
- Apliquei testes em cada request: status code e body response text
- Exportei a collection e adicionei a esse repositório
<br/><br/>

**2º Passo realizado: Automatizar os testes de API com Rest Assured + JUnit**
- Criei o projeto restful-booker-api-automation-tests
- Utilizei PageObjects para organizar minhas classes e testes
- Criei 7 testes com asserções variadas:
  - POST -> createToken_ValidData_ReturnOK
  - GET -> getBookingIds_ReturnOK
  - GET -> getBookingById_ReturnOK
  - POST -> createBooking_ReturnOK
  - PUT -> updateBooking_WithoutAuthorization_Return403
  - PUT -> updateBooking_ValidData_ReturnOK
  - DELETE - deleteBooking_ReturnOK
<br/><br/>

**3º Passo realizado: Gerar um relatório de testes com Allure Report**
 - Configurei o POM com os plugins e dependências necessárias
 - Gerei o relatório com Allure Report:
   - Overview:
   ![image](https://user-images.githubusercontent.com/102275682/214165145-bec6d2a8-9160-4eff-867b-8f5b9869dab2.png)
   - Suites:
   ![image](https://user-images.githubusercontent.com/102275682/214165316-74d30f28-8f85-424c-87f5-49c3167d5948.png)


  
