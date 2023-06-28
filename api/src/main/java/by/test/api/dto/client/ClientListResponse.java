package by.test.api.dto.client;

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
@Schema(description = "Ответ сервера содержащий список клиентов", name = "ClientList")
public class ClientListResponse {
    @Schema(description = "Клиенты")
    private List<ClientDto> clients;
}
