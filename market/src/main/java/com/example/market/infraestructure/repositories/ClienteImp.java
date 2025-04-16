package com.example.market.infraestructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.market.domain.dto.ClientDTO;
import com.example.market.domain.repository.IClient;
import com.example.market.infraestructure.crud.ClienteRepository;
import com.example.market.infraestructure.entity.Cliente;
import com.example.market.infraestructure.mapper.ClienteMapper;

@Repository
public class ClienteImp implements IClient {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public List<ClientDTO> getAll() {
        return clienteMapper.toClientsDTO(clienteRepository.findAll());
    }

    @Override
    public Optional<ClientDTO> getById(Long id) {
        return clienteRepository.findById(id).map(clienteMapper::toClientDTO);
    }

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        Cliente cliente = clienteMapper.toCliente(clientDTO);
        return clienteMapper.toClientDTO(clienteRepository.save(cliente));
    }

    @Override
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        if (clienteRepository.existsById(id)) {
            Cliente cliente = clienteMapper.toCliente(clientDTO);
            cliente.setId(id);
            return clienteMapper.toClientDTO(clienteRepository.save(cliente));
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}