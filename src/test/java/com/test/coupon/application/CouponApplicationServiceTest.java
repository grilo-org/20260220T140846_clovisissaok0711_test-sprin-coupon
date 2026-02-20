package com.test.coupon.application;

import com.test.coupon.domain.model.Coupon;
import com.test.coupon.domain.service.CouponService;
import com.test.coupon.dto.CouponRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test") // Use um application-test.properties com H2
class CouponApplicationServiceTest {

    @Autowired
    private CouponService service;

    @Test
    void testCreateAndSoftDeleteFlow() {
        CouponRequestDTO dto = new CouponRequestDTO(
            "AAA111", "Test", new BigDecimal("10.0"), LocalDate.now().plusDays(1)
        );
        Coupon created = service.createCoupon(dto);
        assertNotNull(created.getId());

        service.deleteCoupon(created.getId());
    }
}