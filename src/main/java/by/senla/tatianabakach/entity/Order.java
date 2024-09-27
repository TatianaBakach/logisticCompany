package by.senla.tatianabakach.entity;

import by.senla.tatianabakach.enums.LoadingMethodType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Builder
@Table(name = "order_object")
public class Order extends BaseEntity {

    @Column(name = "number", nullable = false, unique = true)
    private String number;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Company customer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "carrier_id")
    private Company carrier;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @Enumerated(EnumType.STRING)
    @Column(name = "loading_method")
    private LoadingMethodType loadingMethod;

    @Column(name = "cargo_type")
    private String cargoType;

    @Column(name = "cargo_weight")
    private BigDecimal cargoWeight;

    @Column(name ="paid_customer", nullable = false,
            columnDefinition = "boolean default false")
    private Boolean paidCustomer;

    @Column(name ="paid_carrier", nullable = false,
            columnDefinition = "boolean default false")
    private Boolean paidCarrier;

    @OneToMany(mappedBy = "order")
    private Set<RoutePoint> routePoints;

    @ManyToMany
    @JoinTable(name = "order_employee",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set<Employee> employees;

}
