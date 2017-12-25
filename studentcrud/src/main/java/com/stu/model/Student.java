/**
 * 
 */
package com.stu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.stu.util.ServiceConstant;

/**
 * @author Leela
 *
 */
@Entity
@Table(name = "student")
public class Student {

	@NotBlank
	private String studentName;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	@NotBlank
	private String studentCourse;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}

}
