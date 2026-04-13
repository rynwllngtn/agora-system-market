package dev.rynwllngtn.agoramarket.services.product;

import dev.rynwllngtn.agoramarket.dtos.product.ProductCreateRequestDTO;
import dev.rynwllngtn.agoramarket.dtos.product.ProductResponseDTO;
import dev.rynwllngtn.agoramarket.entities.product.Product;
import dev.rynwllngtn.agoramarket.exceptions.database.DatabaseException.ResourceNotFoundException;
import dev.rynwllngtn.agoramarket.mappers.product.ProductMapper;
import dev.rynwllngtn.agoramarket.repositories.product.ProductRepository;
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
        return product.orElseThrow(
                () -> new ResourceNotFoundException(Product.class, id));
    }

    @Override
    public ProductResponseDTO getResponseById(UUID id) {
        Optional<ProductResponseDTO> responseDTO = productRepository.getResponseById(id);
        return responseDTO.orElseThrow(
                () -> new ResourceNotFoundException(Product.class, id));
    }

    @Override
    public ProductResponseDTO insert(ProductCreateRequestDTO createRequestDTO) {
        Product product = productMapper.toEntity(createRequestDTO);
        product = productRepository.save(product);
        return productMapper.toResponseDTO(product);
    }

}