package com.futuro_digital.demo.Ecommerce.Service;

import com.futuro_digital.demo.Ecommerce.DTO.PedidoDTO;
import com.futuro_digital.demo.Ecommerce.Entity.Pedido;
import com.futuro_digital.demo.Ecommerce.Repository.PedidoRepository;
import com.futuro_digital.demo.Ecommerce.Repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements  PedidoService {

    @Autowired
    private final PedidoRepository pedidoRepository;

    @Autowired
    private final UsuarioRepository usuarioRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Pedido> getListOfPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pedido findPedido(PedidoDTO dto) {
        return pedidoRepository.findById(dto.idPedido())
                .orElseThrow(()->new EntityNotFoundException("Pedido con ID :"+dto.idPedido()+" no encontrado..."));
    }

    @Override
    @Transactional
    public Pedido savePedido(PedidoDTO dto) {
        var usuario = usuarioRepository.findById(dto.usuario().idUsuario()).get();
        var pedido = Pedido.builder()
                .fecha(LocalDate.now())
                .usuario(usuario)
                .build();
        return pedidoRepository.save(pedido);
    }

    @Override
    @Transactional
    public void deletePedido(PedidoDTO dto) {
        pedidoRepository.deleteById(dto.idPedido());
    }
}
