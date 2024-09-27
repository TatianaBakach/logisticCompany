package by.senla.tatianabakach.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Builder
@Table(name = "address")
public class Address extends BaseEntity{

    @Column(name = "postcode", nullable = false)
    private String postcode;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "locality", nullable = false)
    private String locality;

    @Column(name = "exact_address", nullable = false)
    private String exactAddress;
}
