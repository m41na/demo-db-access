package works.hop.db.access;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import works.hop.db.access.entity.Customer;
import works.hop.db.access.entity.Product;
import works.hop.db.access.entity.Supplier;
import works.hop.db.access.repository.CustomersRepository;
import works.hop.db.access.repository.ProductsRepository;
import works.hop.db.access.repository.SuppliersRepository;

@SpringBootTest
class DemoDbAccessApplicationTests {

    @Autowired
    CustomersRepository customersRepository;
    @Autowired
    SuppliersRepository suppliersRepository;
    @Autowired
    ProductsRepository productsRepository;

    @Test
    void contextLoads() {
        Iterable<Customer> customers = customersRepository.findAll();
        customers.forEach(System.out::println);

        Iterable<Supplier> suppliers = suppliersRepository.findAll();
        suppliers.forEach(System.out::println);

        Iterable<Product> products = productsRepository.findAll();
        products.forEach(System.out::println);
    }
}
