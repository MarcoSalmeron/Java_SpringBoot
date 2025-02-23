package com.Tirando.Codigo.CRUD.Controllers;

import com.Tirando.Codigo.CRUD.Models.Product;
import com.Tirando.Codigo.CRUD.Services.ServProduct_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controlar peticiones http//
@RestController
@RequestMapping(path = "/api/products")
public class ProductController {

    @Autowired
    private ServProduct_Interface servProduct;

    //Mostrar//
    @RequestMapping(path = "/All", method = RequestMethod.GET)
    public List<Product> All(){
        return servProduct.getProducts();
    }

    //Buscar//
    @RequestMapping(path = "/Find/{ID}", method = RequestMethod.POST)
    public Product Find(@PathVariable Long ID){
        return servProduct.findProduct(ID);
    }

    //Guardar//
    @RequestMapping(path = "/Save", method = RequestMethod.PUT)
    public Product Save(@RequestBody Product product){
        return  servProduct.saveProduct(product);
    }

    //Borrar//
    @RequestMapping(path = "/Delete/{ID}", method = RequestMethod.DELETE)
    public String Delete(@PathVariable Long ID){
        servProduct.deleteProduct(ID);
        return "Producto Eliminado";
    }

    //Editar//
    @RequestMapping(path = "/Edit", method = RequestMethod.PUT)
    public Product Edit(@RequestBody Product product){
        return servProduct.editProduct(product);
    }
}
