
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

import com.example.market.domain.dto.PaymentDTO;
import com.example.market.domain.service.PaymentService;

@RestController
@RequestMapping("/pagos")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @GetMapping
    public List<PaymentDTO> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> obtenerPorId(@PathVariable Long id) {
        Optional<PaymentDTO> dto = service.obtenerPorId(id);
        return dto.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PaymentDTO> crear(@RequestBody PaymentDTO dto) {
        return ResponseEntity.ok(service.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentDTO> actualizar(@PathVariable Long id, @RequestBody PaymentDTO dto) {
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
/*/
    @GetMapping("/orden/{ordenId}")
    public List<PaymentDTO> obtenerPorOrdenId(@PathVariable Long ordenId) {
        return service.obtenerPorOrdenId(ordenId);
    }/*/
}
