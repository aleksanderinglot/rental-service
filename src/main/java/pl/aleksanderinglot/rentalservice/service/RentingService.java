package pl.aleksanderinglot.rentalservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.aleksanderinglot.rentalservice.dto.ReservationDTO;
import pl.aleksanderinglot.rentalservice.entity.Lessee;
import pl.aleksanderinglot.rentalservice.entity.Lessor;
import pl.aleksanderinglot.rentalservice.entity.PlaceForRent;
import pl.aleksanderinglot.rentalservice.entity.Reservation;
import pl.aleksanderinglot.rentalservice.repository.LesseeRepository;
import pl.aleksanderinglot.rentalservice.repository.LessorRepository;
import pl.aleksanderinglot.rentalservice.repository.PlaceForRentRepository;
import pl.aleksanderinglot.rentalservice.repository.ReservationRepository;

import java.time.temporal.ChronoUnit;
import java.util.Optional;
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

    private Reservation convertReservationDTOtoEntity(ReservationDTO reservationDTO) throws Exception {
        Optional<Lessor> foundLessor = lessorRepository.findById(reservationDTO.getLessorId());
        Optional<Lessee> foundLessee = lesseeRepository.findById(reservationDTO.getLesseeId());

        if (foundLessor.isEmpty())
            throw new Exception();

        if (foundLessee.isEmpty())
            throw new Exception();

        Optional<PlaceForRent> foundPlaceForRent = placeForRentRepository.findById(reservationDTO.getPlaceForRentId());

        if (foundPlaceForRent.isEmpty())
            throw new Exception();

        return new Reservation(null, foundLessor.get(), foundLessee.get(), foundPlaceForRent.get(), reservationDTO.getStartDate(), reservationDTO.getEndDate(), calculateCost(reservationDTO));
    }

    private ReservationDTO convertReservationEntityToDTO(Reservation reservation) {
        return new ReservationDTO(reservation.getId(), reservation.getLessee().getId(), reservation.getLessor().getId(), reservation.getPlaceForRent().getId(), reservation.getStartDate(), reservation.getEndDate(), ChronoUnit.DAYS.between(reservation.getStartDate(), reservation.getEndDate()), reservation.getCost());
    }

    private double calculateCost(ReservationDTO reservationDTO) {
        Optional<PlaceForRent> foundPlaceForRent = placeForRentRepository.findById(reservationDTO.getPlaceForRentId());
        PlaceForRent placeForRent = null;

        if (foundPlaceForRent.isPresent())
            placeForRent = foundPlaceForRent.get();

        return placeForRent != null ? ChronoUnit.DAYS.between(reservationDTO.getStartDate(), reservationDTO.getEndDate()) * placeForRent.getUnitPrice() * placeForRent.getArea() : 0.0;
    }
}
