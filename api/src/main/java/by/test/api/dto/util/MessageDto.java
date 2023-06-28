package by.test.api.dto.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "Сообщение с полезной информацией или ошибкой", name = "Message")
public class MessageDto {
    @Schema(description = "Сообщение")
    private String message;
    @Schema(description = "Дата появления сообщения")
    private Date date;

    public MessageDto() {
        this.date = new Date();
    }

    public MessageDto(String message) {
        this.message = message;
        this.date = new Date();
    }
}
