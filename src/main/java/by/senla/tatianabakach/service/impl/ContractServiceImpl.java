package by.senla.tatianabakach.service.impl;

import by.senla.tatianabakach.dto.ContractDTO;
import by.senla.tatianabakach.entity.Contract;
import by.senla.tatianabakach.mapper.ContractMapper;
import by.senla.tatianabakach.repository.ContractRepository;
import by.senla.tatianabakach.service.ContractService;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl extends CrudServiceImpl<Contract, ContractDTO, ContractMapper, ContractRepository>
        implements ContractService {

    protected ContractServiceImpl(ContractRepository repository, ContractMapper mapper) {

        super(repository, mapper, Contract.class);
    }
}
