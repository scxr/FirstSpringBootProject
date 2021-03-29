package com.example.firstproject.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // SELECT * FROM student WHERE email == email;
    @Query("SELECT s FROM Student s WHERE s.email=?1")
    Optional<Student> findStudentByEmail(String email);

    @Modifying
    @Query("UPDATE Student s SET s.email=?1, s.name=?2 where s.id=?3")
    public void updateStudentById(String email, String name, Long id);

}
