package com.gerenciador_tarefas.gerenciador_de_tarefas.infrastructure.exception;

public class NaoEncontradoException extends Exception {

    private static final String mensagemPadrao = "Objeto não encontrado para o tipo ";

    public NaoEncontradoException(Class<?> classe) {
        super(mensagemPadrao.concat(classe.getSimpleName()));
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
    
}
