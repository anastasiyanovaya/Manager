import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    Book book1 = new Book(22, "Harry", 1000, "Rouling");
    Book book2 = new Book(25,"Hamburg", 2000,"Advgd");
    Smartphone smartphone1 = new Smartphone(23, "Xiaomi", 5000, "Xiaomi Corporation");
    Smartphone smartphone2 = new Smartphone(24, "Iphone", 10000, "Apple");

    @Test
    public void matchesTestTrue() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(smartphone2);
        boolean actual = manager.matches(book1, "Ha");
        boolean expected = true;
    }

    @Test
    public void matchesTestFalse() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(smartphone2);
        boolean actual = manager.matches(smartphone1, "Ha");
        boolean expected = false;
    }
    @Test
    public void saveTest() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(smartphone2);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, smartphone1, smartphone2};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void removeTest() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.removeById(24);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, smartphone1};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFind2ElementsTest() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(book2);
        Product[] actual = manager.searchBy("Ha");
        Product[] expected = {book1, book2};
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldFind1ElementsTest() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(book2);
        Product[] actual = manager.searchBy("o");
        Product[] expected = {smartphone1,smartphone2};
        Assertions.assertArrayEquals(expected, actual);

    }

}
