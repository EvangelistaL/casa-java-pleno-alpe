package com.casealpe.nfeapi.api.usecase;

import com.casealpe.nfeapi.api.entity.Boleto;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RetrieveBoleto {

    Page<Boleto> execute(Pageable pageable, Predicate predicate);

    Boleto execute(Predicate predicate);

}
