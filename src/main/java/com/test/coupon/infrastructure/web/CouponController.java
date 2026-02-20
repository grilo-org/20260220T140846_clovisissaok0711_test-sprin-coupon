package com.test.coupon.infrastructure.web;

import com.test.coupon.domain.model.Coupon;
import com.test.coupon.domain.service.CouponService;
import com.test.coupon.dto.CouponRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/coupons")
@Tag(name = "Coupons", description = "API de gerenciamento de cupons")
public class CouponController {

    private final CouponService applicationService;

    public CouponController(CouponService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    @Operation(summary = "Cadastrar um novo cupom")
    public ResponseEntity<Coupon> createCoupon(@Valid @RequestBody CouponRequestDTO dto) {
        Coupon createdCoupon = applicationService.createCoupon(dto);
        return new ResponseEntity<>(createdCoupon, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um cupom (Soft Delete)")
    public ResponseEntity<Void> deleteCoupon(@PathVariable UUID id) {
        applicationService.deleteCoupon(id);
        return ResponseEntity.noContent().build();
    }
}