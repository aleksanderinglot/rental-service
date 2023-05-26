package pl.aleksanderinglot.rentalservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.aleksanderinglot.rentalservice.entity.Lessee;

public interface LesseeRepository extends JpaRepository<Lessee, Long> {
}
