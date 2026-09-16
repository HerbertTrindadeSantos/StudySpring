package br.com.Spring.Study.service;

import br.com.Spring.Study.dto.TaskRequestDTO;
import br.com.Spring.Study.dto.TaskResponseDTO;
import br.com.Spring.Study.entity.TaskEntity;
import br.com.Spring.Study.exceptions.TaskNotFoundException;
import br.com.Spring.Study.mapper.TaskMapper;
import br.com.Spring.Study.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskResponseDTO register(TaskRequestDTO task) {

        TaskEntity taskEntity = taskMapper.toEntity(task);
        TaskEntity savedTask = taskRepository.save(taskEntity);

        return taskMapper.toTaskResponseDTO(savedTask);

    }

    public TaskResponseDTO update(Long id, TaskRequestDTO updateTask) {

        TaskEntity taskEntity = taskRepository.findById(id).
                orElseThrow(() -> new TaskNotFoundException("Tarefa nao encontrada id:" + id));

        taskEntity.setName(updateTask.name());
        taskEntity.setLevel(updateTask.level());

        TaskEntity updateTaskEntity = taskRepository.save(taskEntity);

        return taskMapper.toTaskResponseDTO(updateTaskEntity);
    }

    public void deleteById(Long id) {

        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException("Task nao encontrada id: " + id);
        }

        taskRepository.deleteById(id);
    }

    public TaskResponseDTO findId(Long id) {
        TaskEntity task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Tarefa nao encontrada id: " + id));
        return taskMapper.toTaskResponseDTO(task);
    }

    public List<TaskResponseDTO> findByAll() {

        return taskRepository.
                findAll().
                stream().
                map(taskMapper::toTaskResponseDTO).
                toList();
    }
}
