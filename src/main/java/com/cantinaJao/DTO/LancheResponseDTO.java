package com.cantinaJao.DTO;

import java.math.BigDecimal;

public record LancheResponseDTO (
        Long id,
        String nome,
        BigDecimal preco
){
}
