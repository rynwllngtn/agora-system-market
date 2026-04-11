package dev.rynwllngtn.agorasystem.dtos.seller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record SellerCreateRequestDTO(
        @NotNull(message = "Owner não pode ser vazio ou null!")
        UUID owner,
        @NotBlank(message = "Nome não pode ser vazio ou null!")
        String name
) {}