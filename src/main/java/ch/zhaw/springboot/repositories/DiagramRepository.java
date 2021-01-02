package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Diagram;

public interface DiagramRepository extends JpaRepository<Diagram, Long> {

}
