package by.test.core.controllers.interfaces;

import by.test.api.dto.client.ClientDto;
import by.test.api.dto.client.ClientListResponse;
import by.test.api.dto.util.MessageDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "client", description = "Контроллер для работы с клиентами")
public interface ClientController {
    @Operation(
            operationId = "getAllClients",
            summary = "Получение списка клиентов",
            tags = {"client"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Список всех клиентов", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ClientListResponse.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @GetMapping(
            produces = {"application/json"}
    )
    ClientListResponse findAllClients();

    @Operation(
            operationId = "findClientById",
            summary = "Получить клиента по идентификатору",
            tags = {"client"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Клиент", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ClientDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Клиент не найдена", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @GetMapping(
            value = "/{id}",
            produces = {"application/json"}
    )
    ClientDto findClientById(
            @Parameter(name = "id", description = "client id", required = true)
            @PathVariable("id") Long id
    );

    @Operation(
            operationId = "saveClient",
            summary = "Добавление клиента",
            tags = {"client"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "Клиент успешно добавлен", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ClientDto.class))
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
    ClientDto saveClient(
            @Parameter(name = "client", description = "Client item", required = true)
            @RequestBody ClientDto client
    );

    @Operation(
            operationId = "updateClient",
            summary = "Обновление информации о клиенте",
            tags = {"client"},
            responses = {
                    @ApiResponse(responseCode = "204", description = "Клиент успешно обновлен"),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Клиент не найден", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @PutMapping(
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateClient(
            @Parameter(name = "client", description = "Client item", required = true) @RequestBody ClientDto clientDto
    );

    @Operation(
            operationId = "deleteClient",
            summary = "Удаление клиента",
            tags = {"client"},
            responses = {
                    @ApiResponse(responseCode = "204", description = "Клиент успешно удален"),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Клиент не найден", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @DeleteMapping(
            value = "/{id}",
            produces = {"application/json"}
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteClient(
            @Parameter(name = "id", description = "Client id", required = true)
            @PathVariable("id") Long id
    );
}
