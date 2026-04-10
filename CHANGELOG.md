# Changelog

Todas as mudanças notáveis na API do **Agora System** serão documentadas neste arquivo.

O formato é baseado no [Keep a Changelog](https://keepachangelog.com/pt-BR/1.1.0/).

---

## [Unreleased]

### Added
- Controllers (`ProductController`, `SellerController`, `ListingController`) anotados com *@RestController* e seus mapeamentos de rotas base. 
- Interfaces (`ProductService`, `SellerService`, `ListingService`) e suas respectivas classes de implementação. 
- Interfaces Spring Data JPA (`ProductRepository`, `SellerRepository`, `ListingRepository`) estendendo *JpaRepository*.
- Enums ListingStatus com os estados OPEN e CLOSED.
- Classes `Product`, `Seller` e `Listing` com seus respectivos atributos e anotações.
- Schema Flyway inicial **V202604091524__create_table.sql** para a criação das tabelas, estruturando os relacionamentos e chaves estrangeiras.
- Arquivo **application.example.yaml** configurado com as propriedades do PostgreSQL, Hibernate e ativação do Flyway.