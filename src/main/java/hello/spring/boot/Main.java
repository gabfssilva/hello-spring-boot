package hello.spring.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

@SpringBootApplication
@RestController
@RequestMapping("/hello-spring-boot")
public class Main {
    @Value("${server.address}")
    private String appInterface;
    @Value("${server.port}")
    private Integer appPort;

    @RequestMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String hello() {
        return format("hello-spring-boot, world! running on %s:%d", appInterface, appPort);
    }

    @RequestMapping("/health")
    @ResponseStatus(HttpStatus.OK)
    public String health() {
        return format("ok!");
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
