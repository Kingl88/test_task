package by.test.api.dto.client;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Информация об клиентах", name = "Client")
public class ClientDto {
    @Schema(description = "Идентификатор клиента", example = "null")
    private Long id;

    @Schema(description = "Имя клиента", example = "Иван")
    private String firstName;

    @Schema(description = "Отчество клиента", example = "Иванович")
    private String surname;

    @Schema(description = "Фамилия клиента", example = "Иванов")
    private String lastName;

    @Schema(description = "Описание автомобиля", example = "Volvo XC60, 2,4L и т.д.")
    private String carDescription;

    @Schema(description = "Номер телефона", example = "+375(XX)XXX-XX-XX")
    private String phoneNumber;
}
