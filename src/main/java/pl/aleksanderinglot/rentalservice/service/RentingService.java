package pl.aleksanderinglot.rentalservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.aleksanderinglot.rentalservice.dto.ReservationDTO;
import pl.aleksanderinglot.rentalservice.repository.LesseeRepository;
import pl.aleksanderinglot.rentalservice.repository.LessorRepository;
import pl.aleksanderinglot.rentalservice.repository.PlaceForRentRepository;
import pl.aleksanderinglot.rentalservice.repository.ReservationRepository;

import java.util.Set;

@Service
public class RentingService {

    @Autowired
    private LessorRepository lessorRepository;

    @Autowired
    private LesseeRepository lesseeRepository;

    @Autowired
    private PlaceForRentRepository placeForRentRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public Set<ReservationDTO> getReservationsByLessorId(Long lessorId) {
        return null;
    }

    public Set<ReservationDTO> getReservationsByPlaceForRentId(Long placeForRentId) {
        return null;
    }

    public ReservationDTO addReservation(ReservationDTO reservationDTO) {
        return null;
    }

    public ReservationDTO updateReservation(ReservationDTO reservation) {
        return null;
    }

    public void deleteReservationById(Long reservationId) {

    }
}
