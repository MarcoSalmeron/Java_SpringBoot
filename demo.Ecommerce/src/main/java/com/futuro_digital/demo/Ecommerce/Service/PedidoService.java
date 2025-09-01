package com.futuro_digital.demo.Ecommerce.Service;

import com.futuro_digital.demo.Ecommerce.DTO.PedidoDTO;
import com.futuro_digital.demo.Ecommerce.Entity.Pedido;

import java.util.List;

public interface PedidoService {

    List<Pedido> getListOfPedidos();

    Pedido findPedido(PedidoDTO dto);

    Pedido savePedido(PedidoDTO dto);

    void deletePedido(PedidoDTO dto);
}
