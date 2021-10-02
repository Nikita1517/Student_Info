package com.registration.student.Exception;


public class StudentNotFoundException extends Exception {
	private long studentRoll;

	public StudentNotFoundException(long studentRoll) {
		super(String.format("Student is not found with id : '%s'", studentRoll));
	}
}
