package by.test.core.controllers.interfaces;

import by.test.api.dto.util.MessageDto;
import by.test.api.dto.worker.WorkerDto;
import by.test.api.dto.worker.WorkerListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "worker", description = "Контроллер для работы с работниками")
public interface WorkerController {
    @Operation(
            operationId = "getAllWorkers",
            summary = "Получение списка работников",
            tags = {"worker"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Список всех работников", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = WorkerListResponse.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @GetMapping(
            produces = {"application/json"}
    )
    WorkerListResponse findAllWorkers();

    @Operation(
            operationId = "findWorkerById",
            summary = "Получить работника по идентификатору",
            tags = {"worker"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Работник", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = WorkerDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Работник не найдена", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @GetMapping(
            value = "/{id}",
            produces = {"application/json"}
    )
    WorkerDto findWorkerById(
            @Parameter(name = "id", description = "worker id", required = true)
            @PathVariable("id") Long id
    );

    @Operation(
            operationId = "saveWorker",
            summary = "Добавление работника",
            tags = {"worker"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "Работник успешно добавлен", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = WorkerDto.class))
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
    WorkerDto saveWorker(
            @Parameter(name = "worker", description = "Worker item", required = true)
            @RequestBody WorkerDto workerDto
    );

    @Operation(
            operationId = "updateWorker",
            summary = "Обновление информации о работнике",
            tags = {"worker"},
            responses = {
                    @ApiResponse(responseCode = "204", description = "Работник успешно обновлен"),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Работник не найден", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @PutMapping(
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateWorker(
            @Parameter(name = "worker", description = "Worker item", required = true) @RequestBody WorkerDto workerDto
    );

    @Operation(
            operationId = "deleteWorker",
            summary = "Удаление работника",
            tags = {"worker"},
            responses = {
                    @ApiResponse(responseCode = "204", description = "Работник успешно удален"),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Работник не найден", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @DeleteMapping(
            value = "/{id}",
            produces = {"application/json"}
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteWorker(
            @Parameter(name = "id", description = "Worker id", required = true)
            @PathVariable("id") Long id
    );
}
