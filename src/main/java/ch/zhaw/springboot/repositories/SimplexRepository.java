package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Simplex;

public interface SimplexRepository extends JpaRepository<Simplex, Long> {

}
