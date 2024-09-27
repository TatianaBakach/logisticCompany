package by.senla.tatianabakach.kafka;

import by.senla.tatianabakach.restTemplate.PaymentDTO;
import by.senla.tatianabakach.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
// компонент, который будет принимать сообщения
public class KafkaConsumer {

    private final ObjectMapper objectMapper;
    private final OrderService orderService;

    @KafkaListener(topics = "order_payment_topic", groupId = "order_payment_group")
    public void flightEventConsumer(String message) throws JsonProcessingException {
        PaymentDTO paymentDTO = objectMapper.readValue(message, PaymentDTO.class);
        orderService.updateStatusCustomer(paymentDTO);
        log.info("Consumer consume Kafka message -> {}", message);
    }

}