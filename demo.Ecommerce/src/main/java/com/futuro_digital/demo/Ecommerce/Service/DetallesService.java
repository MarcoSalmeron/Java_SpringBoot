package com.futuro_digital.demo.Ecommerce.Service;

import com.futuro_digital.demo.Ecommerce.DTO.DetallePedidoDTO;
import com.futuro_digital.demo.Ecommerce.Entity.DetallePedido;

import java.util.List;

public interface DetallesService {

    List<DetallePedido> getListOfDetallesPedidos();

    DetallePedido findDetallePedido(DetallePedidoDTO dto);

    DetallePedido saveDetallePedido(DetallePedidoDTO dto);

    void deleteDetallePedido(DetallePedidoDTO dto);
}
