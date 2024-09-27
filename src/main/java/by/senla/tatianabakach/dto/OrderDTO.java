package by.senla.tatianabakach.dto;

import by.senla.tatianabakach.enums.LoadingMethodType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO extends BaseDTO {

    @NotBlank
    private String number;

    @NotNull
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate date;

    private CompanyDTO customer;

    private CompanyDTO carrier;

    private CarDTO car;

    private DriverDTO driver;

    private LoadingMethodType loadingMethod;

    private String cargoType;

    private BigDecimal cargoWeight;

    @NotNull
    private Boolean paidCustomer;

    @NotNull
    private Boolean paidCarrier;

}
