package com.rca.demofeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "Cat-facts", url = "https://meowfacts.herokuapp.com/")
public interface DemoService {

    @GetMapping()
    CatFactResponse getCatFacts(@RequestParam("count") int count);
}
