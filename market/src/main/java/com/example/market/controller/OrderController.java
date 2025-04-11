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

import com.example.market.domain.dto.OrderDTO;
import com.example.market.domain.service.OrderService;

@RestController
@RequestMapping("/ordenes")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderDTO> obtenerOrdenes() {
        return orderService.obtenerTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> obtenerOrdenPorId(@PathVariable Long id) {
        Optional<OrderDTO> orden = orderService.obtenerPorId(id);
        return orden.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrderDTO> crearOrden(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.guardar(orderDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> actualizarOrden(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.actualizar(id, orderDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOrden(@PathVariable Long id) {
        if (orderService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cliente/{clienteId}")
    public List<OrderDTO> obtenerOrdenesPorCliente(@PathVariable Long clienteId) {
        return orderService.obtenerPorCliente(clienteId);
    }
}
