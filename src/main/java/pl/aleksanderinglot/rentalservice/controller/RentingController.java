package pl.aleksanderinglot.rentalservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.aleksanderinglot.rentalservice.dto.ReservationDTO;
import pl.aleksanderinglot.rentalservice.service.RentingService;

import java.util.Set;

@RestController
@RequestMapping("/reservations")
public class RentingController {

    @Autowired
    private RentingService rentingService;

    @GetMapping
    public Set<ReservationDTO> getReservationsByParam(@RequestParam(required = false) Long lessorId, @RequestParam(required = false) Long placeForRentId) throws Exception {
        if (lessorId != null)
            return rentingService.getReservationsByLessorId(lessorId);
        else if (placeForRentId != null)
            return rentingService.getReservationsByPlaceForRentId(placeForRentId);
        else
            throw new Exception("Provided parameter is not correct");
    }

    @PostMapping
    public ReservationDTO addReservation(@RequestBody ReservationDTO reservationDTO) {
        return rentingService.addReservation(reservationDTO);
    }

    @PutMapping
    public ReservationDTO updateReservation(@RequestBody ReservationDTO reservationDTO) {
        return rentingService.updateReservation(reservationDTO);
    }

    @DeleteMapping
    public void deleteReservationById(@RequestParam Long reservationId) {
        rentingService.deleteReservationById(reservationId);
    }
}
