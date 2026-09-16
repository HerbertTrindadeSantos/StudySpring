package br.com.Spring.Study.controller;

import br.com.Spring.Study.dto.TaskRequestDTO;
import br.com.Spring.Study.dto.TaskResponseDTO;
import br.com.Spring.Study.entity.TaskEntity;
import br.com.Spring.Study.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping()
    public ResponseEntity<TaskResponseDTO> register(@RequestBody TaskRequestDTO task) {

        TaskResponseDTO savedTask = taskService.register(task);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> update(@PathVariable Long id, @RequestBody TaskRequestDTO updateTask) {

        TaskResponseDTO task = taskService.update(id, updateTask);

        return ResponseEntity.ok(task);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> findId(@PathVariable Long id) {

        TaskResponseDTO task = taskService.findId(id);

        return ResponseEntity.ok(task);

    }

    @GetMapping()
    public ResponseEntity<List<TaskResponseDTO>> findByAll() {

        List<TaskResponseDTO> tasks = taskService.findByAll();

        return ResponseEntity.ok(tasks);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        taskService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


}
