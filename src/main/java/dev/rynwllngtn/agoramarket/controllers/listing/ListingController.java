package dev.rynwllngtn.agoramarket.controllers.listing;

import dev.rynwllngtn.agoramarket.dtos.listing.ListingCreateRequestDTO;
import dev.rynwllngtn.agoramarket.dtos.listing.ListingResponseDTO;
import dev.rynwllngtn.agoramarket.services.listing.ListingService;
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
@RequestMapping(value = "/listings")
@Tag(
        name = "Endpoints CRUD REST API para Listing"
)
public class ListingController {

    private final ListingService listingService;

    @Operation(
            summary = "Rota para leitura de Listing pelo ID"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<ListingResponseDTO> findById(@PathVariable UUID id) {
        ListingResponseDTO responseDTO = listingService.getResponseById(id);
        return ResponseEntity.ok().body(responseDTO);
    }

    @Operation(
            summary = "Rota para criação de novo Listing"
    )
    @PostMapping
    public ResponseEntity<ListingResponseDTO> insert(@Valid @RequestBody ListingCreateRequestDTO createRequestDTO) {
        ListingResponseDTO responseDTO = listingService.insert(createRequestDTO);
        URI uri = ServletUriComponentsBuilder.
                  fromCurrentRequest().
                  path("/{id}").
                  buildAndExpand(responseDTO.id()).
                  toUri();

        return ResponseEntity.created(uri).body(responseDTO);
    }

    @Operation(
            summary = "Rota para abrir um Listing pelo seu ID"
    )
    @PatchMapping(value = "/{id}/open")
    public ResponseEntity<ListingResponseDTO> open(@PathVariable UUID id) {
        ListingResponseDTO responseDTO = listingService.open(id);
        return ResponseEntity.ok().body(responseDTO);
    }

    @Operation(
            summary = "Rota para fechar um Listing pelo seu ID"
    )
    @PatchMapping(value = "/{id}/close")
    public ResponseEntity<ListingResponseDTO> close(@PathVariable UUID id) {
        ListingResponseDTO responseDTO = listingService.close(id);
        return ResponseEntity.ok().body(responseDTO);
    }

}