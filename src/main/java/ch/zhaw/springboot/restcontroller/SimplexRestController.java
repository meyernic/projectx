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

import ch.zhaw.springboot.entities.Simplex;
import ch.zhaw.springboot.repositories.SimplexRepository;

@RestController
@CrossOrigin
public class SimplexRestController {
	@Autowired
	private SimplexRepository repository;

	@RequestMapping(value = "projectx/simplexs", method = RequestMethod.GET)
	public ResponseEntity<List<Simplex>> getSimplexs() {
		List<Simplex> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Simplex>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Simplex>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "projectx/simplexs/{id}", method = RequestMethod.GET)
	public ResponseEntity<Simplex> getSimplexById(@PathVariable("id") long id) { 
		Optional<Simplex> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity<Simplex>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Simplex>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "projectx/simplexs", method = RequestMethod.POST)
	public ResponseEntity<Simplex> createComplex(@RequestBody Simplex simplex) {
		Simplex result = this.repository.save(simplex);
		return new ResponseEntity<Simplex>(result, HttpStatus.OK);
	}
}
