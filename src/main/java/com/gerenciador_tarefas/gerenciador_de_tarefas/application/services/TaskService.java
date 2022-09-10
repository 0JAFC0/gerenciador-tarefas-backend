package com.gerenciador_tarefas.gerenciador_de_tarefas.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gerenciador_tarefas.gerenciador_de_tarefas.domain.model.Task;
import com.gerenciador_tarefas.gerenciador_de_tarefas.infrastructure.exception.ListaDuplicadaException;
import com.gerenciador_tarefas.gerenciador_de_tarefas.infrastructure.exception.ListaTaskVaziaException;
import com.gerenciador_tarefas.gerenciador_de_tarefas.infrastructure.exception.NaoEncontradoException;
import com.gerenciador_tarefas.gerenciador_de_tarefas.infrastructure.repository.TaskRepository;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService() {
        this.taskRepository = TaskRepository.getInstancia();
    }

    public Task criar(Task task) throws ListaDuplicadaException {
        this.validar(task);
        task.pendenciar();

        this.taskRepository.salvar(task);
        return task;
    }

    public Task concluir(String titulo) throws NaoEncontradoException {
        Task task = this.taskRepository.buscarTaskPorTitulo(titulo);
        task.concluir();
        this.taskRepository.salvar(task);

        return task;
    }

    public Task pendenciar(String titulo) throws NaoEncontradoException {
        Task task = this.taskRepository.buscarTaskPorTitulo(titulo);
        task.pendenciar();
        this.taskRepository.salvar(task);
        
        return task;
    }

    public Task buscarTaskPorTitulo(String titulo) throws NaoEncontradoException {
        return this.taskRepository.buscarTaskPorTitulo(titulo);
    }

    public List<Task> buscarTodos() throws ListaTaskVaziaException {
        return this.taskRepository.buscarTodos();
    }

    private void validar(Task task) throws ListaDuplicadaException {
        this.validarExistente(task);
    }

    private void validarExistente(Task task) throws ListaDuplicadaException {
        if (this.taskRepository.existe(task.getTitulo())) {
            throw new ListaDuplicadaException(task.getTitulo());
        }
    }
}
