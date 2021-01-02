package ch.zhaw.springboot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;


@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Shape {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@ManyToOne
		private Complex complex;
		
		private String size;

		public Shape(Complex complex, String size) {
			this.size = size;
		}

		public Shape() {
		}
		
		public long getId() {
			return id;
		}

		public String getSize() {
			return size;
		}		
}
