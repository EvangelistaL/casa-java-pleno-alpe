package com.casealpe.webhookreceiver.internal.controller;

import com.casealpe.webhookreceiver.api.controller.NfeController;
import com.casealpe.webhookreceiver.api.model.Nfe;
import com.casealpe.webhookreceiver.api.usecase.ReceiveNfe;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@ConditionalOnSingleCandidate(NfeController.class)
public class DefaultNfeController implements NfeController {

    private final ReceiveNfe receiveNfe;

    @Override
    public List<Nfe> receiveNfe(MultipartFile file) {
        if (file.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        try {
           return this.receiveNfe.execute(file.getBytes());
        } catch (IOException e) {
            log.error(e.getMessage());
            return Collections.emptyList();
        }
    }
}
