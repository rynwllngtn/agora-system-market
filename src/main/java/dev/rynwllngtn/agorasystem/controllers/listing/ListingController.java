package dev.rynwllngtn.agorasystem.controllers.listing;

import dev.rynwllngtn.agorasystem.dtos.listing.ListingCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.listing.ListingResponseDTO;
import dev.rynwllngtn.agorasystem.services.listing.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/listings")
public class ListingController {

    public final ListingService listingService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ListingResponseDTO> findById(@PathVariable UUID id) {
        ListingResponseDTO responseDTO = listingService.getResponseById(id);
        return ResponseEntity.ok().body(responseDTO);
    }

    @PostMapping
    public ResponseEntity<ListingResponseDTO> insert(@RequestBody ListingCreateRequestDTO createRequestDTO) {
        ListingResponseDTO responseDTO = listingService.insert(createRequestDTO);
        URI uri = ServletUriComponentsBuilder.
                  fromCurrentRequest().
                  path("/{id}").
                  buildAndExpand(responseDTO.id()).
                  toUri();

        return ResponseEntity.created(uri).body(responseDTO);
    }

    @PatchMapping(value = "/{id}/open")
    public ResponseEntity<ListingResponseDTO> open(@PathVariable UUID id) {
        ListingResponseDTO responseDTO = listingService.open(id);
        return ResponseEntity.ok().body(responseDTO);
    }

    @PatchMapping(value = "/{id}/close")
    public ResponseEntity<ListingResponseDTO> close(@PathVariable UUID id) {
        ListingResponseDTO responseDTO = listingService.close(id);
        return ResponseEntity.ok().body(responseDTO);
    }

}