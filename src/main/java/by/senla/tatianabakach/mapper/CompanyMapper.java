package by.senla.tatianabakach.mapper;

import by.senla.tatianabakach.dto.CompanyDTO;
import by.senla.tatianabakach.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompanyMapper extends BaseMapper<Company, CompanyDTO> {

    @Override
    CompanyDTO toDto(Company entity);

    @Override
    @Mapping(target = "contracts", ignore = true)
    Company toEntity(CompanyDTO dto);
}
