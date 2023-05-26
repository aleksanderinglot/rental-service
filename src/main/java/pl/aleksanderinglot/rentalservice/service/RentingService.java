package pl.aleksanderinglot.rentalservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.aleksanderinglot.rentalservice.dto.ReservationDTO;
import pl.aleksanderinglot.rentalservice.entity.Lessee;
import pl.aleksanderinglot.rentalservice.entity.Lessor;
import pl.aleksanderinglot.rentalservice.entity.PlaceForRent;
import pl.aleksanderinglot.rentalservice.entity.Reservation;
import pl.aleksanderinglot.rentalservice.exceptions.*;
import pl.aleksanderinglot.rentalservice.repository.LesseeRepository;
import pl.aleksanderinglot.rentalservice.repository.LessorRepository;
import pl.aleksanderinglot.rentalservice.repository.PlaceForRentRepository;
import pl.aleksanderinglot.rentalservice.repository.ReservationRepository;

import java.time.temporal.ChronoUnit;
import java.util.HashSet;
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
        Optional<Lessor> foundLessor = lessorRepository.findById(lessorId);
        Set<ReservationDTO> reservationDTOS = new HashSet<>();

        if (foundLessor.isEmpty())
            throw new LessorNotFoundException("Lessor id not found - " + lessorId);

        foundLessor.get().getReservations().forEach(reservation -> {
            ReservationDTO reservationDTO = convertReservationEntityToDTO(reservation);
            reservationDTOS.add(reservationDTO);
        });

        return reservationDTOS;
    }

    public Set<ReservationDTO> getReservationsByPlaceForRentId(Long placeForRentId) {
        Optional<PlaceForRent> foundPlaceForRent = placeForRentRepository.findById(placeForRentId);
        Set<ReservationDTO> reservationDTOS = new HashSet<>();

        if (foundPlaceForRent.isEmpty())
            throw new PlaceForRentNotFoundException("Place for rent id not found - " + placeForRentId);

        foundPlaceForRent.get().getReservations().forEach(reservation -> {
            ReservationDTO reservationDTO = convertReservationEntityToDTO(reservation);
            reservationDTOS.add(reservationDTO);
        });

        return reservationDTOS;
    }

    public ReservationDTO addReservation(ReservationDTO reservationDTO) {
        Set<Reservation> existingReservations = reservationRepository.findExistingReservation(reservationDTO.getStartDate(), reservationDTO.getEndDate(), reservationDTO.getPlaceForRentId());

        if (!existingReservations.isEmpty())
            throw new ReservationAlreadyExistsException("This place is already booked in given period - please select another date");

        Reservation save = reservationRepository.save(convertReservationDTOtoEntity(reservationDTO));

        return convertReservationEntityToDTO(save);
    }

    public ReservationDTO updateReservation(ReservationDTO reservationDTO) {
        Optional<Reservation> existingReservation = reservationRepository.findById(reservationDTO.getId());

        if (existingReservation.isEmpty())
            throw new ReservationNotFoundException("Reservation id not found - " + reservationDTO.getId());

        Set<Reservation> existingReservations = reservationRepository.findExistingReservation(reservationDTO.getStartDate(), reservationDTO.getEndDate(), reservationDTO.getPlaceForRentId());

        if (existingReservations.size() > 1)
            throw new ReservationAlreadyExistsException("This place is already booked in given period - please select another date");

        Reservation save = reservationRepository.save(convertReservationDTOtoEntity(reservationDTO));

        return convertReservationEntityToDTO(save);
    }

    public void deleteReservationById(Long reservationId) {
        Optional<Reservation> reservationToDelete = reservationRepository.findById(reservationId);

        if (reservationToDelete.isEmpty())
            throw new ReservationNotFoundException("Reservation id not found - " + reservationId);

        reservationRepository.deleteById(reservationId);
    }

    private Reservation convertReservationDTOtoEntity(ReservationDTO reservationDTO) {
        Optional<Lessor> foundLessor = lessorRepository.findById(reservationDTO.getLessorId());
        Optional<Lessee> foundLessee = lesseeRepository.findById(reservationDTO.getLesseeId());

        if (foundLessor.isEmpty())
            throw new LessorNotFoundException("Lessor id not found - " + reservationDTO.getLessorId());

        if (foundLessee.isEmpty())
            throw new LesseeNotFoundException("Lessee id not found - " + reservationDTO.getLesseeId());

        Optional<PlaceForRent> foundPlaceForRent = placeForRentRepository.findById(reservationDTO.getPlaceForRentId());

        if (foundPlaceForRent.isEmpty())
            throw new PlaceForRentNotFoundException("Place for rent id not found - " + reservationDTO.getPlaceForRentId());

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
