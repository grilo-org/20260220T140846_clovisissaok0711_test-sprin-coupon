package com.test.coupon.domain.repository;

import com.test.coupon.domain.model.Coupon;
import java.util.Optional;
import java.util.UUID;

public interface CouponRepository {
    Coupon save(Coupon coupon);
    Optional<Coupon> findById(UUID id);
}