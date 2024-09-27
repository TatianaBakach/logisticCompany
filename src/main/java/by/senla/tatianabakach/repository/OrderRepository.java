package by.senla.tatianabakach.repository;

import by.senla.tatianabakach.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends BaseRepository<Order>{

    Optional<Order> findOrderByNumber(String number);
}
