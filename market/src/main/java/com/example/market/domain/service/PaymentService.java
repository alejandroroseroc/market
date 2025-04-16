package com.example.market.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.domain.dto.PaymentDTO;
import com.example.market.domain.repository.IPayment;

@Service
public class PaymentService {

    @Autowired
    private IPayment iPayment;

    public List<PaymentDTO> obtenerTodos() {
        return iPayment.getAll();
    }

    public Optional<PaymentDTO> obtenerPorId(Long id) {
        return iPayment.getById(id);
    }

    public PaymentDTO guardar(PaymentDTO dto) {
        return iPayment.save(dto);
    }

    public PaymentDTO actualizar(Long id, PaymentDTO dto) {
        return iPayment.update(id, dto);
    }

    public boolean eliminar(Long id) {
        return iPayment.delete(id);
    }

    public List<PaymentDTO> obtenerPorOrden(Long ordenId) {
        return iPayment.getByOrderId(ordenId);
    }
}
