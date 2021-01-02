package ch.zhaw.springboot.entities;

import javax.persistence.Entity;

@Entity
public class Complex extends Shape {
	
	private String complextype;

	public Complex(String complextype) {
		this.complextype = complextype;
	}

	public Complex() {
		
	}

	public String getComplextype() {
		return complextype;
	}	
}
