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
@Table(name = "car")
public class Car extends BaseEntity{

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "number", nullable = false)
    private String number;
}
