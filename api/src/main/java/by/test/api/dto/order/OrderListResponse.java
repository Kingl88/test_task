package by.test.api.dto.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Ответ сервера содержащий список заказов", name = "OrderList")
public class OrderListResponse {
    @Schema(description = "Список заказов")
    private List<OrderDto> orders;
}
