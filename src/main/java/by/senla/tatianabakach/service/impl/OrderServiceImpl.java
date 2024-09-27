package by.senla.tatianabakach.service.impl;

import by.senla.tatianabakach.dto.OrderDTO;
import by.senla.tatianabakach.entity.Order;
import by.senla.tatianabakach.mapper.OrderMapper;
import by.senla.tatianabakach.mapper.OrderPaymentMapper;
import by.senla.tatianabakach.repository.OrderRepository;
import by.senla.tatianabakach.restTemplate.OrderPaymentInfoDTO;
import by.senla.tatianabakach.restTemplate.PaymentDTO;
import by.senla.tatianabakach.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl extends CrudServiceImpl<Order, OrderDTO, OrderMapper, OrderRepository>
        implements OrderService {

    private final OrderPaymentMapper orderPaymentMapper;

    private final RestTemplate restTemplate;

    protected OrderServiceImpl(OrderRepository repository, OrderMapper mapper, OrderPaymentMapper orderPaymentMapper, RestTemplate restTemplate) {

        super(repository, mapper, Order.class);
        this.orderPaymentMapper = orderPaymentMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public void updateStatus(PaymentDTO paymentDTO) {
        Order order = repository.findOrderByNumber(paymentDTO.getOrder()).orElseThrow();
        order.setPaidCarrier(Boolean.TRUE);
        repository.save(order);
    }

    //todo
    @Override
    public void updateStatusCustomer(PaymentDTO paymentDTO) {
        Order order = repository.findOrderByNumber(paymentDTO.getOrder()).orElseThrow();
        order.setPaidCustomer(Boolean.TRUE);
        repository.save(order);
    }

    @Override
    public OrderPaymentInfoDTO getOrderWithPayment(Integer id) {
        Order order = repository.findById(id).orElseThrow();
        PaymentDTO paymentDTO =
                restTemplate.getForObject("/order/".concat(order.getNumber()), PaymentDTO.class);
        OrderPaymentInfoDTO orderPaymentInfoDTO = orderPaymentMapper.toDto(order);
        orderPaymentInfoDTO.setPaymentDTO(paymentDTO);
        return orderPaymentInfoDTO;

    }
}
