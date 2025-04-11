package com.example.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.market.domain.dto.OrderItemDTO;

public interface IOrderItem {
    List<OrderItemDTO> getAll();
    Optional<OrderItemDTO> getById(Long id);
    OrderItemDTO save(OrderItemDTO orderItemDTO);
    OrderItemDTO update(Long id, OrderItemDTO orderItemDTO);
    boolean delete(Long id);
    
}
