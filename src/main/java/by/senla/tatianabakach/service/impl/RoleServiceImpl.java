package by.senla.tatianabakach.service.impl;

import by.senla.tatianabakach.dto.RoleDTO;
import by.senla.tatianabakach.entity.Role;
import by.senla.tatianabakach.mapper.RoleMapper;
import by.senla.tatianabakach.repository.RoleRepository;
import by.senla.tatianabakach.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends CrudServiceImpl<Role, RoleDTO, RoleMapper, RoleRepository>
        implements RoleService {

    protected RoleServiceImpl(RoleRepository repository, RoleMapper mapper) {

        super(repository, mapper, Role.class);
    }
}
