package pl.aleksanderinglot.rentalservice.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "lessor_id")
    private Lessor lessor;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "lessee_id")
    private Lessee lessee;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "place_for_rent_id")
    private PlaceForRent placeForRent;
    private LocalDate startDate;
    private LocalDate endDate;
    private double cost;

    public Reservation() {
    }

    public Reservation(Long id, Lessor lessor, Lessee lessee, PlaceForRent placeForRent, LocalDate startDate, LocalDate endDate, double cost) {
        this.id = id;
        this.lessor = lessor;
        this.lessee = lessee;
        this.placeForRent = placeForRent;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lessor getLessor() {
        return lessor;
    }

    public void setLessor(Lessor lessor) {
        this.lessor = lessor;
    }

    public Lessee getLessee() {
        return lessee;
    }

    public void setLessee(Lessee lessee) {
        this.lessee = lessee;
    }

    public PlaceForRent getPlaceForRent() {
        return placeForRent;
    }

    public void setPlaceForRent(PlaceForRent placeForRent) {
        this.placeForRent = placeForRent;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
