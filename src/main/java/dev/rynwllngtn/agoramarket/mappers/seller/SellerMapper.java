package dev.rynwllngtn.agoramarket.mappers.seller;

import dev.rynwllngtn.agoramarket.dtos.seller.SellerCreateRequestDTO;
import dev.rynwllngtn.agoramarket.dtos.seller.SellerResponseDTO;
import dev.rynwllngtn.agoramarket.entities.seller.Seller;
import org.springframework.stereotype.Component;

@Component
public class SellerMapper {

    public SellerResponseDTO toResponseDTO(Seller seller) {
        return new SellerResponseDTO(seller.getId(),
                                     seller.getOwnerId(),
                                     seller.getName(),
                                     seller.getStatus());
    }

    public Seller toEntity(SellerCreateRequestDTO createRequestDTO) {
        return new Seller(createRequestDTO.owner(),
                          createRequestDTO.name());
    }

}