package by.senla.tatianabakach.dto;

import by.senla.tatianabakach.enums.RoutePointType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoutePointDTO extends BaseDTO {

    @NotNull
    private OrderDTO order;

    @NotNull
    private RoutePointType type;

    @NotNull
    private AddressDTO address;

    @NotNull
    private LocalDate date;

    @NotBlank
    private String contactPerson;

    @NotBlank
    private String contactPhone;
}
