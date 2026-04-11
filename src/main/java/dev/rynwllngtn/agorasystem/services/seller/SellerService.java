package dev.rynwllngtn.agorasystem.services.seller;

import dev.rynwllngtn.agorasystem.dtos.seller.SellerCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.seller.SellerResponseDTO;
import dev.rynwllngtn.agorasystem.entities.seller.Seller;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface SellerService {

    Seller findById(UUID id);
    SellerResponseDTO getResponseById(UUID id);

    SellerResponseDTO insert(SellerCreateRequestDTO createRequestDTO);

    SellerResponseDTO deactivate(UUID id);
    SellerResponseDTO reactivate(UUID id);

}