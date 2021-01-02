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
import ch.zhaw.springboot.entities.Validity;
import ch.zhaw.springboot.repositories.ValidityRepository;

@RestController
@CrossOrigin
public class ValidityRestController {
	@Autowired
	private ValidityRepository repository;

	@RequestMapping(value = "projectx/validitys", method = RequestMethod.GET)
	public ResponseEntity<List<Validity>> GetValiditys() {
		List<Validity> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Validity>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Validity>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "projectx/validitys/{id}", method = RequestMethod.GET)
	public ResponseEntity<Validity> getValidityById(@PathVariable("id") long id) { 
		Optional<Validity> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity<Validity>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Validity>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "projectx/validitys/WP4/{location}", method = RequestMethod.GET)
	public ResponseEntity<List<Diagram>> getDiagramByLocation(@PathVariable("location") String location) {
		List<Diagram> result = this.repository.getDiagramByLocation(location);

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Diagram>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Diagram>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "projectx/validitys", method = RequestMethod.POST)
	public ResponseEntity<Validity> createLocation(@RequestBody Validity validity) {
		Validity result = this.repository.save(validity);
		return new ResponseEntity<Validity>(result, HttpStatus.OK);
	}
}
