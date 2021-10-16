package works.hop.dbdemo;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import works.hop.dbdemo.entity.Customer;
import works.hop.dbdemo.entity.Product;
import works.hop.dbdemo.entity.Supplier;
import works.hop.dbdemo.repository.CustomersRepository;
import works.hop.dbdemo.repository.ProductsRepository;
import works.hop.dbdemo.repository.SuppliersRepository;

@SpringBootTest
@AutoConfigureEmbeddedDatabase
@ActiveProfiles("test")
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
