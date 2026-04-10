package dev.rynwllngtn.agorasystem.controllers.listing;

import dev.rynwllngtn.agorasystem.dtos.listing.ListingCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.listing.ListingResponseDTO;
import dev.rynwllngtn.agorasystem.entities.listing.Listing;
import dev.rynwllngtn.agorasystem.services.listing.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/listings")
public class ListingController {

    @Autowired
    ListingService listingService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ListingResponseDTO> findById(@PathVariable UUID id) {
        Listing listing = listingService.findById(id);
        return ResponseEntity.ok().body(new ListingResponseDTO(listing));
    }

    @PostMapping
    public ResponseEntity<ListingResponseDTO> insert(@RequestBody ListingCreateRequestDTO createRequestDTO) {
        Listing listing = listingService.insert(createRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(listing.getId()).toUri();
        return ResponseEntity.created(uri).body(new ListingResponseDTO(listing));
    }

}