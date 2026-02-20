package com.test.coupon.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CouponRequestDTO {

    @NotBlank(message = "O código é obrigatório")
    private String code;

    @NotBlank(message = "A descrição é obrigatória")
    private String description;

    @NotNull(message = "O valor do desconto é obrigatório")
    @Positive(message = "O valor deve ser positivo")
    private BigDecimal discountValue;

    @NotNull(message = "A data de expiração é obrigatória")
    @FutureOrPresent(message = "A data não pode estar no passado")
    private LocalDate expirationDate;

    // Construtores
    public CouponRequestDTO() {}

    public CouponRequestDTO(String code, String description, BigDecimal discountValue, LocalDate expirationDate) {
        this.code = code;
        this.description = description;
        this.discountValue = discountValue;
        this.expirationDate = expirationDate;
    }

    // Getters e Setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getDiscountValue() { return discountValue; }
    public void setDiscountValue(BigDecimal discountValue) { this.discountValue = discountValue; }

    public LocalDate getExpirationDate() { return expirationDate; }
    public void setExpirationDate(LocalDate expirationDate) { this.expirationDate = expirationDate; }
}