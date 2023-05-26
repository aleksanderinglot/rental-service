package pl.aleksanderinglot.rentalservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.aleksanderinglot.rentalservice.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
