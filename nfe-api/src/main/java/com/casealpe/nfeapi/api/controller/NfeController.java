package com.casealpe.nfeapi.api.controller;

import com.casealpe.nfeapi.api.entity.Nfe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/nfe")
public interface NfeController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<Nfe> retrieveAll(Pageable pageable);

    @GetMapping(path = "/{nfeNumber}")
    @ResponseStatus(HttpStatus.OK)
    Nfe retrieveNfeByNfeNumber(@PathVariable String nfeNumber);
}
