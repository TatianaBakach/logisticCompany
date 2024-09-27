package by.senla.tatianabakach.mapper;

import by.senla.tatianabakach.dto.CarDTO;
import by.senla.tatianabakach.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CarMapper  extends BaseMapper<Car, CarDTO> {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Override
    Car toEntity(CarDTO dto);

    @Override
    CarDTO toDto(Car entity);
}
