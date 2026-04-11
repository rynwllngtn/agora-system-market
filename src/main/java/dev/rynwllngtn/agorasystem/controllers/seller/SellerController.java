package dev.rynwllngtn.agorasystem.controllers.seller;

import dev.rynwllngtn.agorasystem.dtos.seller.SellerCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.seller.SellerResponseDTO;
import dev.rynwllngtn.agorasystem.services.seller.SellerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    private final SellerService sellerService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<SellerResponseDTO> findById(@PathVariable UUID id) {
        SellerResponseDTO responseDTO = sellerService.getResponseById(id);
        return ResponseEntity.ok().body(responseDTO);
    }

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

    @PatchMapping(value = "/{id}/deactivate")
    public ResponseEntity<SellerResponseDTO> deactivate(@PathVariable UUID id) {
        SellerResponseDTO responseDTO = sellerService.deactivate(id);
        return ResponseEntity.ok().body(responseDTO);
    }

    @PatchMapping(value = "/{id}/reactivate")
    public ResponseEntity<SellerResponseDTO> reactivate(@PathVariable UUID id) {
        SellerResponseDTO responseDTO = sellerService.reactivate(id);
        return ResponseEntity.ok().body(responseDTO);
    }

}