package api.mercado.service;

import api.mercado.entity.Product;
import java.util.List;

public interface ProductService {

    Product create(Product product);

    List<Product> list();

    Product getById(Long id);

    Product update(Long id, Product product);

    void delete(Long id);
}