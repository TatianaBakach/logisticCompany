package by.senla.tatianabakach.service.impl;

import by.senla.tatianabakach.dto.EmployeeDTO;
import by.senla.tatianabakach.entity.Employee;
import by.senla.tatianabakach.mapper.EmployeeMapper;
import by.senla.tatianabakach.repository.EmployeeRepository;
import by.senla.tatianabakach.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends CrudServiceImpl<Employee, EmployeeDTO, EmployeeMapper, EmployeeRepository>
        implements EmployeeService {

    protected EmployeeServiceImpl(EmployeeRepository repository, EmployeeMapper mapper) {

        super(repository, mapper, Employee.class);
    }
}
