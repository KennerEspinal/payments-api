package com.kendev.infrastructure.repository;

import com.kendev.infrastructure.entity.PaymentEntity;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface PaymentRepository extends CrudRepository<PaymentEntity, Long> {
    PaymentEntity findByTransactionId(String transactionId);
}
