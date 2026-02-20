package com.test.coupon.infrastructure.persistence;

import com.test.coupon.domain.model.Coupon;
import com.test.coupon.domain.repository.CouponRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CouponRepositoryImpl implements CouponRepository {

    private final JpaCouponRepository jpaRepository;

    // Injeção de dependência via construtor
    public CouponRepositoryImpl(JpaCouponRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Coupon save(Coupon coupon) {
        return jpaRepository.save(coupon);
    }

    @Override
    public Optional<Coupon> findById(UUID id) {
        return jpaRepository.findById(id);
    }
}