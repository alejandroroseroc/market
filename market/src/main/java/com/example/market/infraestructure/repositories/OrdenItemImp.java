package com.example.market.infraestructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.domain.repository.IOrderItem;
import com.example.market.infraestructure.crud.OrdenItemRepository;
import com.example.market.infraestructure.entity.OrdenItem;
import com.example.market.infraestructure.mapper.OrdenItemMapper;

@Repository
public class OrdenItemImp implements IOrderItem {

    @Autowired
    private OrdenItemRepository repos;

    @Autowired
    private OrdenItemMapper mapper;

    @Override
    public List<OrderItemDTO> getAll() {
        return mapper.toOrderItemsDTO(repos.findAll());
    }

    @Override
    public Optional<OrderItemDTO> getById(Long id) {
        return repos.findById(id).map(mapper::toOrderItemDTO);
    }

    @Override
    public List<OrderItemDTO> getByOrderId(Long ordenId) {
        return mapper.toOrderItemsDTO(repos.findByOrdenId(ordenId));
    }

    @Override
    public OrderItemDTO save(OrderItemDTO dto) {
        OrdenItem entity = mapper.toOrdenItem(dto);
        return mapper.toOrderItemDTO(repos.save(entity));
    }

    @Override
    public OrderItemDTO update(Long id, OrderItemDTO dto) {
        if (repos.existsById(id)) {
            OrdenItem entity = mapper.toOrdenItem(dto);
            entity.setId(id);
            return mapper.toOrderItemDTO(repos.save(entity));
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (repos.existsById(id)) {
            repos.deleteById(id);
            return true;
        }
        return false;
    }
}
