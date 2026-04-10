# Changelog

Todas as mudanças notáveis na API do **Agora System** serão documentadas neste arquivo.

O formato é baseado no [Keep a Changelog](https://keepachangelog.com/pt-BR/1.1.0/).

---

## [Unreleased]

### Added
- Controllers (`ProductController`, `SellerController`, `ListingController`) anotados com *@RestController* e seus mapeamentos de rotas base. 
- Interfaces (`ProductService`, `SellerService`, `ListingService`) e suas respectivas classes de implementação. 
- Interfaces Spring Data JPA (`ProductRepository`, `SellerRepository`, `ListingRepository`) estendendo *JpaRepository*.
- Classes de mapeamento (`@Component`) para realizar a conversão segura entre Entidades e DTOs.
- Atributos de status através de Enums (`ListingStatus` com **OPEN**/**CLOSED** e `SellerStatus` com **ACTIVE**/**DEACTIVATED**).
- Classes `Product`, `Seller` e `Listing` com seus respectivos atributos e anotações.
- Schema Flyway inicial para a criação das tabelas, estruturando os relacionamentos e chaves estrangeiras.
- Arquivo **application.example.yaml** configurado com as propriedades do PostgreSQL, Hibernate e ativação do Flyway.

### Changed
- Injeção de dependência via atributo (`@Autowired`) pela injeção via construtor utilizando `@RequiredArgsConstructor` do Lombok, garantindo maior segurança e imutabilidade das dependências.
- `Controllers` e `Services` foram atualizados para trafegar exclusivamente DTOs em vez de retornar as Entidades JPA mapeadas, blindando o banco de dados e padronizando as respostas HTTP.