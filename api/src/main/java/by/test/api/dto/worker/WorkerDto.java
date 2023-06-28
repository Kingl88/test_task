package by.test.api.dto.worker;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Информация о работниках", name = "Worker")
public class WorkerDto {
    @Schema(description = "Идентификатор работника", example = "1")
    private Long id;

    @Schema(description = "Имя клиента", example = "Иван")
    private String firstName;

    @Schema(description = "Отчество клиента", example = "Сергеевич")
    private String surname;

    @Schema(description = "Фамилия клиента", example = "Петров")
    private String lastName;

    @Schema(description = "Стоимость норма-часа", example = "35")
    private Integer costOfOneHour;

    @Schema(description = "Специализация", example = "Ремонт подвески")
    private String specialization;
}
