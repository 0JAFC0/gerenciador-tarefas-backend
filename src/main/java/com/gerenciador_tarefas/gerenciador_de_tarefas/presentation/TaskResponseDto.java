package com.gerenciador_tarefas.gerenciador_de_tarefas.presentation;

import com.gerenciador_tarefas.gerenciador_de_tarefas.domain.model.Task.Prioridade;
import com.gerenciador_tarefas.gerenciador_de_tarefas.domain.model.Task.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDto {
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private Status status;
}
