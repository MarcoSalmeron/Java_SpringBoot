package com.futuro_digital.demo.Ecommerce.Controller;

import com.futuro_digital.demo.Ecommerce.DTO.CategoriaDTO;
import com.futuro_digital.demo.Ecommerce.DTO.ProductoDTO;
import com.futuro_digital.demo.Ecommerce.Entity.Producto;
import com.futuro_digital.demo.Ecommerce.Service.CategoriaService;
import com.futuro_digital.demo.Ecommerce.Service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/api/admin/productos")
public class AdminProductosController {

    @Autowired
    private final ProductoService productoService;

    @Autowired
    private final CategoriaService categoriaService;

    /** Mostrar panel con productos y DTO vacío para modal */
    @GetMapping("/all")
    public String allProductos(Model model) {
        log.info("Ejecutando Endpoint /admin/productos/all !");

        // DTO vacío para creación/edición de producto
        CategoriaDTO emptyCat = new CategoriaDTO(null, "", "", "");
        ProductoDTO emptyProd = new ProductoDTO(null, "", "", "", 0, 0.0, 0.0, "", emptyCat);

        model.addAttribute("productos_lista", productoService.getListOfProductos());
        model.addAttribute("categorias_lista", categoriaService.getListOfCategorias());
        model.addAttribute("productoDTO", emptyProd);
        return "admin";
    }

    /** Guardar producto nuevo via modal */
    @PostMapping("/save")
    public String guardarProducto(
            @Valid @ModelAttribute("productoDTO") ProductoDTO productoDTO,
            Errors errores,
            Model model
    ) {
        log.info("Ejecutando Endpoint /admin/productos/save !");

        if (errores.hasErrors()) {
            return "redirect:/api/admin/productos/all";
        }

        productoService.saveProducto(productoDTO);
        return "redirect:/api/admin/productos/all";
    }



    /** Procesar el formulario de edición */
    @PostMapping("/edit/{id}")
    public String procesarEdicionProducto(
            @PathVariable Long id,
            @Valid @ModelAttribute("productoDTO") ProductoDTO productoDTO,
            BindingResult bindingResult,
            Model model) {

        log.info("Ejecutando Endpoint POST /admin/productos/edit/{id} !");

        if (bindingResult.hasErrors()) {
            log.error("Errores de validación en producto ID: " + id);
            model.addAttribute("categorias_lista", categoriaService.getListOfCategorias());
            return "admin";
        }

        try {
            productoService.editProducto(productoDTO, id);
            log.info("Producto editado exitosamente ID: " + id);
        } catch (IllegalStateException e) {
            log.error("Error al editar producto ID: " + id + " - " + e.getMessage());
            bindingResult.rejectValue("id", "error.producto", e.getMessage());
            model.addAttribute("categorias_lista", categoriaService.getListOfCategorias());
            return "admin";
        }

        return "redirect:/api/admin/productos/all";
    }


    // Eliminar producto
    @GetMapping("/delete/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        log.info("Ejecutando Endpoint /admin/productos/delete !");
        productoService.deleteProducto(id);
        return "redirect:/api/admin/productos/all";
    }

    /**
     *
     * Filtrado y
     * Ordenamiento del
     * Producto
     *
     */

    @GetMapping("/sort/marca")
    public String sortProductosByMarca(Model model) {

        var productos = productoService.getListOfProductos().stream().sorted(Comparator.comparing(Producto::getMarca)).toList();
        var categorias = categoriaService.getListOfCategorias();

        // DTO vacío para creación/edición de producto
        CategoriaDTO emptyCat = new CategoriaDTO(null, "", "", "");
        ProductoDTO emptyProd = new ProductoDTO(null, "", "", "", 0, 0.0, 0.0, "", emptyCat);
        model.addAttribute("productos_lista",productos);
        model.addAttribute("categorias_lista", categorias);
        model.addAttribute("productoDTO", emptyProd);
        return "admin";
    }

    @GetMapping("/sort/precio")
    public String sortProductosByPrecio(Model model) {
        var productos = productoService.getListOfProductos().stream().sorted(Comparator.comparing(Producto::getPrecio)).toList();
        var categorias = categoriaService.getListOfCategorias();
        // DTO vacío para creación/edición de producto
        CategoriaDTO emptyCat = new CategoriaDTO(null, "", "", "");
        ProductoDTO emptyProd = new ProductoDTO(null, "", "", "", 0, 0.0, 0.0, "", emptyCat);
        model.addAttribute("productos_lista",productos);
        model.addAttribute("categorias_lista", categorias);
        model.addAttribute("productoDTO", emptyProd);
        return "admin";
    }

    @GetMapping("/sort/categoria")
    public String sortBycategoria(Model model) {
        var productos = productoService.getListOfProductos().stream().sorted(Comparator.comparing(p->p.getCategoria().getCategoria())).toList();
        var categorias = categoriaService.getListOfCategorias();
        // DTO vacío para creación/edición de producto
        CategoriaDTO emptyCat = new CategoriaDTO(null, "", "", "");
        ProductoDTO emptyProd = new ProductoDTO(null, "", "", "", 0, 0.0, 0.0, "", emptyCat);
        model.addAttribute("productos_lista",productos);
        model.addAttribute("categorias_lista", categorias);
        model.addAttribute("productoDTO", emptyProd);
        return "admin";
    }

    @GetMapping("/filter/categoria/{categoria}")
    public String filterByCategoria(@PathVariable String categoria, Model model) {
        var productos = productoService.getListOfProductos().stream().filter(p->p.getCategoria().getCategoria().equalsIgnoreCase(categoria)).toList();
        var categorias = categoriaService.getListOfCategorias();
        // DTO vacío para creación/edición de producto
        CategoriaDTO emptyCat = new CategoriaDTO(null, "", "", "");
        ProductoDTO emptyProd = new ProductoDTO(null, "", "", "", 0, 0.0, 0.0, "", emptyCat);
        model.addAttribute("productos_lista",productos);
        model.addAttribute("categorias_lista", categorias);
        model.addAttribute("productoDTO", emptyProd);
        return "admin";
    }

    @GetMapping("/filter/precio/{precio}")
    public String filterByPrecio(@PathVariable Double precio, Model model) {
        var productos = productoService.getListOfProductos().stream().filter(p->Math.round(p.getPrecio()) <= precio).toList();
        var categorias = categoriaService.getListOfCategorias();
        // DTO vacío para creación/edición de producto
        CategoriaDTO emptyCat = new CategoriaDTO(null, "", "", "");
        ProductoDTO emptyProd = new ProductoDTO(null, "", "", "", 0, 0.0, 0.0, "", emptyCat);
        model.addAttribute("productos_lista",productos);
        model.addAttribute("categorias_lista", categorias);
        model.addAttribute("productoDTO", emptyProd);
        return "admin";
    }

    @GetMapping("/filter/marca/{marca}")
    public String filterByMarca(@PathVariable String marca, Model model) {
        var productos = productoService.getListOfProductos().stream().filter(p->p.getMarca().equalsIgnoreCase(marca)).toList();
        var categorias = categoriaService.getListOfCategorias();
        // DTO vacío para creación/edición de producto
        CategoriaDTO emptyCat = new CategoriaDTO(null, "", "", "");
        ProductoDTO emptyProd = new ProductoDTO(null, "", "", "", 0, 0.0, 0.0, "", emptyCat);
        model.addAttribute("productos_lista",productos);
        model.addAttribute("categorias_lista", categorias);
        model.addAttribute("productoDTO", emptyProd);
        return "admin";
    }

}