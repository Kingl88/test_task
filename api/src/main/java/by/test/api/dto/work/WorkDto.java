package by.test.api.dto.work;

import by.test.api.dto.worker.WorkerDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Информация о выполняемых работах", name = "Work")
public class WorkDto {
    @Schema(description = "Идентификатор работы", example = "null")
    private Long id;

    @Schema(description = "Название выполняемой работы", example = "Замена комплекта ГРМ")
    private String name;

    @Schema(description = "Описание выполняемой работы", example = "Замена комплекта ГРМ каждые 100 тысяч км.")
    private String description;

    @Schema(description = "Время затраченное на выполнение работы", example = "3,5")
    private Integer timeSpentOnWork;

    @Schema(description = "Работник выполняющий работу")
    private WorkerDto worker;
}
