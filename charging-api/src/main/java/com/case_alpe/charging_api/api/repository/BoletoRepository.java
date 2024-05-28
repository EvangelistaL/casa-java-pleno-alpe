package com.case_alpe.charging_api.api.repository;

import com.case_alpe.charging_api.api.entity.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BoletoRepository extends JpaRepository<Boleto, Long>,
        QuerydslPredicateExecutor<Boleto> {
}
