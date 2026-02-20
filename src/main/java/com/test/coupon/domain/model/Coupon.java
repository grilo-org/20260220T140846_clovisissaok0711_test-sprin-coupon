package com.test.coupon.domain.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "coupons")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 6)
    private String code;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal discountValue;

    @Column(nullable = false)
    private LocalDate expirationDate;

    @Column(nullable = false)
    private boolean deleted = false;

    // Construtor protegido para forçar uso da lógica de negócio
    protected Coupon() {}

    // FACTORY METHOD (Regra de Negócio Encapsulada)
    public static Coupon create(String code, String description, BigDecimal discountValue, LocalDate expirationDate) {
        
    	// Regra: Remover caracteres especiais e garantir 6 caracteres
        String cleanCode = code.replaceAll("[^a-zA-Z0-9]", "");
        if (cleanCode.length() != 6) {
            throw new IllegalArgumentException("Código deve ter 6 caracteres alfanuméricos");
        }

        // Regra: Valor mínimo 0.5
        if (discountValue.compareTo(new BigDecimal("0.5")) < 0) {
            throw new IllegalArgumentException("Desconto mínimo é 0.5");
        }

        // Regra: Data não pode ser no passado
        if (expirationDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data de expiração não pode ser no passado");
        }

        Coupon coupon = new Coupon();
        coupon.code = cleanCode;
        coupon.description = description;
        coupon.discountValue = discountValue;
        coupon.expirationDate = expirationDate;
        return coupon;
    }

    public void delete() {
        if (this.deleted) {
            throw new IllegalStateException("Cupom já está deletado");
        }
        this.deleted = true;
    }
    
    // Getters apenas
    public UUID getId() { return id; }
    public String getCode() { return code; }
    public boolean isDeleted() { return deleted; }

}