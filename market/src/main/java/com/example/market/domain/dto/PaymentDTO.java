package com.example.market.domain.dto;

import java.time.LocalDateTime;

public class PaymentDTO {

    private Long id;
    private LocalDateTime paymentDate;
    private Double amount;
    private String method;
    private String status;
    private Long orderId;
    private OrderDTO orderDTO;

    public Long getOrderId() {
        return orderId;
    }

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

    public OrderDTO getOrderDTO() {
        return orderDTO;
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

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    
    
}
