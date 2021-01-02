package ch.zhaw.springboot.entities;

import javax.persistence.Entity;

@Entity
public class Simplex extends Shape{
	
	private String simplextype;
	
	public Simplex(String simplextype) { //falls komische probleme mit sql joine type ändern
		this.simplextype = simplextype;
	}
	
	public Simplex() {
		
	}
	
	public String getSimplextype() {
		return simplextype;
	}
}
