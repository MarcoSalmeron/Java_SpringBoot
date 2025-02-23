package com.Tirando.Codigo.CRUD.Services;

import com.Tirando.Codigo.CRUD.Models.Product;
import com.Tirando.Codigo.CRUD.Repositories.RepoProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Servicio con CRUD//
@Service
public class ServProduct implements ServProduct_Interface{

    //Inyectar Dependencias//
    @Autowired
    private RepoProduct repoProduct;


    @Override
    public List<Product> getProducts() {
        return repoProduct.findAll();
    }

    @Override
    public Product findProduct(Long ID) {
        return repoProduct.findById(ID).orElseThrow(() -> new NullPointerException("Error, no existe Producto con ID: " + ID));
    }

    @Override
    public Product saveProduct(Product product) {
        return repoProduct.save(product);
    }

    @Override
    public void deleteProduct(Long ID) {
        repoProduct.deleteById(ID);
    }

    @Override
    public Product editProduct(Product product) {
        return this.saveProduct(product);
    }
}
