package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Shape;

public interface ShapeRepository extends JpaRepository<Shape, Long> {

}
