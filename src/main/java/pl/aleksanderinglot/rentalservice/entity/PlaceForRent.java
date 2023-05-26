package pl.aleksanderinglot.rentalservice.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "places")
public class PlaceForRent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double area;
    private double unitPrice;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "lessor_id")
    private Lessor lessor;

    @OneToMany(mappedBy = "placeForRent", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Reservation> reservations;
    private String description;

    public PlaceForRent() {
    }

    public PlaceForRent(Long id, String name, double area, double unitPrice, Lessor lessor, Set<Reservation> reservations, String description) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.unitPrice = unitPrice;
        this.lessor = lessor;
        this.reservations = reservations;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Lessor getLessor() {
        return lessor;
    }

    public void setLessor(Lessor lessor) {
        this.lessor = lessor;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
