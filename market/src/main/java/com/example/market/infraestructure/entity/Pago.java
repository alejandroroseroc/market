package com.example.market.infraestructure.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagos")

public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaPago;
    private Double monto;
    private String metodo;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;

    public Pago(String estado, LocalDateTime fechaPago, Long id, String metodo, Double monto, Orden orden) {

        
        this.estado = estado;
        this.fechaPago = fechaPago;
        this.id = id;
        this.metodo = metodo;
        this.monto = monto;
        this.orden = orden;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public Double getMonto() {
        return monto;
    }

    public String getMetodo() {
        return metodo;
    }

    public String getEstado() {
        return estado;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }
}
