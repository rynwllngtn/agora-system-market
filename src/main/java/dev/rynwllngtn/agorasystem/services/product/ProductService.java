package dev.rynwllngtn.agorasystem.services.product;

import dev.rynwllngtn.agorasystem.dtos.product.ProductCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.product.ProductResponseDTO;
import dev.rynwllngtn.agorasystem.entities.product.Product;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface ProductService {

    Product findById(UUID id);
    ProductResponseDTO getResponseById(UUID id);

    ProductResponseDTO insert(ProductCreateRequestDTO createRequestDTO);

}