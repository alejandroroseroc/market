package com.example.market.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.domain.dto.OrderItemDTO;
import com.example.market.domain.service.OrderItemService;

@RestController
@RequestMapping("/orden-items")
public class OrderItemController {

    @Autowired
    private OrderItemService service;

    @GetMapping
    public List<OrderItemDTO> obtenerTodos() {
        return service.obtenerTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDTO> obtenerPorId(@PathVariable Long id) {
        Optional<OrderItemDTO> dto = service.obtenerPorId(id);
        return dto.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrderItemDTO> crear(@RequestBody OrderItemDTO dto) {
        return ResponseEntity.ok(service.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItemDTO> actualizar(@PathVariable Long id, @RequestBody OrderItemDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.eliminar(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
