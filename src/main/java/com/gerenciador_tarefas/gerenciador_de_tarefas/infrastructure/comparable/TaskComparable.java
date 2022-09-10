package com.gerenciador_tarefas.gerenciador_de_tarefas.infrastructure.comparable;

import java.util.Comparator;

import com.gerenciador_tarefas.gerenciador_de_tarefas.domain.model.Task;

public class TaskComparable implements Comparator<Task> {

    @Override
    public int compare(Task task1, Task task2) {
        
        if (task1.getPrioridade().getValue() > task2.getPrioridade().getValue() &&
            task1.getStatus().getValue() > task2.getStatus().getValue()) {
            return -1;
        }

        if (task1.getPrioridade().getValue() < task2.getPrioridade().getValue() &&
            task1.getStatus().getValue() > task2.getStatus().getValue()) {
            return -1;
        }

        if (task1.getPrioridade().getValue() > task2.getPrioridade().getValue() &&
            task1.getStatus().getValue() < task2.getStatus().getValue()) {
            return 1;
        }

        if (task1.getPrioridade().getValue() < task2.getPrioridade().getValue() &&
            task1.getStatus().getValue() < task2.getStatus().getValue()) {
            return 1;
        }

        if (task1.getPrioridade().getValue() == task2.getPrioridade().getValue() &&
            task1.getStatus().getValue() > task2.getStatus().getValue()) {
            return -1;
        }

        if (task1.getPrioridade().getValue() == task2.getPrioridade().getValue() &&
            task1.getStatus().getValue() < task2.getStatus().getValue()) {
            return 1;
        }

        if (task1.getPrioridade().getValue() > task2.getPrioridade().getValue() &&
            task1.getStatus().getValue() == task2.getStatus().getValue()) {
            return -1;
        }

        if (task1.getPrioridade().getValue() < task2.getPrioridade().getValue() &&
            task1.getStatus().getValue() == task2.getStatus().getValue()) {
            return 1;
        }

        return 0;
    }
}
