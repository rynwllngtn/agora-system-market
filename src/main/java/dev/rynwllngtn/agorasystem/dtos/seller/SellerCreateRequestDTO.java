package dev.rynwllngtn.agorasystem.dtos.seller;

import java.util.UUID;

public record SellerCreateRequestDTO(
        UUID owner,
        String name
) {}