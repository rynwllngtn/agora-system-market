package dev.rynwllngtn.agorasystem.mappers.seller;

import dev.rynwllngtn.agorasystem.dtos.seller.SellerCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.seller.SellerResponseDTO;
import dev.rynwllngtn.agorasystem.entities.seller.Seller;
import org.springframework.stereotype.Component;

@Component
public class SellerMapper {

    public SellerResponseDTO toResponseDTO(Seller seller) {
        return new SellerResponseDTO(seller.getId(),
                                     seller.getOwnerId(),
                                     seller.getName());
    }

    public Seller toEntity(SellerCreateRequestDTO createRequestDTO) {
        return new Seller(createRequestDTO.owner(),
                          createRequestDTO.name());
    }

}