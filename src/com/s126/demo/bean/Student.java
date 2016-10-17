package com.s126.demo.bean;

public class Student {
	private String name;
	private int age;
	private Computer comp;
	

	public Computer getComp() {
		return comp;
	}


	public void setComp(Computer comp) {
		this.comp = comp;
	}


	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
	

}
