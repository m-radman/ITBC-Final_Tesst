# IT Bootcamp QA - Završni test

## Tekst projekta

### I deo
Za [DemoQA sajt](https://demoqa.com/) napisati test plan u `Excel`-u ili editoru po izboru.  
Ne mora svaki napisan test case da bude automatizovan.  
Napraviti sekciju sa `bug`-ovima ili `improvement`-ima po potrebi.

### II deo
Napraviti novi `Maven`/`Java` projekat pod imenom _ITBC_project_imeprezime_ i uneti sve potrebne biblioteke.  
Automatizovati neke od napisanih `case`-eva.

### III deo
Napraviti `Postman` kolekciju za [DemoQA Swagger API](https://demoqa.com/swagger/#/).
___

## Izrada projekta

### Opis test slučajeva i bugova

Opisi svih testova kao i prijavljenih bagova mogu se naći na lokaciji [src/manual_test/projekat_manual.xlsx](./src/manual_test/projekat_manual.xlsx).


### Implementacija testova

Test fajlove možete pogledati [ovde](https://github.com/m-radman/ITBC_project_MilosRadman/tree/master/src/main/java/tests)  
Page Object fajlove možete pogledati [ovde](https://github.com/m-radman/ITBC_project_MilosRadman/tree/master/src/main/java/pages)


### Pokretanje `Selenium` testova

Za pokretanje testova potrebno je pokrenuti TestNG .xml fajl:
- [myTests.xml](https://github.com/m-radman/ITBC_project_MilosRadman/blob/master/myTests.xml)


Sve PO klase nalaze se [src/main/java/pages](./src/main/java/pages).

### `Postman` kolekcija

API testovi nalazi se na lokaciji [src/postman_tests/BookStoreAPI.postman_collection](./src/postman_tests/BookStoreAPI.postman_collection)
