package dev.rynwllngtn.agorasystem.services.product;

import dev.rynwllngtn.agorasystem.dtos.product.ProductCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.product.ProductResponseDTO;
import dev.rynwllngtn.agorasystem.entities.product.Product;
import dev.rynwllngtn.agorasystem.mappers.product.ProductMapper;
import dev.rynwllngtn.agorasystem.repositories.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Product findById(UUID id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }

    @Override
    public ProductResponseDTO getResponseById(UUID id) {
        Optional<ProductResponseDTO> responseDTO = productRepository.getResponseById(id);
        return responseDTO.get();
    }

    @Override
    public ProductResponseDTO insert(ProductCreateRequestDTO createRequestDTO) {
        Product product = productMapper.toEntity(createRequestDTO);
        product = productRepository.save(product);
        return productMapper.toResponseDTO(product);
    }

}