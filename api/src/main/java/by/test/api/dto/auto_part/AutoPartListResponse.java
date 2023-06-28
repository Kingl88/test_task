package by.test.api.dto.auto_part;

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
@Schema(description = "Ответ сервера содержащий список запчастей", name = "AutoPartList")
public class AutoPartListResponse {
    @Schema(description = "Список запчастей")
    private List<AutoPartDto> autoParts;
}
