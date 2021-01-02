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

import ch.zhaw.springboot.entities.Complex;
import ch.zhaw.springboot.repositories.ComplexRepository;

@RestController
@CrossOrigin
public class ComplexRestController {
	@Autowired
	private ComplexRepository repository;

	@RequestMapping(value = "projectx/complexs", method = RequestMethod.GET)
	public ResponseEntity<List<Complex>> getComplexs() {
		List<Complex> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Complex>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Complex>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "projectx/complexs/{id}", method = RequestMethod.GET)
	public ResponseEntity<Complex> getComplexById(@PathVariable("id") long id) { 
		Optional<Complex> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity<Complex>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Complex>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "projectx/complexs", method = RequestMethod.POST)
	public ResponseEntity<Complex> createComplex(@RequestBody Complex complex) {
		Complex result = this.repository.save(complex);
		return new ResponseEntity<Complex>(result, HttpStatus.OK);
	}
}
