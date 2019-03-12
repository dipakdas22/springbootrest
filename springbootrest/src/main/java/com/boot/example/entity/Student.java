package com.boot.example.entity;

public class Student {
	private String id;
	private String name;
	private int age;
	private String rollNo;
	
	public Student() {
		
	}
	public Student(String id, String name, int age, String rollNo) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.rollNo = rollNo;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	
	
}
