package by.test.api.dto.work;

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
@Schema(description = "Ответ сервера содержащий список выполняемых работ", name = "WorkList")
public class WorkListResponse {
    @Schema(description = "Выполняемые работы")
    private List<WorkDto> works;
}
