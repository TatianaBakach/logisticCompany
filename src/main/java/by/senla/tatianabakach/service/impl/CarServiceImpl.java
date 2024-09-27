package by.senla.tatianabakach.service.impl;

import by.senla.tatianabakach.dto.CarDTO;
import by.senla.tatianabakach.entity.Car;
import by.senla.tatianabakach.mapper.CarMapper;
import by.senla.tatianabakach.repository.CarRepository;
import by.senla.tatianabakach.service.CarService;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl extends CrudServiceImpl<Car, CarDTO, CarMapper, CarRepository>
        implements CarService {

    protected CarServiceImpl(CarRepository repository, CarMapper mapper) {

        super(repository, mapper, Car.class);
    }
}
