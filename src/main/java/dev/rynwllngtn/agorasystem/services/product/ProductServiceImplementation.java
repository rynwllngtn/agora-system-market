package dev.rynwllngtn.agorasystem.services.product;

import dev.rynwllngtn.agorasystem.dtos.product.ProductCreateRequestDTO;
import dev.rynwllngtn.agorasystem.entities.product.Product;
import dev.rynwllngtn.agorasystem.repositories.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findById(UUID id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }

    @Override
    public Product insert(ProductCreateRequestDTO createRequestDTO) {
        Product product = new Product(createRequestDTO.name(),
                                      createRequestDTO.description());

        return productRepository.save(product);
    }

}