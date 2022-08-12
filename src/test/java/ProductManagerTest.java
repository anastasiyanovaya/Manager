import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    Product product1 = new Product(20, "Harry", 2000);
    Product product2 = new Product(21, "Azbuka", 1500);
    Book book1 = new Book(22, "Harry", 1000, "Rouling");
    Smartphone smartphone1 = new Smartphone(23, "Xiaomi", 5000, "Xiaomi Corporation");
    Smartphone smartphone2 = new Smartphone(24, "Iphone", 10000, "Apple");

    @Test
    public void shouldFind() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(product1);
        manager.add(product2);
        Product[] actual = manager.searchBy("Ha");
        Product[] expected = {product1};
        assertArrayEquals(expected, actual);

    }

}
