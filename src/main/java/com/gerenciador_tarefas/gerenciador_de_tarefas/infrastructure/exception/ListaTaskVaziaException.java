package com.gerenciador_tarefas.gerenciador_de_tarefas.infrastructure.exception;

public class ListaTaskVaziaException extends Exception {

    private static final String mensagemPadrao = "Lista de tasks vazia";

    public ListaTaskVaziaException() {
        super(mensagemPadrao);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
    
}
