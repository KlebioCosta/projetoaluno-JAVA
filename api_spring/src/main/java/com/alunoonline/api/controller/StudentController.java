package com.alunoonline.api.controller;

import com.alunoonline.api.model.Student;
import com.alunoonline.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student studentCreated = service.create(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(studentCreated);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> findAll()
    {
        return service.findAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Student> findById(@PathVariable Long id) {

        return service.findById(id);
    }
    @PutMapping("/{id}")
        public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
            Student update = service.update(id, student);
            return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delite(@PathVariable Long id) {

        service.delete(id);
    }
} 
