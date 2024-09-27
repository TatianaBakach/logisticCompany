package by.senla.tatianabakach.dto;

import by.senla.tatianabakach.enums.CompanyType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO extends BaseDTO {

    @NotBlank
    private String name;

    @NotNull
    private CompanyType type;

    @NotBlank
    @Length(min = 5, max = 25)
    private String payerRegistrationNumber;

    @NotNull
    private AddressDTO legalAddress;

    @NotNull
    private AddressDTO postAddress;

    @NotBlank
    private String bankData;

    @Email(message = "Email is not valid",
            regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @NotEmpty
    private String email;

    @NotBlank
    private String phone;

}
