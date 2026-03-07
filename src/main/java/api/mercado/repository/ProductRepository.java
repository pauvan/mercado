package api.mercado.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import api.mercado.entity.Product; 


public interface ProductRepository extends JpaRepository<Product, Long> {

}

