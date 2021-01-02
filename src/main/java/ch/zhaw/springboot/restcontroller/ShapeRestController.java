package ch.zhaw.springboot.restcontroller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Shape;
import ch.zhaw.springboot.repositories.ShapeRepository;

@RestController
@CrossOrigin
public class ShapeRestController {
	@Autowired
	private ShapeRepository repository;

	@RequestMapping(value = "projectx/shapes", method = RequestMethod.GET)
	public ResponseEntity<List<Shape>> getShapes() {
		List<Shape> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Shape>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Shape>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "projectx/shapes/{id}", method = RequestMethod.GET)
	public ResponseEntity<Shape> getShapeById(@PathVariable("id") long id) { 
		Optional<Shape> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity<Shape>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Shape>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "projectx/shapes", method = RequestMethod.POST)
	public ResponseEntity<Shape> createShape(@RequestBody Shape shape) {
		Shape result = this.repository.save(shape);
		return new ResponseEntity<Shape>(result, HttpStatus.OK);
	}
}
