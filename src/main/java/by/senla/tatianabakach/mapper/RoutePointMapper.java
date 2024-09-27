package by.senla.tatianabakach.mapper;

import by.senla.tatianabakach.dto.RoutePointDTO;
import by.senla.tatianabakach.entity.RoutePoint;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoutePointMapper extends BaseMapper<RoutePoint, RoutePointDTO> {

}
