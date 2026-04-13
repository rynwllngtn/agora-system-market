# Agora Market (API)

![Java](https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.5-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Status](https://img.shields.io/badge/Status-EM%20EVOLUÇÂO-success?style=for-the-badge)

O **Agora Market** é o microsserviço de comércio do ecossistema Agora.  
Responsável por gerir as regras de negócio de vendedores, catálogos de produtos e o ciclo de vida dos anúncios.

---

## Tecnologias utilizadas


![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)  
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
 A aplicação e suas dependências são orquestradas como infraestrutura fechada via conteinerização.  
![Flyway](https://img.shields.io/badge/Flyway-CC0202?style=for-the-badge&logo=flyway&logoColor=white)
 Garante que cada mudança no banco de dados seja rastreável, imutável e reproduzível em qualquer ambiente via migrações automáticas.  
![OpenAPI](https://img.shields.io/badge/OpenAPI-6BA539?style=for-the-badge&logo=openapi-initiative&logoColor=white)
 Define o contrato da API de forma interativa, assegurando que o Front-end ou outros microsserviços consigam consumir os recursos sem ambiguidade.

---

## Endpoints da API

A API foi desenhada utilizando **Sub-recursos de Ação** para as alterações de estado crítico, refletindo intenções de negócio inegáveis.

### Vendedores (`/sellers`)
| Método  | Rota                       | Descrição                                                           |
|---------|----------------------------|---------------------------------------------------------------------|
| `POST`  | `/sellers`                 | Registra um novo vendedor no marketplace.                           |
| `GET`   | `/sellers/{id}`            | Consulta os dados do vendedor.                                      |
| `PATCH` | `/sellers/{id}/deactivate` | Executa a suspendendo a conta, evitando o delete no banco de dados. |
| `PATCH` | `/sellers/{id}/reactivate` | Restaura as permissões do vendedor.                                 |

### Produtos (`/products`)
| Método | Rota             | Descrição                                 |
|--------|------------------|-------------------------------------------|
| `POST` | `/products`      | Adiciona um novo produto ao catálogo.     |
| `GET`  | `/products/{id}` | Retorna os detalhes do produto.           |

### Anúncios (`/listings`)
| Método  | Rota                       | Descrição                                            |
|---------|----------------------------|------------------------------------------------------|
| `POST`  | `/listings`                | Cria um anúncio vinculando um produto a um vendedor. |
| `GET`   | `/listings/{id}`           | Retorna os detalhes do anúncio.                      |
| `PATCH` | `/sellers/{id}/deactivate` | Encerra o anúncio antecipadamente.                   |
| `PATCH` | `/sellers/{id}/reactivate` | Restaura o anúncio.                                  |

*(Nota: Consulte a interface do Swagger localmente para visualizar todos os parâmetros, filtros de paginação e esquemas de resposta).*

## Exemplos de Cargas

Com a adoção dos `records`, os payloads de entrada e saída são enxutos e validados.  
Operações de alteração de estado não exigem envio do objeto completo.

**Criação de Vendedor (`POST /sellers`)**
```json
{
   "owner": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
   "name": "Ryan Wellington"
}
```

*(Nota: As rotas de `PATCH` em `/sellers` não requerem corpo na requisição, pois a intenção já está clara na própria URL).*

**Criação de Produto (`POST /products`)**
```json
{
   "name": "Notebook",
   "description": "A barely used notebook with 32GBs of RAM!"
}
```

**Criação de Anúncio (`POST /listing`)**
```json
{
   "sellerId": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
   "productId": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
   "stock": 1,
   "price": 500
}
```

*(Nota: As rotas de `PATCH` em `/listings` não requerem corpo na requisição, pois a intenção já está clara na própria URL).*

---

## Como testar a aplicação localmente?

Este ecossistema está preparado para rodar em qualquer máquina sem necessidade de instalar o Java ou o PostgreSQL no sistema operacional hospedeiro.  
Toda a compilação e execução é gerenciada pelo Docker Compose utilizando Multi-Stage Builds.

**Pré-requisitos:** [Docker Desktop](https://www.docker.com/products/docker-desktop/) ou motor do Docker instalado na sua máquina.

**1. Clone o repositório:**
```bash
git clone https://github.com/rynwllngtn/agora-market.git
```

**2. Containerize o banco de dados e a API simultaneamente com um único comando na raiz do projeto:**
```bash
docker-compose up -d --build
```

**3. Acesse a Interface e Documentação:**
- **Documentação OpenAPI (Swagger UI):** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- **Base da API REST:** `http://localhost:8080`

**Para encerrar o ambiente:**
Quando terminar, derrube os contêineres e libere a memória RAM da sua máquina utilizando:
```bash
docker-compose down
```