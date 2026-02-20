package com.test.coupon.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CouponTest {

    @Test
    @DisplayName("Deve criar cupom com sucesso limpando caracteres especiais")
    void shouldCreateCouponSuccessfully() {
    	Coupon coupon = Coupon.create(
    	   "AB#12CD!", 
    	   "Desc", 
    	   new BigDecimal("10.0"), 
    	   LocalDate.now().plusDays(1)
    	);

    	assertEquals("AB12CD", coupon.getCode());
    	assertFalse(coupon.isDeleted());
    }

    @Test
    @DisplayName("Nao deve criar cupom com desconto abaixo de 0.5")
    void shouldNotCreateCouponWithLowDiscount() {
        assertThrows(IllegalArgumentException.class, () -> {
            Coupon.create("ABC123", "Desc", new BigDecimal("0.4"), LocalDate.now().plusDays(1));
        });
    }

    @Test
    @DisplayName("Nao deve criar cupom com data no passado")
    void shouldNotCreateCouponWithPastDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            Coupon.create("ABC123", "Desc", new BigDecimal("10.0"), LocalDate.now().minusDays(1));
        });
    }

    @Test
    @DisplayName("Deve realizar soft delete com sucesso")
    void shouldSoftDeleteCoupon() {
        Coupon coupon = Coupon.create("ABC123", "Desc", new BigDecimal("10.0"), LocalDate.now().plusDays(1));
        
        coupon.delete();
        
        assertTrue(coupon.isDeleted());
    }

    @Test
    @DisplayName("Nao deve deletar cupom ja deletado")
    void shouldNotDeleteAlreadyDeletedCoupon() {
        Coupon coupon = Coupon.create("ABC123", "Desc", new BigDecimal("10.0"), LocalDate.now().plusDays(1));
        coupon.delete();
        
        assertThrows(IllegalStateException.class, coupon::delete);
    }
}