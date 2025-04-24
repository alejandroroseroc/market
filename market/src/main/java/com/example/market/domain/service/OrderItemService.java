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
    private IOrderItem repo;

    public List<OrderItemDTO> obtenerTodo() {
        return repo.getAll();
    }

    public Optional<OrderItemDTO> obtenerPorId(Long id) {
        return repo.getById(id);
    }

    public List<OrderItemDTO> obtenerPorOrden(Long ordenId) {
        return repo.getByOrderId(ordenId);
    }

    public OrderItemDTO guardar(OrderItemDTO dto) {
        return repo.save(dto);
    }

    public OrderItemDTO actualizar(Long id, OrderItemDTO dto) {
        return repo.update(id, dto);
    }

    public boolean eliminar(Long id) {
        return repo.delete(id);
    }
}
