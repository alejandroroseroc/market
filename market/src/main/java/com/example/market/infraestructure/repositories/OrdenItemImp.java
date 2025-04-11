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
    private OrdenItemRepository ordenItemRepository;

    @Autowired
    private OrdenItemMapper ordenItemMapper;

    @Override
    public List<OrderItemDTO> getAll() {
        return ordenItemMapper.toOrderItemsDTO(ordenItemRepository.findAll());
    }

    @Override
    public Optional<OrderItemDTO> getById(Long id) {
        return ordenItemRepository.findById(id)
                .map(ordenItemMapper::toOrderItemDTO);
    }

    @Override
    public OrderItemDTO save(OrderItemDTO dto) {
        OrdenItem entity = ordenItemMapper.toOrdenItem(dto);
        return ordenItemMapper.toOrderItemDTO(ordenItemRepository.save(entity));
    }

    @Override
    public OrderItemDTO update(Long id, OrderItemDTO dto) {
        if (ordenItemRepository.existsById(id)) {
            OrdenItem entity = ordenItemMapper.toOrdenItem(dto);
            entity.setId(id);
            return ordenItemMapper.toOrderItemDTO(ordenItemRepository.save(entity));
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (ordenItemRepository.existsById(id)) {
            ordenItemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
