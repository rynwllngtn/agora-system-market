package dev.rynwllngtn.agorasystem.repositories.product;

import dev.rynwllngtn.agorasystem.dtos.product.ProductResponseDTO;
import dev.rynwllngtn.agorasystem.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query(value = """
                   SELECT NEW dev.rynwllngtn.agorasystem.dtos.product.ProductResponseDTO(p.id, p.name, p.description)
                   FROM Product AS p
                   WHERE p.id = :id
                   """)
    Optional<ProductResponseDTO> getResponseById(@Param("id") UUID id);


}