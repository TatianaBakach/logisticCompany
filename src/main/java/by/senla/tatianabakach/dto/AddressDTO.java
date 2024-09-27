package by.senla.tatianabakach.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO extends BaseDTO {

    @NotBlank
    @Length(min = 5, max = 12)
    private String postcode;

    @NotBlank
    private String country;

    @NotBlank
    private String locality;

    @NotBlank
    private String exactAddress;
}
