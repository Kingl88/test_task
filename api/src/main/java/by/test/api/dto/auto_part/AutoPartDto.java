package by.test.api.dto.auto_part;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Информация о запчасти", name = "AutoPart")
public class AutoPartDto {
    @Schema(description = "Идентификатор работы", example = "null")
    private Long id;

    @Schema(description = "Артикул запчасти", example = "qwerty123")
    private String nameOfPart;

    @Schema(description = "Стоимость запчасти", example = "25")
    private Integer cost;

    @Schema(description = "Поставщик", example = "ШАТЕ-М")
    private String distributor;
}
