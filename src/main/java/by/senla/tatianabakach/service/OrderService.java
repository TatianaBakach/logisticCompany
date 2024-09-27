package by.senla.tatianabakach.service;

import by.senla.tatianabakach.dto.OrderDTO;
import by.senla.tatianabakach.restTemplate.OrderPaymentInfoDTO;
import by.senla.tatianabakach.restTemplate.PaymentDTO;

public interface OrderService extends CrudService<OrderDTO> {
    void updateStatus(PaymentDTO paymentDTO);

    //todo
    void updateStatusCustomer(PaymentDTO paymentDTO);

    OrderPaymentInfoDTO getOrderWithPayment(Integer id);
}
