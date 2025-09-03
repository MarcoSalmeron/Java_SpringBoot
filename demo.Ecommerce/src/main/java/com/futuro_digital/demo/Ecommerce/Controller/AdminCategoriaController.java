package com.futuro_digital.demo.Ecommerce.Controller;

import com.futuro_digital.demo.Ecommerce.DTO.CategoriaDTO;
import com.futuro_digital.demo.Ecommerce.Entity.Categoria;
import com.futuro_digital.demo.Ecommerce.Service.CategoriaService;
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
@RequestMapping(path = "/api/admin/categorias")
public class AdminCategoriaController {

    @Autowired
    private final CategoriaService categoriaService;

    // Mostrar todas las vcategorias y dto vacio para el modal
    @GetMapping("/all")
    public String mostrarCategorias(Model model) {
        log.info("Ejecutando Endpoint /admin/categorias/all  !");
        var categorias = categoriaService.getListOfCategorias();
        model.addAttribute("categorias_lista", categorias);
        model.addAttribute("categoriaDTO", new CategoriaDTO(null, "", "", ""));
        return "categorias";
    }

    /** Guardar nueva categoría via modal */
    @PostMapping("/save")
    public String guardarCategoria(
            @Valid @ModelAttribute("categoriaDTO") CategoriaDTO categoriaDTO,
            Errors errores
    ) {
        log.info("Ejecutando Endpoint /admin/categorias/save !");

        if (errores.hasErrors()) {
            log.info("Error al Guardar Categoria con ID : "+categoriaDTO.id());
            return "redirect:/api/admin/categorias/all";
        }
        log.info("Guardado Exitoso!");
        categoriaService.saveCategoria(categoriaDTO);
        return "redirect:/api/admin/categorias/all";
    }

    // Editar Categoria
    /** Procesar el formulario de edición */
    @PostMapping("/edit/{id}")
    public String procesarEdicionProducto(
            @PathVariable Long id,
            @Valid @ModelAttribute("categoriaDTO") CategoriaDTO categoriaDTO,
            BindingResult bindingResult,
            Model model) {

        log.info("Ejecutando Endpoint POST /admin/categorias/edit/{id} !");

        if (bindingResult.hasErrors()) {
            log.error("Errores de validación en categoria ID: " + id);
            return "redirect:/api/admin/categorias/all";
        }

        try {
            categoriaService.editCategoria(categoriaDTO,id);
            log.info("Categoria editada exitosamente ID: " + id);
        } catch (IllegalStateException e) {
            log.error("Error al editar categoria ID: " + id + " - " + e.getMessage());
            bindingResult.rejectValue("id", "error.producto", e.getMessage());
            return "categorias";
        }

        return "redirect:/api/admin/categorias/all";
    }


    // Eliminar Categoria
    @GetMapping("/delete/{id}")
    public String deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return "redirect:/api/admin/categorias/all";
    }

    /**
     *
     * Filtrado y
     * Ordenamiento de
     * Categorias
     *
     */

    @GetMapping("/sort/categoria")
    public String sortByCategoria(Model model) {
        var categorias = categoriaService.getListOfCategorias().stream().sorted(Comparator.comparing(Categoria::getCategoria)).toList();
        model.addAttribute("categorias_lista", categorias);
        model.addAttribute("categoriaDTO", new CategoriaDTO(null, "", "", ""));
        return "categorias";
    }

    @GetMapping("/sort/cantidad")
    public String sortByCantidadProductos(Model model) {
        var categorias = categoriaService.getListOfCategorias().stream().sorted(Comparator.comparing(c->c.getProductos().size())).toList();
        model.addAttribute("categorias_lista", categorias);
        model.addAttribute("categoriaDTO", new CategoriaDTO(null, "", "", ""));
        return "categorias";
    }

    @GetMapping("/filter/categoria/{categoria}")
    public String filterByCategoria(@PathVariable String categoria, Model model) {
        var categorias = categoriaService.getListOfCategorias().stream().filter(c->c.getCategoria().equalsIgnoreCase(categoria)).toList();
        model.addAttribute("categorias_lista", categorias);
        model.addAttribute("categoriaDTO", new CategoriaDTO(null, "", "", ""));
        return "categorias";
    }

    @GetMapping("/filter/cantidad/{cantidad}")
    public String filterByCantidad(@PathVariable Integer cantidad, Model model) {
        var categorias = categoriaService.getListOfCategorias().stream().filter(c->c.getProductos().size() <= cantidad).toList();
        model.addAttribute("categorias_lista", categorias);
        model.addAttribute("categoriaDTO", new CategoriaDTO(null, "", "", ""));
        return "categorias";
    }



}









