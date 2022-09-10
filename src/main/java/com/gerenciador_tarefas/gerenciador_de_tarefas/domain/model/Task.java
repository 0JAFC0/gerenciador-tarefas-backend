package com.gerenciador_tarefas.gerenciador_de_tarefas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private Status status;

    public void pendenciar() {
        this.status = Status.PENDENTE;
    }

    public void concluir() {
        this.status = Status.CONCLUIDO;
    }

    public enum Prioridade {
        BAIXA(1), MEDIA(2), ALTA(3);

        private int value;

        Prioridade(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum Status {
        CONCLUIDO(1), PENDENTE(2);

        private int value;

        Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }
}
