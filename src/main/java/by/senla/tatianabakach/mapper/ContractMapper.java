package by.senla.tatianabakach.mapper;

import by.senla.tatianabakach.dto.ContractDTO;
import by.senla.tatianabakach.entity.Contract;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContractMapper extends BaseMapper<Contract, ContractDTO> {

}
