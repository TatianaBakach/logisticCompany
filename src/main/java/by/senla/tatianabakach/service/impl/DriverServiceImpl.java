package by.senla.tatianabakach.service.impl;

import by.senla.tatianabakach.dto.DriverDTO;
import by.senla.tatianabakach.entity.Driver;
import by.senla.tatianabakach.mapper.DriverMapper;
import by.senla.tatianabakach.repository.DriverRepository;
import by.senla.tatianabakach.service.DriverService;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl extends CrudServiceImpl<Driver, DriverDTO, DriverMapper, DriverRepository>
        implements DriverService {

    protected DriverServiceImpl(DriverRepository repository, DriverMapper mapper) {

        super(repository, mapper, Driver.class);
    }
}
