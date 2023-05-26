package pl.aleksanderinglot.rentalservice.dto;

import java.time.LocalDate;

public class ReservationDTO {
    private Long id;
    private Long lesseeId;
    private Long lessorId;
    private Long placeForRentId;
    private LocalDate startDate;
    private LocalDate endDate;
    private long leaseTerm;
    private double cost;

    public ReservationDTO() {
    }

    public ReservationDTO(Long id, Long lesseeId, Long lessorId, Long placeForRentId, LocalDate startDate, LocalDate endDate, long leaseTerm, double cost) {
        this.id = id;
        this.lesseeId = lesseeId;
        this.lessorId = lessorId;
        this.placeForRentId = placeForRentId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaseTerm = leaseTerm;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLesseeId() {
        return lesseeId;
    }

    public void setLesseeId(Long lesseeId) {
        this.lesseeId = lesseeId;
    }

    public Long getLessorId() {
        return lessorId;
    }

    public void setLessorId(Long lessorId) {
        this.lessorId = lessorId;
    }

    public Long getPlaceForRentId() {
        return placeForRentId;
    }

    public void setPlaceForRentId(Long placeForRentId) {
        this.placeForRentId = placeForRentId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public long getLeaseTerm() {
        return leaseTerm;
    }

    public void setLeaseTerm(long leaseTerm) {
        this.leaseTerm = leaseTerm;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
