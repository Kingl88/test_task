package by.test.core.controllers;

import by.test.api.dto.order.OrderDto;
import by.test.api.dto.order.OrderListResponse;
import by.test.core.controllers.interfaces.OrderController;
import by.test.core.mappers.OrderMapper;
import by.test.core.services.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v${test.api.version}/orders")
@RequiredArgsConstructor
public class OrderControllerImpl implements OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Override
    public OrderListResponse findAllOrders() {
        return OrderListResponse.builder()
                .orders(orderService.findAll().stream()
                        .map(orderMapper::mapToDto)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public OrderDto findOrderById(Long id) {
        return orderMapper.mapToDto(orderService.findById(id));
    }

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        return orderMapper.mapToDto(orderService.save(orderMapper.mapFromDto(orderDto)));
    }

    @Override
    public void updateOrder(OrderDto orderDto) {
        orderService.update(orderMapper.mapFromDto(orderDto));
    }

    @Override
    public void deleteOrder(Long id) {
        orderService.deleteById(id);
    }
}
