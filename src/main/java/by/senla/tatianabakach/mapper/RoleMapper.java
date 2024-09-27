package by.senla.tatianabakach.mapper;

import by.senla.tatianabakach.dto.RoleDTO;
import by.senla.tatianabakach.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper extends BaseMapper<Role, RoleDTO> {

}
