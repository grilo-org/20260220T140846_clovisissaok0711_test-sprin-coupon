package com.test.coupon.infrastructure.persistence;

import com.test.coupon.domain.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaCouponRepository extends JpaRepository<Coupon, UUID> {
    // Aqui o Spring Data implementa todos os métodos automaticamente
}