package com.tmbl.request;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="studentreg")
public class StudentDetailsRequest {

	@JsonProperty("studentName")
	@Valid
	@NotNull(message="validateStuName")
	private String studentName;
	
	@Id
	@JsonProperty("studentId")
	@Valid
	@NotNull(message="validateStuId")
	private int studentId;
	
	@JsonProperty("courseName")
	@Valid
	@NotNull(message="validateCourseName")
	private String courseName;

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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "StudentRequest [studentName=" + studentName + ", studentId=" + studentId + ", courseName=" + courseName
				+ "]";
	}
}
