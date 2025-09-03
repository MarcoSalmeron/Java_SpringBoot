package com.futuro_digital.demo.Ecommerce.Controller;

import com.futuro_digital.demo.Ecommerce.Service.CategoriaService;
import com.futuro_digital.demo.Ecommerce.Service.ProductoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/api/home")
public class HomeController {

    @Autowired
    private final ProductoService productoService;

    @Autowired
    private final CategoriaService categoriaService;


    @GetMapping("/index")
    public String inicio(Model model) {
        var categorias = categoriaService.getListOfCategorias();
        var productos = productoService.getListOfProductos();
        model.addAttribute("categorias", categorias);
        model.addAttribute("productos", productos);
        return "index";
    }
}
