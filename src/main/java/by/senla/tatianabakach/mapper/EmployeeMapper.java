package by.senla.tatianabakach.mapper;

import by.senla.tatianabakach.dto.EmployeeDTO;
import by.senla.tatianabakach.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper extends BaseMapper<Employee, EmployeeDTO>{

    @Override
    @Mapping(target = "orders", ignore = true)
    Employee toEntity(EmployeeDTO dto);

    @Override
    EmployeeDTO toDto(Employee entity);
}
