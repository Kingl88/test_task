package by.test.core.controllers.interfaces;

import by.test.api.dto.auto_part.AutoPartDto;
import by.test.api.dto.auto_part.AutoPartListResponse;
import by.test.api.dto.util.MessageDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "autoPart", description = "Контроллер для работы с запчастями")
public interface AutoPartController {
    @Operation(
            operationId = "getAllAutoPart",
            summary = "Получение списка запчастей",
            tags = {"autoPart"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Список всех запчастей", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = AutoPartListResponse.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @GetMapping(
            produces = {"application/json"}
    )
    AutoPartListResponse findAllAutoParts();

    @Operation(
            operationId = "findAutoPartById",
            summary = "Получить запчасть по идентификатору",
            tags = {"autoPart"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Запчасть", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = AutoPartDto.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Запчасть не найдена", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @GetMapping(
            value = "/{id}",
            produces = {"application/json"}
    )
    AutoPartDto findAutoPartById(
            @Parameter(name = "id", description = "autoPart id", required = true)
            @PathVariable("id") Long id
    );

    @Operation(
            operationId = "saveAutoPart",
            summary = "Добавление запчасти",
            tags = {"autoPart"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "Запчасть успешно добавлена", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = AutoPartDto.class))
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
    AutoPartDto saveAutoPart(
            @Parameter(name = "autoPart", description = "AutoPart item", required = true)
            @RequestBody AutoPartDto autoPartDto
    );

    @Operation(
            operationId = "updateAutoPart",
            summary = "Обновление информации о запчасти",
            tags = {"autoPart"},
            responses = {
                    @ApiResponse(responseCode = "204", description = "Запчасть успешно обновлена"),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Запчасть не найдена", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @PutMapping(
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateAutoPart(
            @Parameter(name = "autoPart", description = "AutoPart item", required = true) @RequestBody AutoPartDto autoPartDto
    );

    @Operation(
            operationId = "deleteAutoPart",
            summary = "Удаление запчасти",
            tags = {"autoPart"},
            responses = {
                    @ApiResponse(responseCode = "204", description = "Запчасть успешно удалена"),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Запчасть не найдена", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))
                    })
            }
    )
    @DeleteMapping(
            value = "/{id}",
            produces = {"application/json"}
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAutoPart(
            @Parameter(name = "id", description = "AutoPart id", required = true)
            @PathVariable("id") Long id
    );
}
