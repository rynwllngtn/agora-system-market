package dev.rynwllngtn.agorasystem.controllers.seller;

import dev.rynwllngtn.agorasystem.dtos.seller.SellerCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.seller.SellerResponseDTO;
import dev.rynwllngtn.agorasystem.entities.seller.Seller;
import dev.rynwllngtn.agorasystem.services.seller.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<SellerResponseDTO> findById(@PathVariable UUID id) {
        Seller seller = sellerService.findById(id);
        return ResponseEntity.ok().body(new SellerResponseDTO(seller));
    }

    @PostMapping
    public ResponseEntity<SellerResponseDTO> insert(@RequestBody SellerCreateRequestDTO createRequestDTO) {
        Seller seller = sellerService.insert(createRequestDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(seller.getId()).toUri();
        return ResponseEntity.created(uri).body(new SellerResponseDTO(seller));
    }

}