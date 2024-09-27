package by.senla.tatianabakach.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CredentialsDTO extends BaseDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotNull
    private RoleDTO role;

    @NotNull
    private EmployeeDTO employee;

}
