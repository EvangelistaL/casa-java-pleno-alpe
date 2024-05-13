package com.casealpe.nfeapi.internal.usecase;

import com.casealpe.nfeapi.api.entity.Nfe;
import com.casealpe.nfeapi.api.repository.NfeRepository;
import com.casealpe.nfeapi.api.usecase.RetrieveNfe;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DefaultRetrieveNfe implements RetrieveNfe {

    private final NfeRepository nfeRepository;

    @Override
    public Page<Nfe> execute(Pageable pageable, Predicate predicate) {
        if (predicate != null){
            return this.nfeRepository.findAll(predicate, pageable);
        }
        return this.nfeRepository.findAll(pageable);
    }

    @Override
    public Nfe execute(Predicate predicate) {
        return this.nfeRepository.findOne(predicate)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
