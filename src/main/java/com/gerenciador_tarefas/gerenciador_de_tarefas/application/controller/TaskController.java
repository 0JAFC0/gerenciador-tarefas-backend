package com.gerenciador_tarefas.gerenciador_de_tarefas.application.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador_tarefas.gerenciador_de_tarefas.application.services.TaskService;
import com.gerenciador_tarefas.gerenciador_de_tarefas.domain.model.Task;
import com.gerenciador_tarefas.gerenciador_de_tarefas.infrastructure.exception.ListaDuplicadaException;
import com.gerenciador_tarefas.gerenciador_de_tarefas.infrastructure.exception.ListaTaskVaziaException;
import com.gerenciador_tarefas.gerenciador_de_tarefas.infrastructure.exception.NaoEncontradoException;
import com.gerenciador_tarefas.gerenciador_de_tarefas.infrastructure.utils.modelMapper.ModelMapperService;
import com.gerenciador_tarefas.gerenciador_de_tarefas.presentation.ResponseDto;
import com.gerenciador_tarefas.gerenciador_de_tarefas.presentation.TaskRequestDto;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/gerenciador-tarefas/task")
@AllArgsConstructor
public class TaskController {
    private TaskService taskService;

    private ModelMapperService modelMapperService;

    @PostMapping("/criar")
    public ResponseEntity<ResponseDto<?>> criar(@RequestBody TaskRequestDto dto) {
        Task task = this.modelMapperService.convert(dto, Task.class);

        try {
            task = this.taskService.criar(task);
        } catch (ListaDuplicadaException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto<>(e.getMessage()));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto<>(task));
    }

    @PutMapping("/{titulo}/concluir")
    public ResponseEntity<ResponseDto<?>> concluir(@PathVariable String titulo) {
        Task task;
        try {
            task = this.taskService.concluir(titulo);
        } catch (NaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto<>(e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<>(task));
    }

    @PutMapping("/{titulo}/pendenciar")
    public ResponseEntity<ResponseDto<?>> pendenciar(@PathVariable String titulo) {
        Task task;
        try {
            task = this.taskService.pendenciar(titulo);
        } catch (NaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto<>(e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<>(task));
    }

    @GetMapping("/buscar-todos")
    public ResponseEntity<ResponseDto<?>> buscarTodos() {
        List<Task> tasks;
        try {
            tasks = this.taskService.buscarTodos();
        } catch (ListaTaskVaziaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto<>(e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto<>(tasks));
    }
}
