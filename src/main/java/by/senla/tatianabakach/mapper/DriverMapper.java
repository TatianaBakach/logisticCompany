package by.senla.tatianabakach.mapper;

import by.senla.tatianabakach.dto.DriverDTO;
import by.senla.tatianabakach.entity.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DriverMapper extends BaseMapper<Driver, DriverDTO> {

}
