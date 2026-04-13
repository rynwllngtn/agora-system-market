package dev.rynwllngtn.agoramarket.services.seller;

import dev.rynwllngtn.agoramarket.dtos.seller.SellerCreateRequestDTO;
import dev.rynwllngtn.agoramarket.dtos.seller.SellerResponseDTO;
import dev.rynwllngtn.agoramarket.entities.seller.Seller;

import java.util.UUID;

public interface SellerService {

    Seller findById(UUID id);
    SellerResponseDTO getResponseById(UUID id);

    SellerResponseDTO insert(SellerCreateRequestDTO createRequestDTO);

    SellerResponseDTO deactivate(UUID id);
    SellerResponseDTO reactivate(UUID id);

}