package com.test.coupon.domain.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.test.coupon.domain.model.Coupon;
import com.test.coupon.domain.repository.CouponRepository;
import com.test.coupon.dto.CouponRequestDTO;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class CouponService {

    private final CouponRepository repository;

    public CouponService(CouponRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Coupon createCoupon(CouponRequestDTO dto) {
        Coupon coupon = Coupon.create(
            dto.getCode(),
            dto.getDescription(),
            dto.getDiscountValue(),
            dto.getExpirationDate()
        );
        return repository.save(coupon);
    }

    @Transactional
    public void deleteCoupon(UUID id) {
        Coupon coupon = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Cupom não encontrado"));
        
        coupon.delete(); // Chama a regra no domínio
        repository.save(coupon);
    }
}