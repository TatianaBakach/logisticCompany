package by.senla.tatianabakach.entity;

import by.senla.tatianabakach.enums.CompanyType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Builder
@Table(name = "company")
public class Company extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private CompanyType type;

    @Column(name = "payer_registration_number", nullable = false, unique = true)
    private String payerRegistrationNumber;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "legal_address_id", nullable = false)
    private Address legalAddress;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_address_id", nullable = false)
    private Address postAddress;

    @Column(name = "bank_data", nullable = false)
    private String bankData;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @OneToMany(mappedBy = "company")
    private Set<Contract> contracts;

}
