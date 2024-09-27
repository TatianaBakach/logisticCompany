package by.senla.tatianabakach.mapper;

import by.senla.tatianabakach.dto.AddressDTO;
import by.senla.tatianabakach.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper extends BaseMapper<Address, AddressDTO> {

}
