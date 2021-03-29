package com.example.firstproject.student;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {
		return studentRepository.findAll();
	}

    public void addNewStudent(Student student) {
        
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("Student already exists");
        }
        studentRepository.save(student);
    }
    
    public void deleteStudent(Long studentId) {
        // studentRepository.findById(studnetId);
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("User "+studentId+"does not exist");
        }
        studentRepository.deleteById(studentId);
    }

}
