package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Table(name= "validity", schema = "projectx" )
@Entity
public class Validity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String location;
	
	@ManyToOne
	private Diagram diagram;
	@ManyToOne
	private Shape shape;

	public Validity(String location, Diagram diagram, Shape shape) {
		this.location = location;
		this.diagram = diagram;
		this.shape = shape;
	}
	
	public Validity() {
		
	}

	public long getId() {
		return id;
	}

	public String getLocation() {
		return location;
	}
	
	public Diagram getDiagram() {
		return diagram;
	}
	
	public Shape getShape() {
		return shape;
	}
}
