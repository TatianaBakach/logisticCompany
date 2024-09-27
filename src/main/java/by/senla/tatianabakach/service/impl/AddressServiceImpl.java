package by.senla.tatianabakach.service.impl;

import by.senla.tatianabakach.dto.AddressDTO;
import by.senla.tatianabakach.entity.Address;
import by.senla.tatianabakach.mapper.AddressMapper;
import by.senla.tatianabakach.repository.AddressRepository;
import by.senla.tatianabakach.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends CrudServiceImpl<Address, AddressDTO, AddressMapper, AddressRepository>
        implements AddressService {

    protected AddressServiceImpl(AddressRepository repository, AddressMapper mapper) {

        super(repository, mapper, Address.class);
    }
}
