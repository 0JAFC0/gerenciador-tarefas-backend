package com.gerenciador_tarefas.gerenciador_de_tarefas.infrastructure.utils.modelMapper;

import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperService {
    private ModelMapper modelMapper;

    public <T> T convert(Object origem, Class<T> alvo) {
        this.init();
        return this.modelMapper.map(origem, alvo);
    }

    private void init() {
        if (Objects.isNull(this.modelMapper)) {
            this.modelMapper = new ModelMapper();
        }
    }
}
