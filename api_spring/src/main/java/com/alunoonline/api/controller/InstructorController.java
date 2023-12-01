package com.alunoonline.api.controller;

import com.alunoonline.api.model.Instructor;
import com.alunoonline.api.model.Student;
import com.alunoonline.api.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    InstructorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Instructor> create(@RequestBody Instructor instructor) {
        Instructor instructorCreated = service.create(instructor);

        return ResponseEntity.status(HttpStatus.CREATED).body(instructor);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Instructor> findById(@PathVariable Long id) {
        return service.findById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Instructor> update(@PathVariable Long id, @RequestBody Instructor instructor) {
        Instructor update = service.update(id, instructor);
        return ResponseEntity.ok(update);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
