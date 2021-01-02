package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Complex;

public interface ComplexRepository extends JpaRepository<Complex, Long> {

}
