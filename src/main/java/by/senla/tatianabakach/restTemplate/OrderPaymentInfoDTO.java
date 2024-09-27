package by.senla.tatianabakach.restTemplate;

import by.senla.tatianabakach.dto.BaseDTO;
import by.senla.tatianabakach.dto.CarDTO;
import by.senla.tatianabakach.dto.CompanyDTO;
import by.senla.tatianabakach.dto.DriverDTO;
import by.senla.tatianabakach.entity.BaseEntity;
import by.senla.tatianabakach.enums.LoadingMethodType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderPaymentInfoDTO extends BaseDTO {

    @NotBlank
    private String number;

//    @NotNull
//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    private LocalDate date;

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

    private PaymentDTO paymentDTO;
}
