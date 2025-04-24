package com.example.market.controller;

import java.util.List;

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
@RequestMapping("/ordenes/{ordenId}/items")
public class OrderItemController {

    @Autowired
    private OrderItemService service;

    // GET /ordenes/{ordenId}/items
    @GetMapping
    public List<OrderItemDTO> obtenerPorOrden(@PathVariable Long ordenId) {
        return service.obtenerPorOrden(ordenId);
    }

    // POST /ordenes/{ordenId}/items
    @PostMapping
    public ResponseEntity<OrderItemDTO> agregarItem(
            @PathVariable Long ordenId,
            @RequestBody OrderItemDTO dto) {
        dto.setOrderId(ordenId);
        return ResponseEntity.ok(service.guardar(dto));
    }

    // PUT /ordenes/{ordenId}/items/{id}
    @PutMapping("/{id}")
    public ResponseEntity<OrderItemDTO> actualizarItem(
            @PathVariable Long ordenId,
            @PathVariable Long id,
            @RequestBody OrderItemDTO dto) {
        dto.setOrderId(ordenId);
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    // DELETE /ordenes/{ordenId}/items/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarItem(
            @PathVariable Long ordenId,
            @PathVariable Long id) {
        // opcional: podrías validar que el item pertenece a esa ordenId
        if (service.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
