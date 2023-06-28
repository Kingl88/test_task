package by.test.api.dto.order;

import by.test.api.dto.auto_part.AutoPartDto;
import by.test.api.dto.client.ClientDto;
import by.test.api.dto.work.WorkDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Информация о заказах", name = "Order")
public class OrderDto {

    @Schema(description = "Идентификатор заказа", example = "null")
    private Long id;

    @Schema(description = "Статус заказа", example = "В работе")
    private String status;

    @Schema(description = "Конечная стоимость по заказу", example = "257")
    private BigDecimal totalPrice;

    @Schema(description = "Заказчик")
    private ClientDto client;

    @Schema(description = "Список выполненных работ")
    private List<WorkDto> works;

    @Schema(description = "Список используемых запчастей")
    private List<AutoPartDto> autoParts;
}
