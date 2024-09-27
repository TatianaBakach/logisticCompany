package by.senla.tatianabakach.dto;

import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseDTO {

    private Integer id;

}