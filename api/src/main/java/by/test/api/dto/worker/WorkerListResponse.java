package by.test.api.dto.worker;

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
@Schema(description = "Ответ сервера содержащий список работников", name = "WorkerList")
public class WorkerListResponse {
    @Schema(description = "Работники")
    private List<WorkerDto> worker;
}
