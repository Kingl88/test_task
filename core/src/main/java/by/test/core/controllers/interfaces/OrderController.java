package by.test.core.controllers.interfaces;

import by.test.api.dto.order.OrderDto;
import by.test.api.dto.order.OrderListResponse;
import by.test.api.dto.util.MessageDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "order", description = "Контроллер для работы с заказами")
public interface OrderController {
    @Operation(
            operationId = "getAllOrders",
            summary = "Получение списка заказов",
            tags = {"order"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Список всех заказов", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = OrderListResponse.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @GetMapping(
            produces = {"application/json"}
    )
    OrderListResponse findAllOrders();

    @Operation(
            operationId = "findOrderById",
            summary = "Получить заказ по идентификатору",
            tags = {"order"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Заказ", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = OrderDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Заказ не найден", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @GetMapping(
            value = "/{id}",
            produces = {"application/json"}
    )
    OrderDto findOrderById(
            @Parameter(name = "id", description = "order id", required = true)
            @PathVariable("id") Long id
    );

    @Operation(
            operationId = "saveOrder",
            summary = "Добавление заказа",
            tags = {"order"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "Заказ успешно добавлен", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = OrderDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @PostMapping(
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.CREATED)
    OrderDto saveOrder(
            @Parameter(name = "order", description = "Order item", required = true)
            @RequestBody OrderDto orderDto
    );

    @Operation(
            operationId = "updateOrder",
            summary = "Обновление информации о заказе",
            tags = {"order"},
            responses = {
                    @ApiResponse(responseCode = "204", description = "Заказ успешно обновлен"),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Заказ не найден", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @PutMapping(
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateOrder(
            @Parameter(name = "order", description = "Order item", required = true) @RequestBody OrderDto orderDto
    );

    @Operation(
            operationId = "deleteOrder",
            summary = "Удаление заказа",
            tags = {"order"},
            responses = {
                    @ApiResponse(responseCode = "204", description = "Заказ успешно удален"),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Заказ не найден", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @DeleteMapping(
            value = "/{id}",
            produces = {"application/json"}
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteOrder(
            @Parameter(name = "id", description = "Order id", required = true)
            @PathVariable("id") Long id
    );
}
