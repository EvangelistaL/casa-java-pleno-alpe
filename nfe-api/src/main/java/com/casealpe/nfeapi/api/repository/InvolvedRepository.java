package com.casealpe.nfeapi.api.repository;

import com.casealpe.nfeapi.api.entity.Involved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InvolvedRepository extends JpaRepository<Involved, Long>, QuerydslPredicateExecutor<Involved> {
}
