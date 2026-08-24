package com.cantinaJao.expection;

import java.util.List;

public record ErroValidacaoDTO(int status, List<ErroCampoDTO> erros) {
}