package br.com.Spring.Study.Controller;

import br.com.Spring.Study.Entity.TaskEntity;
import br.com.Spring.Study.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping()
    public ResponseEntity<?> register(@RequestBody TaskEntity task){
       try {
           TaskEntity newTask = taskService.register(task);
           return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
       } catch (RuntimeException e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
       }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody TaskEntity task){
        try {
            TaskEntity newTask = taskService.updade(id, task);
            return ResponseEntity.ok(newTask);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findId(@PathVariable  UUID id){
        try {
            TaskEntity task = taskService.findId(id);
            return ResponseEntity.ok(task);
        } catch (RuntimeException e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping()
    public ResponseEntity<?> findByAll(){
        List<TaskEntity> tasks = taskService.findByAll();
        return ResponseEntity.ok(tasks);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        try {
            taskService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
