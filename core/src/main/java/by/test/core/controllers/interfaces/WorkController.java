package by.test.core.controllers.interfaces;

import by.test.api.dto.util.MessageDto;
import by.test.api.dto.work.WorkDto;
import by.test.api.dto.work.WorkListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "work", description = "Контроллер для работы с выполняемыми работами")
public interface WorkController {
    @Operation(
            operationId = "getAllWorks",
            summary = "Получение списка работ",
            tags = {"work"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Список всех выполняемых работ", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = WorkListResponse.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @GetMapping(
            produces = {"application/json"}
    )
    WorkListResponse findAllWorks();

    @Operation(
            operationId = "findWorkById",
            summary = "Получить работу по идентификатору",
            tags = {"work"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Работа", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = WorkDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Работа не найдена", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @GetMapping(
            value = "/{id}",
            produces = {"application/json"}
    )
    WorkDto findWorkById(
            @Parameter(name = "id", description = "work id", required = true)
            @PathVariable("id") Long id
    );

    @Operation(
            operationId = "saveWork",
            summary = "Добавление работы",
            tags = {"work"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "Работа успешно добавлена", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = WorkDto.class))
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
    WorkDto saveWork(
            @Parameter(name = "work", description = "work item", required = true)
            @RequestBody WorkDto workDto
    );

    @Operation(
            operationId = "updateWork",
            summary = "Обновление информации о работе",
            tags = {"work"},
            responses = {
                    @ApiResponse(responseCode = "204", description = "Работа успешно обновлена"),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Работа не найдена", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @PutMapping(
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateWork(
            @Parameter(name = "work", description = "Work item", required = true) @RequestBody WorkDto workDto
    );

    @Operation(
            operationId = "deleteWork",
            summary = "Удаление работы",
            tags = {"work"},
            responses = {
                    @ApiResponse(responseCode = "204", description = "Работа успешно удалена"),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Работа не найдена", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @DeleteMapping(
            value = "/{id}",
            produces = {"application/json"}
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteWork(
            @Parameter(name = "id", description = "Work id", required = true)
            @PathVariable("id") Long id
    );
}
