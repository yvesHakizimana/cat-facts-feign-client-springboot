package com.rca.demofeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
@RestController
@RequestMapping("/api/cat-facts")
public class DemoFeignApplication {

    private DemoService demoService;

    @Autowired
    public DemoFeignApplication(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping
    public ResponseEntity<Object> getCatFacts() {
        return ResponseEntity.ok(demoService.getCatFacts(4).getData());
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoFeignApplication.class, args);
    }

}
