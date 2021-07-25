package com.mhasancmt.testApp.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
	private final StudentRepository studentRepository;
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	public void addNewStudent(Student student) {
		Optional<Student> optionalStudent=studentRepository
				.findStudentByEmail(student.getEmail());
		if(optionalStudent.isPresent()) {
			throw new IllegalStateException("Email already taken");
		}
			studentRepository.save(student);
	}
	public void deleteStudent(Long id) {
		boolean exists=studentRepository.existsById(id);
		if(!exists) {
			throw new IllegalStateException("student with id "+
		id+" does not exists!");
		}
		studentRepository.deleteById(id);
	}
}
