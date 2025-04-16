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
    private IPayment repository;

    public List<PaymentDTO> obtenerTodos() {
        return repository.getAll();
    }

    public Optional<PaymentDTO> obtenerPorId(Long id) {
        return repository.getById(id);
    }

    public PaymentDTO guardar(PaymentDTO dto) {
        return repository.save(dto);
    }

    public PaymentDTO actualizar(Long id, PaymentDTO dto) {
        return repository.update(id, dto);
    }

    public boolean eliminar(Long id) {
        return repository.delete(id);
    }
/*/
    public List<PaymentDTO> obtenerPorOrdenId(Long ordenId) {
        return repository.getByOrderId(ordenId);
    }/** */
}
