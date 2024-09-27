package by.senla.tatianabakach.service.impl;

import by.senla.tatianabakach.dto.RoutePointDTO;
import by.senla.tatianabakach.entity.RoutePoint;
import by.senla.tatianabakach.mapper.RoutePointMapper;
import by.senla.tatianabakach.repository.RoutePointRepository;
import by.senla.tatianabakach.service.RoutePointService;
import org.springframework.stereotype.Service;

@Service
public class RoutePointServiceImpl extends CrudServiceImpl<RoutePoint, RoutePointDTO, RoutePointMapper, RoutePointRepository>
        implements RoutePointService {

    protected RoutePointServiceImpl(RoutePointRepository repository, RoutePointMapper mapper) {

        super(repository, mapper, RoutePoint.class);
    }
}
