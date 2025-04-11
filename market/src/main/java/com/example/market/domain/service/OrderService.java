package com.example.market.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.domain.dto.OrderDTO;
import com.example.market.domain.repository.IOrder;

@Service
public class OrderService {

    @Autowired
    private IOrder iOrder;

    public List<OrderDTO> obtenerTodo() {
        return iOrder.getAll();
    }

    public Optional<OrderDTO> obtenerPorId(Long id) {
        return iOrder.getById(id);
    }

    public OrderDTO guardar(OrderDTO orderDTO) {
        return iOrder.save(orderDTO);
    }

    public OrderDTO actualizar(Long id, OrderDTO orderDTO) {
        return iOrder.update(id, orderDTO);
    }

    public boolean eliminar(Long id) {
        return iOrder.delete(id);
    }

    public List<OrderDTO> obtenerPorCliente(Long clienteId) {
        return iOrder.getByClientId(clienteId);
    }
}
