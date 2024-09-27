package by.senla.tatianabakach.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO extends BaseDTO {

    @NotBlank
    private String model;

    @NotBlank
    private String number;
}
