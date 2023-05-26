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
        return null;
    }

    @PostMapping
    public ReservationDTO addReservation(@RequestBody ReservationDTO reservationDTO) {
        return null;
    }

    @PutMapping
    public ReservationDTO updateReservation(@RequestBody ReservationDTO reservationDTO) {
        return null;
    }

    @DeleteMapping
    public void deleteReservationById(@RequestParam Long reservationId) {

    }
}
