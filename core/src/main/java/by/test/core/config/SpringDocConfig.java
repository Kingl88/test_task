package by.test.core.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    OpenAPI apiInfo() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Задание на стажировку")
                                .description("Стол заказов на ремонтные работы в автомастерской (demo)")
                                .version("1.0.0")
                )
                .addServersItem(new Server().url("http://localhost:8081").description("dev"))
                ;
    }
}