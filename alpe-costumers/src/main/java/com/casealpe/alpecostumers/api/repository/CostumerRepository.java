package com.casealpe.alpecostumers.api.repository;

import com.casealpe.alpecostumers.api.entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CostumerRepository extends JpaRepository<Costumer, Long>,
        QuerydslPredicateExecutor<Costumer> {
}
