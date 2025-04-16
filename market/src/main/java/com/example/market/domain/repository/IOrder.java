package com.example.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.market.domain.dto.OrderDTO;

public interface IOrder {
    List<OrderDTO> getAll();
    Optional<OrderDTO> getById(Long id);
    OrderDTO save(OrderDTO orderDTO);
    OrderDTO update(Long id, OrderDTO orderDTO);
    boolean delete(Long id);
    List<OrderDTO> getByClientId(Long clientId);
}
