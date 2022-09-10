package com.gerenciador_tarefas.gerenciador_de_tarefas.infrastructure.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.gerenciador_tarefas.gerenciador_de_tarefas.domain.model.Task;
import com.gerenciador_tarefas.gerenciador_de_tarefas.infrastructure.comparable.TaskComparable;
import com.gerenciador_tarefas.gerenciador_de_tarefas.infrastructure.exception.ListaTaskVaziaException;
import com.gerenciador_tarefas.gerenciador_de_tarefas.infrastructure.exception.NaoEncontradoException;

public class TaskRepository {
    private List<Task> bancoDeDados;

    private static TaskRepository instancia;

    private TaskRepository() {
        this.bancoDeDados = new ArrayList<>();
    }

    public static TaskRepository getInstancia() {
        if (Objects.isNull(instancia)) {
            instancia = new TaskRepository();
        }
        
        return instancia;
    }

    public Task buscarTaskPorTitulo(String titulo) throws NaoEncontradoException {
        for (Task task : bancoDeDados) {
            if (task.getTitulo().equals(titulo)) return task;
        }

        throw new NaoEncontradoException(Task.class);        
    }

    public List<Task> buscarTodos() throws ListaTaskVaziaException {
        if (this.bancoDeDados.isEmpty()) throw new ListaTaskVaziaException();

        return this.bancoDeDados;
    }

    public Boolean salvar(Task task) {
        boolean resultado = false;
        if (!this.existe(task.getTitulo())) {
            resultado = this.bancoDeDados.add(task);
        }
        this.ordenar();
        return resultado;
    }

    public Boolean existe(String titulo) {
        Boolean existe = false;

        for (Task task : bancoDeDados) {
            if (task.getTitulo().equals(titulo)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    private void ordenar() {
        this.bancoDeDados.sort(new TaskComparable());
        System.out.println("\n\n");
    }
}
