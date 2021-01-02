package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Diagram {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String topic;
	
	public Diagram(String name, String topic) {
		this.name = name;
		this.topic = topic;
	}
	
	public Diagram() {
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getTopic() {
		return topic;
	}
}
