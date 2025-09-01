package com.futuro_digital.demo.Ecommerce.Controller;

import com.futuro_digital.demo.Ecommerce.DTO.CategoriaDTO;
import com.futuro_digital.demo.Ecommerce.DTO.ProductoDTO;
import com.futuro_digital.demo.Ecommerce.Entity.Producto;
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

import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/api/admin")
public class AdminController {

    @Autowired
    private final ProductoService productoService;

    /** Mostrar panel con productos, categorías y DTOs vacíos para los modales */
    @GetMapping("/index")
    public String allProductos(Model model) {
        log.info("Ejecutando Endpoint /index !");

        // DTO vacío para creación/edición de producto
        CategoriaDTO emptyCat = new CategoriaDTO(null, "", "", "");
        ProductoDTO emptyProd = new ProductoDTO(null, "", "", "", 0, 0.0, 0.0, "", emptyCat);

        model.addAttribute("productos_lista", productoService.getListOfProductos());
        model.addAttribute("categorias_lista", productoService.getListOfCategorias());
        model.addAttribute("productoDTO", emptyProd);
        model.addAttribute("categoriaDTO", new CategoriaDTO(null, "", "", ""));

        return "admin";
    }

    /** Guardar producto nuevo via modal */
    @PostMapping("/save")
    public String guardarProducto(
            @Valid @ModelAttribute("productoDTO") ProductoDTO productoDTO,
            Errors errores,
            Model model
    ) {
        log.info("Ejecutando Endpoint /save !");

        if (errores.hasErrors()) {
            return "redirect:/api/admin/index";
        }

        productoService.saveProducto(productoDTO);
        return "redirect:/api/admin/index";
    }


    /** Guardar nueva categoría via modal */
    @PostMapping("/category/save")
    public String guardarCategoria(
            @Valid @ModelAttribute("categoriaDTO") CategoriaDTO categoriaDTO,
            Errors errores,
            Model model
    ) {
        log.info("Ejecutando Endpoint /category/save !");

        if (errores.hasErrors()) {
            log.info("Error al Guardar Categoria con ID : "+categoriaDTO.id());
            return "redirect:/api/admin/index";
        }
        log.info("Guardado Exitoso!");
        productoService.saveCategoria(categoriaDTO);
        return "redirect:/api/admin/index";
    }


    /** Recibir DTO para llenar el modal de edición */
    @GetMapping("/edit/{id}")
    public String editarProducto(
            @PathVariable Long id,
            Model model) {

        log.info("Ejecutando Endpoint /edit/{id} !");
        Optional<Producto> productoOpt = Optional.ofNullable(productoService.findProductoById(id));

        if (productoOpt.isEmpty()) {
            log.error("Producto no encontrado en endpoint /api/admin/edit/{id} ID -> " + id);
            return "redirect:/api/admin/index";
        }

        var prod = productoOpt.get();
        var cat = prod.getCategoria();

        // Mapear Entity → DTO
        CategoriaDTO catDTO = new CategoriaDTO(
                cat.getId(),
                cat.getCategoria(),
                cat.getDescripcion(),
                cat.getUrl_imagen()
        );

        ProductoDTO productoDTO = new ProductoDTO(
                prod.getId(),
                prod.getNombre(),
                prod.getMarca(),
                prod.getDescripcion(),
                prod.getCantidad(),
                prod.getPrecio(),
                prod.getPorcentajeDescuento(),
                prod.getUrl_imagen(),
                catDTO
        );

        model.addAttribute("productoDTO", productoDTO);
        model.addAttribute("categorias_lista", productoService.getListOfCategorias());

        return "admin"; // Esto mostrará la página con el modal precargado
    }

    /** Procesar el formulario de edición */
    @PostMapping("/edit/{id}")
    public String procesarEdicionProducto(
            @PathVariable Long id,
            @Valid @ModelAttribute("productoDTO") ProductoDTO productoDTO,
            BindingResult bindingResult,
            Model model) {

        log.info("Ejecutando Endpoint POST /edit/{id} !");

        if (bindingResult.hasErrors()) {
            log.error("Errores de validación en producto ID: " + id);
            model.addAttribute("categorias_lista", productoService.getListOfCategorias());
            return "admin";
        }

        try {
            productoService.editProducto(productoDTO, id);
            log.info("Producto editado exitosamente ID: " + id);
        } catch (IllegalStateException e) {
            log.error("Error al editar producto ID: " + id + " - " + e.getMessage());
            bindingResult.rejectValue("id", "error.producto", e.getMessage());
            model.addAttribute("categorias_lista", productoService.getListOfCategorias());
            return "admin";
        }

        return "redirect:/api/admin/index";
    }


    // Eliminar producto
    @GetMapping("/delete/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        log.info("Ejecutando Endpoint /delete !");
        productoService.deleteProducto(id);
        return "redirect:/api/admin/index";
    }

    // Login
    @GetMapping("/login")
    public String login() {
        log.info("Ejecutando Endpoint /login !");
        return "login";
    }
}