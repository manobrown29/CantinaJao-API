package com.cantinaJao.DTO;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record LancheRequestDTO (
        @NotBlank(message = "nome é obrigatório")
        String nome,

        String descricao,

        @NotNull(message = "preco é obrigatório")
        BigDecimal preco
){
}
