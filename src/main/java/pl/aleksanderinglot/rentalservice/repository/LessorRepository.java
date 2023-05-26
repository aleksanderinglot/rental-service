package pl.aleksanderinglot.rentalservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.aleksanderinglot.rentalservice.entity.Lessor;

public interface LessorRepository extends JpaRepository<Lessor, Long> {
}
