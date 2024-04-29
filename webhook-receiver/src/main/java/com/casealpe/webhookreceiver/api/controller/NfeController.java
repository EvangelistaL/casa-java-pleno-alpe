package com.casealpe.webhookreceiver.api.controller;

import com.casealpe.webhookreceiver.api.model.Nfe;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(path = "/receive-nfe")
public interface NfeController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    List<Nfe> receiveNfe(@RequestParam("file") MultipartFile file);
}
