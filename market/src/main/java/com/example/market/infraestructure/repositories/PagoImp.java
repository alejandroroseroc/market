package com.example.market.infraestructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.market.domain.dto.PaymentDTO;
import com.example.market.domain.repository.IPayment;
import com.example.market.infraestructure.crud.PagoRepository;
import com.example.market.infraestructure.entity.Pago;
import com.example.market.infraestructure.mapper.PagoMapper;

@Repository
public class PagoImp implements IPayment {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private PagoMapper pagoMapper;

    @Override
    public List<PaymentDTO> getAll() {
        List<Pago> pagos = pagoRepository.findAll();
        return pagoMapper.toPaymentsDTO(pagos);
    }

    @Override
    public Optional<PaymentDTO> getById(Long id) {
        return pagoRepository.findById(id)
                .map(pagoMapper::toPaymentDTO);
    }

    @Override
    public PaymentDTO save(PaymentDTO paymentDTO) {
        Pago pago = pagoMapper.toPago(paymentDTO);
        return pagoMapper.toPaymentDTO(pagoRepository.save(pago));
    }

    @Override
    public PaymentDTO update(Long id, PaymentDTO paymentDTO) {
        if (pagoRepository.existsById(id)) {
            Pago pago = pagoMapper.toPago(paymentDTO);
            pago.setId(id);
            return pagoMapper.toPaymentDTO(pagoRepository.save(pago));
        }
        throw new IllegalArgumentException("Payment with ID " + id + " does not exist.");
    }

    @Override
    public boolean delete(Long id) {
        if (pagoRepository.existsById(id)) {
            pagoRepository.deleteById(id);
            return true;
        }
        return false;

    }

/*/
    @Override
    public List<PaymentDTO> getByOrderId(Long orderId) {
        List<Pago> pagos = pagoRepository.findByOrdenId(orderId);
        return pagoMapper.toPaymentsDTO(pagos);
    }/* */
}
