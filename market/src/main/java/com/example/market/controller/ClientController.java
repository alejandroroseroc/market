package com.example.market.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.market.domain.dto.ClientDTO;
import com.example.market.domain.service.ClientService;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDTO> obtenerClientes() {
        return clientService.obtenerTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> obtenerClientePorId(@PathVariable Long id) {
        Optional<ClientDTO> cliente = clientService.obtenerPorId(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClientDTO> crearCliente(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.guardar(clientDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> actualizarCliente(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.actualizar(id, clientDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        if (clientService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}