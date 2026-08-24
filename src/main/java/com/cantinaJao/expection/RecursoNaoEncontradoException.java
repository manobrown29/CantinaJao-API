package com.cantinaJao.expection;

public class RecursoNaoEncontradoException extends RuntimeException {
    public RecursoNaoEncontradoException() {
        super("Lanche não encontrado com ID selecionado");
    }
}
