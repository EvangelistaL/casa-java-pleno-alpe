package com.casealpe.alpecostumers.api.usecase;

import com.casealpe.alpecostumers.api.entity.Costumer;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RetrieveCostumer {

    Page<Costumer> execute(Pageable pageable, Predicate predicate);

    Costumer execute(Predicate predicate);
}
