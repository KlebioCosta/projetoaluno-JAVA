package com.alunoonline.api.service;

import com.alunoonline.api.model.Instructor;
import com.alunoonline.api.model.Student;
import com.alunoonline.api.repository.InstructorRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    InstructorRepository repository;

    public Instructor create(Instructor instructor) {
        return repository.save(instructor);
    }
    public List<Instructor> findAll() {
        return repository.findAll();
    }
    public Optional<Instructor> findById(Long id){
        return repository.findById(id);
    }

    public Instructor update(Long id, Instructor instructor) {
        Optional<Instructor> optionalInstructor = repository.findById(id);
        Instructor existingInstructor = optionalInstructor.get();
        return repository.save(existingInstructor);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
