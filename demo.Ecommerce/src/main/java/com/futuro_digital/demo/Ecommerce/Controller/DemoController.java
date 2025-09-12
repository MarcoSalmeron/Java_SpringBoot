package com.futuro_digital.demo.Ecommerce.Controller;

import com.futuro_digital.demo.Ecommerce.DTO.UsuarioDTO;
import com.futuro_digital.demo.Ecommerce.Entity.Producto;
import com.futuro_digital.demo.Ecommerce.Service.CategoriaService;
import com.futuro_digital.demo.Ecommerce.Service.ProductoService;
import com.futuro_digital.demo.Ecommerce.Service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/demo/productos")
public class DemoController {

    @Autowired
    private final ProductoService productoService;

    @Autowired
    private final CategoriaService categoriaService;


    // Mostrar Todos los Productos
    @GetMapping("/all")
    public String mostrarProductos(Model model){
        model.addAttribute("productos_lista", productoService.getListOfProductos());
        model.addAttribute("categorias_lista", categoriaService.getListOfCategorias());
        return "demo";
    }

    // Mostrar Login
    @GetMapping("/login")
    public String mostrarLogin(){
        return "login";
    }




    /**
     *
     * Filtrado:
     *  -Categoria
     *  -Marca
     *  -Precio
     *
     */
    @GetMapping("/filter/categoria/{categoria}")
    public String filterByCategoria(@PathVariable String categoria, Model model) {
        var productos = productoService.getListOfProductos().stream().filter(p->p.getCategoria().getCategoria().equalsIgnoreCase(categoria)).toList();
        model.addAttribute("categorias_lista", categoriaService.getListOfCategorias());
        model.addAttribute("productos_lista", productos);
        return "demo";
    }

    @GetMapping("/filter/marca/{marca}")
    public String filterByMarca(@PathVariable String marca, Model model) {
        var productos = productoService.getListOfProductos().stream().filter(p->p.getMarca().equalsIgnoreCase(marca)).toList();
        model.addAttribute("productos_lista", productos);
        model.addAttribute("categorias_lista", categoriaService.getListOfCategorias());
        return "demo";
    }

    @GetMapping("/filter/precio/{precio}")
    public String filterByPrecio(@PathVariable Double precio, Model model) {
        var productos = productoService.getListOfProductos().stream().filter(p-> Math.round(p.getPrecio()) <= precio).toList();
        model.addAttribute("productos_lista", productos);
        model.addAttribute("categorias_lista", categoriaService.getListOfCategorias());
        return "demo";
    }

    /**
     * Ordenamiento:
     *  -Categoria
     *  -Marca
     *  -Precio
     *  -Descuento
     *
     */
    @GetMapping("/sort/categoria")
    public String sortByCategoria(Model model) {
        var productos = productoService.getListOfProductos().stream().sorted(Comparator.comparing(p->p.getCategoria().getCategoria())).toList();
        model.addAttribute("productos_lista", productos);
        model.addAttribute("categorias_lista", categoriaService.getListOfCategorias());
        return "demo";
    }

    @GetMapping("/sort/marca")
    public String sortByMarca(Model model) {
        var productos = productoService.getListOfProductos().stream().sorted(Comparator.comparing(Producto::getMarca)).toList();
        model.addAttribute("productos_lista", productos);
        model.addAttribute("categorias_lista", categoriaService.getListOfCategorias());
        return "demo";
    }

    @GetMapping("/sort/precio")
    public String sortByPrecio(Model model) {
        var productos = productoService.getListOfProductos().stream().sorted(Comparator.comparingDouble(Producto::getPrecio)).toList();
        model.addAttribute("productos_lista", productos);
        model.addAttribute("categorias_lista", categoriaService.getListOfCategorias());
        return "demo";
    }

    @GetMapping("/sort/descuento")
    public String sortByDescuento(Model model) {
        var prodConDescuento = productoService.getListOfProductos().stream().filter(p->p.getPorcentajeDescuento() > 0 ).toList();
        var productos = prodConDescuento.stream().sorted(Comparator.comparingDouble(Producto::getPorcentajeDescuento)).toList();
        model.addAttribute("productos_lista", productos);
        model.addAttribute("categorias_lista", categoriaService.getListOfCategorias());
        return "demo";
    }

    /**
     * Busqueda por Nombre
     * @param nombre
     * @param model
     * @return plantilla index con el producto en una lista para evitar discrepancias con directivas thymeleaf
     */
    @GetMapping("/findBy/nombre/{nombre}")
    public String filterByName(@PathVariable String nombre, Model model) {
        var producto = productoService.getListOfProductos().stream().filter(p->p.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
        model.addAttribute("productos_lista", producto);
        model.addAttribute("categorias_lista", categoriaService.getListOfCategorias());
        return "demo";
    }
}
