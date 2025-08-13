package com.moc.student_data_collector.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.moc.student_data_collector.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
}
