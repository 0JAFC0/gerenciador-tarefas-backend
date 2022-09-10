package com.gerenciador_tarefas.gerenciador_de_tarefas.presentation;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public final class ResponseDto<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private T objeto;
}