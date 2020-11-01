package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCustomers();
        loadCustomers();
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("fruits");

        Category dried = new Category();
        dried.setName("dried");

        Category fresh = new Category();
        fresh.setName("fresh");

        Category exotic = new Category();
        exotic.setName("exotic");

        Category nuts = new Category();
        nuts.setName("nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Data loaded: " + categoryRepository.count());
    }

    public void loadCustomers() {
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstName("Indranil");
        customer1.setLastName("Sarkar");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setFirstName("Kakoli");
        customer2.setLastName("Sarkar");
        customerRepository.save(customer2);

        System.out.println("Customer Loaded: " + customerRepository.count());
    }
}
