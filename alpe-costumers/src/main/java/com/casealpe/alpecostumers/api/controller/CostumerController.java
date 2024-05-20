package com.casealpe.alpecostumers.api.controller;

import com.casealpe.alpecostumers.api.entity.Costumer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/costumers")
public interface CostumerController {

    @GetMapping(path = "/{identificationValue}")
    @ResponseStatus(HttpStatus.OK)
    Costumer retrieveCostumerById(@PathVariable String identificationValue);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Costumer createCostumer(@RequestBody Costumer costumer);
}