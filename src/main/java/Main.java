import com.jotech.models.Product;
import com.jotech.repositories.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //Create our repository
        ProductRepository productRepository = new ProductRepository(entityManager);

        Product product = new Product();
        product.setName("Soda");
        product.setDescription("Soda Description");
        Optional<Product> savedProduct = productRepository.save(product);
        System.out.println("Saved product "+savedProduct.get());


    }
}
