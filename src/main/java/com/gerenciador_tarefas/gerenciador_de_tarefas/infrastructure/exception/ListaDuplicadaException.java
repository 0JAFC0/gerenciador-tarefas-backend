package com.gerenciador_tarefas.gerenciador_de_tarefas.infrastructure.exception;

public class ListaDuplicadaException extends Exception {

    private static final String mensagemPadrao = "Já existe uma task com o titulo ";

    public ListaDuplicadaException(String titulo) {
        super(mensagemPadrao.concat(titulo));
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
    
}
