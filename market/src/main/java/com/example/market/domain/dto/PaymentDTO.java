package com.example.market.domain.dto;

import java.time.LocalDateTime;

public class PaymentDTO {

    private Long id;
    private LocalDateTime paymentDate;
    private Double amount;
    private String method;
    private String status;
    private Long orderId;

    public Long getId() {
        return id;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    public String getStatus() {
        return status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    
}
