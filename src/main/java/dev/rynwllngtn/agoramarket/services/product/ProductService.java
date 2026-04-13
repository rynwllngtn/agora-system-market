package dev.rynwllngtn.agoramarket.services.product;

import dev.rynwllngtn.agoramarket.dtos.product.ProductCreateRequestDTO;
import dev.rynwllngtn.agoramarket.dtos.product.ProductResponseDTO;
import dev.rynwllngtn.agoramarket.entities.product.Product;

import java.util.UUID;

public interface ProductService {

    Product findById(UUID id);
    ProductResponseDTO getResponseById(UUID id);

    ProductResponseDTO insert(ProductCreateRequestDTO createRequestDTO);

}