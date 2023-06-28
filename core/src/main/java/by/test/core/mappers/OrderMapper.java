package by.test.core.mappers;

import by.test.api.dto.order.OrderDto;
import by.test.core.entities.Order;
import org.mapstruct.Mapper;

@Mapper(uses = {ClientMapper.class, WorkMapper.class, AutoPartMapper.class})
public interface OrderMapper {
    OrderDto mapToDto(Order entity);

    Order mapFromDto(OrderDto dto);
}
