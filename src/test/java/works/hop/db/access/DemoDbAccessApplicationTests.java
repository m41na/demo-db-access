package works.hop.db.access;

import java.util.List;

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
		customers.forEach(cus -> System.out.println(cus));	
		
		Iterable<Supplier> suppliers = suppliersRepository.findAll();
		suppliers.forEach(sup -> System.out.println(sup));	
		
		Iterable<Product> products = productsRepository.findAll();
		products.forEach(prd -> System.out.println(prd));	
	}
}
