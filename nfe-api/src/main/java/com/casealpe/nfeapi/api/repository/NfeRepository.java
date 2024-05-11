package com.casealpe.nfeapi.api.repository;

import com.casealpe.nfeapi.api.entity.Nfe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NfeRepository extends JpaRepository<Nfe, Long>, QuerydslPredicateExecutor<Nfe> {
}
