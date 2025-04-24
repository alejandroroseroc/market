package com.example.market.infraestructure.mapper;


import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.market.domain.dto.PaymentDTO;
import com.example.market.infraestructure.entity.Pago;

@Mapper(componentModel = "spring", uses = { OrdenMapper.class })
public interface PagoMapper {

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "fechaPago", target = "paymentDate"),
        @Mapping(source = "monto", target = "amount"),
        @Mapping(source = "metodo", target = "method"),
        @Mapping(source = "estado", target = "status"),
        @Mapping(source= "orden.id", target= "orderId"),
        @Mapping(source = "orden", target = "orderDTO") 
    })
    PaymentDTO toPaymentDTO(Pago pago);

    List<PaymentDTO> toPaymentsDTO(List<Pago> pagos);

    @InheritInverseConfiguration
    Pago toPago(PaymentDTO paymentDTO);
    List<Pago> toPagos(List<PaymentDTO> paymentsDTO);
}
