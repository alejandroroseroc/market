package com.example.market.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.domain.repository.IOrderItem;

@Service
public class OrderItemService {

    @Autowired
    private IOrderItem repository;

    public List<OrderItemDTO> obtenerTodo() {
        return repository.getAll();
    }

    public Optional<OrderItemDTO> obtenerPorId(Long id) {
        return repository.getById(id);
    }

    public OrderItemDTO guardar(OrderItemDTO dto) {
        return repository.save(dto);
    }

    public OrderItemDTO actualizar(Long id, OrderItemDTO dto) {
        return repository.update(id, dto);
    }

    public boolean eliminar(Long id) {
        return repository.delete(id);
    }
}
