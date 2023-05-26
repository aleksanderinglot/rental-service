package pl.aleksanderinglot.rentalservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.aleksanderinglot.rentalservice.entity.PlaceForRent;

public interface PlaceForRentRepository extends JpaRepository<PlaceForRent, Long> {
}
