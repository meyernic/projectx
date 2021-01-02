package ch.zhaw.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.zhaw.springboot.entities.Diagram;
import ch.zhaw.springboot.entities.Validity;

public interface ValidityRepository extends JpaRepository<Validity, Long> {
	@Query("SELECT d.name, v.location FROM Diagram d, Validity v WHERE d.id = v.diagram AND v.location = ?1")
	public List<Diagram> getDiagramByLocation(String location);
}
