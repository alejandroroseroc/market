package com.example.market.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.domain.dto.ClientDTO;
import com.example.market.domain.repository.IClient;

@Service
public class ClientService {

    @Autowired
    private IClient iClient;

    public List<ClientDTO> obtenerTodo() {
        return iClient.getAll();
    }

    public Optional<ClientDTO> obtenerPorId(Long id) {
        return iClient.getById(id);
    }

    public ClientDTO guardar(ClientDTO clientDTO) {
        return iClient.save(clientDTO);
    }

    public ClientDTO actualizar(Long id, ClientDTO clientDTO) {
        return iClient.update(id, clientDTO);
    }

    public boolean eliminar(Long id) {
        return iClient.delete(id);
    }
}