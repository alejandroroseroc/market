package com.example.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.market.domain.dto.PaymentDTO;

public interface IPayment {
    List<PaymentDTO> getAll();
    Optional<PaymentDTO> getById(Long id);
    PaymentDTO save(PaymentDTO paymentDTO);
    PaymentDTO update(Long id, PaymentDTO paymentDTO);
    boolean delete(Long id);
}
