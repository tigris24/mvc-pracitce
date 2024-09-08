package com.example.gradecalculator;

import java.util.List;

public class Courses {
	private final List<Course> courses;

	public Courses(List<Course> courses) {
		this.courses = courses;
	}

	public double multiplyCreditAndCourseGrade() {
		return courses.stream()
			.mapToDouble(Course::multiplyCreditAndCourseGrade)
			.sum();
		/*double multipliedCreditCourseGrade = 0.0;
		for (Course course : courses) {
			// multipliedCreditCourseGrade += course.getCredit() * course.getGradeToNumber();
			multipliedCreditCourseGrade += course.multiplyCreditAndCourseGrade();
		}
		return multipliedCreditCourseGrade;*/
	}

	public int calculateTotalCompletedCredit() {
		return courses.stream()
			.mapToInt(Course::getCredit)
			.sum();

	}
}
