package com.casealpe.nfeapi.internal.usecase;

import com.casealpe.nfeapi.api.entity.Boleto;
import com.casealpe.nfeapi.api.repository.BoletoRepository;
import com.casealpe.nfeapi.api.usecase.RetrieveBoleto;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DefaultRetrieveBoleto implements RetrieveBoleto {

    private final BoletoRepository boletoRepository;

    @Override
    public Page<Boleto> execute(Pageable pageable, Predicate predicate) {
        if (predicate != null){
            return this.boletoRepository.findAll(predicate, pageable);
        }
        return this.boletoRepository.findAll(pageable);
    }

    @Override
    public Boleto execute(Predicate predicate) {
        return this.boletoRepository.findOne(predicate)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
