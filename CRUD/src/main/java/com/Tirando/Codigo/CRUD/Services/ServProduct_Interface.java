package com.Tirando.Codigo.CRUD.Services;

import com.Tirando.Codigo.CRUD.Models.Product;

import java.util.List;

//Interfaz a Implementar Metodos//
public interface ServProduct_Interface {

    //Mostrar//
    public List<Product> getProducts();

    //Buscar//
    public Product findProduct(Long ID);

    //Guardar//
    public Product saveProduct(Product product);

    //Eliminar//
    public void deleteProduct(Long ID);

    //Editar//
    public Product editProduct(Product product);


}
