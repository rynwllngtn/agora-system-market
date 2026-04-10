package dev.rynwllngtn.agorasystem.mappers.product;

import dev.rynwllngtn.agorasystem.dtos.product.ProductCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.product.ProductResponseDTO;
import dev.rynwllngtn.agorasystem.entities.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponseDTO toResponseDTO(Product product) {
        return new ProductResponseDTO(product.getId(),
                                      product.getName(),
                                      product.getDescription());
    }

    public Product toEntity(ProductCreateRequestDTO createRequestDTO) {
        return new Product(createRequestDTO.name(),
                           createRequestDTO.description());
    }

}