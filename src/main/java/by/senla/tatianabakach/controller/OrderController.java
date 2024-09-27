package by.senla.tatianabakach.controller;

import by.senla.tatianabakach.restTemplate.OrderPaymentInfoDTO;
import by.senla.tatianabakach.restTemplate.PaymentDTO;
import by.senla.tatianabakach.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("{id}")
    public OrderPaymentInfoDTO findById(@PathVariable("id") Integer id){
        return orderService.getOrderWithPayment(id);

    }

    @PostMapping
    public void updateOrderStatus(@RequestBody PaymentDTO paymentDTO) {
        orderService.updateStatus(paymentDTO);
    }

}
