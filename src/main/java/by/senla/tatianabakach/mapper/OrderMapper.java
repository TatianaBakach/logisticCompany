package by.senla.tatianabakach.mapper;

import by.senla.tatianabakach.dto.OrderDTO;
import by.senla.tatianabakach.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper extends BaseMapper<Order, OrderDTO> {

    @Override
    OrderDTO toDto(Order entity);

    @Override
    @Mapping(target = "routePoints", ignore = true)
    @Mapping(target = "employees", ignore = true)
    Order toEntity(OrderDTO dto);
}
