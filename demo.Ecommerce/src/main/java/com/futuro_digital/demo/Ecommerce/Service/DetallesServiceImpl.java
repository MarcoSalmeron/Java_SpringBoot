package com.futuro_digital.demo.Ecommerce.Service;

import com.futuro_digital.demo.Ecommerce.DTO.DetallePedidoDTO;
import com.futuro_digital.demo.Ecommerce.Entity.DetallePedido;
import com.futuro_digital.demo.Ecommerce.Repository.DetallesPedidoRepository;
import com.futuro_digital.demo.Ecommerce.Repository.PedidoRepository;
import com.futuro_digital.demo.Ecommerce.Repository.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetallesServiceImpl implements DetallesService {

    @Autowired
    private final DetallesPedidoRepository detallesPedidoRepository;

    @Autowired
    private final PedidoRepository pedidoRepository;

    @Autowired
    private final ProductoRepository productoRepository;


    @Override
    @Transactional(readOnly = true)
    public List<DetallePedido> getListOfDetallesPedidos() {
        return detallesPedidoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public DetallePedido findDetallePedido(DetallePedidoDTO dto) {
        return detallesPedidoRepository.findById(dto.idDetallePedido())
                .orElseThrow(()->new EntityNotFoundException("Pedido con ID : "+dto.idDetallePedido()+" no encontrado..."));
    }

    @Override
    @Transactional
    public DetallePedido saveDetallePedido(DetallePedidoDTO dto) {
        var pedido = pedidoRepository.findById(dto.pedido().idPedido()).get();
        var producto = productoRepository.findById(dto.producto().id()).get();
        var detalle = DetallePedido.builder()
                .pedido(pedido)
                .producto(producto)
                .cantidad(dto.cantidad())
                .precio_unitario(dto.precio_unitario())
                .build();
        return detallesPedidoRepository.save(detalle);
    }

    @Override
    @Transactional
    public void deleteDetallePedido(DetallePedidoDTO dto) {
        detallesPedidoRepository.deleteById(dto.idDetallePedido());
    }
}
