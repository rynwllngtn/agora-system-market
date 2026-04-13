package dev.rynwllngtn.agoramarket.controllers.seller;

import dev.rynwllngtn.agoramarket.dtos.seller.SellerCreateRequestDTO;
import dev.rynwllngtn.agoramarket.dtos.seller.SellerResponseDTO;
import dev.rynwllngtn.agoramarket.services.seller.SellerService;
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
@RequestMapping(value = "/sellers")
@Tag(
        name = "Endpoints CRUD REST API para Seller"
)
public class SellerController {

    private final SellerService sellerService;

    @Operation(
            summary = "Rota para leitura de Seller pelo ID"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<SellerResponseDTO> findById(@PathVariable UUID id) {
        SellerResponseDTO responseDTO = sellerService.getResponseById(id);
        return ResponseEntity.ok().body(responseDTO);
    }

    @Operation(
            summary = "Rota para criação de novo Seller"
    )
    @PostMapping
    public ResponseEntity<SellerResponseDTO> insert(@RequestBody @Valid SellerCreateRequestDTO createRequestDTO) {
        SellerResponseDTO responseDTO = sellerService.insert(createRequestDTO);
        URI uri = ServletUriComponentsBuilder.
                  fromCurrentRequest().
                  path("/{id}").
                  buildAndExpand(responseDTO.id()).
                  toUri();

        return ResponseEntity.created(uri).body(responseDTO);
    }

    @Operation(
            summary = "Rota para desativar um Seller pelo seu ID"
    )
    @PatchMapping(value = "/{id}/deactivate")
    public ResponseEntity<SellerResponseDTO> deactivate(@PathVariable UUID id) {
        SellerResponseDTO responseDTO = sellerService.deactivate(id);
        return ResponseEntity.ok().body(responseDTO);
    }

    @Operation(
            summary = "Rota para reativar um Seller pelo seu ID"
    )
    @PatchMapping(value = "/{id}/reactivate")
    public ResponseEntity<SellerResponseDTO> reactivate(@PathVariable UUID id) {
        SellerResponseDTO responseDTO = sellerService.reactivate(id);
        return ResponseEntity.ok().body(responseDTO);
    }

}