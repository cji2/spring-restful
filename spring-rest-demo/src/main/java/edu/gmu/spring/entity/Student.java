package edu.gmu.spring.entity;

public class Student {
	private String firstName;
	private String lasstName;
	
	public Student() {}
	
	public Student(String firstName, String lasstName) {
		this.firstName = firstName;
		this.lasstName = lasstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLasstName() {
		return lasstName;
	}

	public void setLasstName(String lasstName) {
		this.lasstName = lasstName;
	}
}
 