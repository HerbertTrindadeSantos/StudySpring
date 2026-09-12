package br.com.Spring.Study.Controller;

import br.com.Spring.Study.Entity.WorkerEntity;
import br.com.Spring.Study.Service.WorkerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/worker")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService workerService;

    @PostMapping()
    public ResponseEntity<?> register(@RequestBody WorkerEntity worker) {
        try {
            WorkerEntity newWorker = workerService.register(worker);
            return ResponseEntity.status(HttpStatus.CREATED).body(newWorker);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping()
    public ResponseEntity<?> findByAll(){
        List<WorkerEntity> workers = workerService.findByAll();
        return  ResponseEntity.ok(workers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findId(@PathVariable UUID id){
        try {
            WorkerEntity worker = workerService.findId(id);
            return ResponseEntity.ok(worker);
        } catch (RuntimeException e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id,@RequestBody WorkerEntity worker) {
        try{
            WorkerEntity newWorker = workerService.update(id,worker);
            return ResponseEntity.ok(newWorker);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        try{
            workerService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
