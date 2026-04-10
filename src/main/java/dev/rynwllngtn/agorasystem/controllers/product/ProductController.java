package dev.rynwllngtn.agorasystem.controllers.product;

import dev.rynwllngtn.agorasystem.dtos.product.ProductCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.product.ProductResponseDTO;
import dev.rynwllngtn.agorasystem.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable UUID id) {
        ProductResponseDTO responseDTO = productService.getResponseById(id);
        return ResponseEntity.ok().body(responseDTO);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> insert(@RequestBody ProductCreateRequestDTO createRequestDTO) {
        ProductResponseDTO responseDTO = productService.insert(createRequestDTO);
        URI uri = ServletUriComponentsBuilder.
                  fromCurrentRequest().
                  path("/{id}").
                  buildAndExpand(responseDTO.id()).
                  toUri();

        return ResponseEntity.created(uri).body(responseDTO);
    }

}