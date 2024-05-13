package com.casealpe.nfeapi.api.usecase;

import com.casealpe.nfeapi.api.entity.Nfe;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RetrieveNfe {

    Page<Nfe> execute(Pageable pageable, Predicate predicate);

    Nfe execute(Predicate predicate);
}
