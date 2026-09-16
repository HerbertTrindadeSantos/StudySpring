package br.com.Spring.Study.mapper;

import br.com.Spring.Study.dto.TaskRequestDTO;
import br.com.Spring.Study.dto.TaskResponseDTO;
import br.com.Spring.Study.entity.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskEntity toEntity(TaskRequestDTO taskRequestDTO) {

        TaskEntity task = new TaskEntity();
        task.setName(taskRequestDTO.name());
        task.setLevel(taskRequestDTO.level());

        return task;
    }

    public TaskResponseDTO toTaskResponseDTO(TaskEntity taskEntity) {

        return new TaskResponseDTO(
                taskEntity.getId(), taskEntity.getName(), taskEntity.getLevel());
    }
}
