package by.senla.tatianabakach.mapper;

import by.senla.tatianabakach.dto.CredentialsDTO;
import by.senla.tatianabakach.entity.Credentials;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CredentialsMapper extends BaseMapper<Credentials, CredentialsDTO> {

}
