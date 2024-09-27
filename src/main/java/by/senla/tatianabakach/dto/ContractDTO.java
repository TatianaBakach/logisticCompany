package by.senla.tatianabakach.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ContractDTO extends BaseDTO {

    @NotBlank
    private String number;

    @NotNull
    private CompanyDTO company;

    @NotNull
    private LocalDate date;
}
