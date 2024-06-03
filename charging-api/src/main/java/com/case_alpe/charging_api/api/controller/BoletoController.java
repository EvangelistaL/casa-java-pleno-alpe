package com.case_alpe.charging_api.api.controller;

import com.case_alpe.charging_api.api.entity.Boleto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/boletos")
public interface BoletoController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<Boleto> retrieveBoletos(Pageable pageable);

    @GetMapping(path = "/{barcode}")
    @ResponseStatus(HttpStatus.OK)
    Boleto retrieveBoletoByBarcode(@PathVariable String barcode);

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    Boleto updateBoleto(@RequestBody Boleto boleto);
}
