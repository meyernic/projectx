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

import ch.zhaw.springboot.entities.Diagram;
import ch.zhaw.springboot.repositories.DiagramRepository;

@RestController
@CrossOrigin
public class DiagramRestController {
	@Autowired
	private DiagramRepository repository;

	@RequestMapping(value = "projectx/diagrams", method = RequestMethod.GET)
	public ResponseEntity<List<Diagram>> getDiagrams() {
		List<Diagram> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Diagram>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Diagram>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "projectx/diagrams/{id}", method = RequestMethod.GET)
	public ResponseEntity<Diagram> getDiagramById(@PathVariable("id") long id) { 
		Optional<Diagram> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity<Diagram>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Diagram>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "projectx/diagrams", method = RequestMethod.POST)
	public ResponseEntity<Diagram> createDiagram(@RequestBody Diagram diagram) {
		Diagram result = this.repository.save(diagram);
		return new ResponseEntity<Diagram>(result, HttpStatus.OK);
	}
}
