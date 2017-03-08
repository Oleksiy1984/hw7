package com.orlovskiy.dao;

import com.orlovskiy.model.Students;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Alexey.
 */
public interface StudentDAO {
    Students addStudent(Students student);
    Students updateStudent(Students student);
    Students getStudentById(Long id);
    void deleteStudent(Long id);
    List<Students> getAllStudents();
}
