package by.senla.tatianabakach.mapper;

import by.senla.tatianabakach.dto.OrderDTO;
import by.senla.tatianabakach.entity.Order;
import by.senla.tatianabakach.restTemplate.OrderPaymentInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Component
public interface OrderPaymentMapper extends BaseMapper<Order, OrderPaymentInfoDTO> {

    @Override
    OrderPaymentInfoDTO toDto(Order entity);

    @Override
//    @Mapping(target = "paymentDTO", ignore = true)
    @Mapping(target = "routePoints", ignore = true)
    @Mapping(target = "employees", ignore = true)
    Order toEntity(OrderPaymentInfoDTO dto);
}
