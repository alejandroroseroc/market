package com.example.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.market.domain.dto.ClientDTO;

public interface IClient {
    List<ClientDTO> getAll();

    Optional<ClientDTO> getById(Long id);

    ClientDTO save(ClientDTO clientDTO);

    ClientDTO update(Long id, ClientDTO clientDTO);

    boolean delete(Long id);
}