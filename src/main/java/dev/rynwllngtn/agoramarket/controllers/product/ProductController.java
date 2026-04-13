package dev.rynwllngtn.agoramarket.controllers.product;

import dev.rynwllngtn.agoramarket.dtos.product.ProductCreateRequestDTO;
import dev.rynwllngtn.agoramarket.dtos.product.ProductResponseDTO;
import dev.rynwllngtn.agoramarket.services.product.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/products")
@Tag(
        name = "Endpoints CRUD REST API para Product"
)
public class ProductController {

    private final ProductService productService;

    @Operation(
            summary = "Rota para leitura de Comment pelo ID"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable UUID id) {
        ProductResponseDTO responseDTO = productService.getResponseById(id);
        return ResponseEntity.ok().body(responseDTO);
    }

    @Operation(
            summary = "Rota para criação de novo Product"
    )
    @PostMapping
    public ResponseEntity<ProductResponseDTO> insert(@Valid @RequestBody ProductCreateRequestDTO createRequestDTO) {
        ProductResponseDTO responseDTO = productService.insert(createRequestDTO);
        URI uri = ServletUriComponentsBuilder.
                  fromCurrentRequest().
                  path("/{id}").
                  buildAndExpand(responseDTO.id()).
                  toUri();

        return ResponseEntity.created(uri).body(responseDTO);
    }

}