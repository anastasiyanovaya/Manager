public class Main {

    public static void main(String[] args) {
        Product product1 = new Product( 20, "Harry", 2000);
        Product product2 = new Product( 21, "Azbuka", 1500);
        Book book1 = new Book(22,"Harry", 1000,"Rouling");
        Smartphone smartphone1 = new Smartphone(23,"Xiaomi", 5000,"Xiaomi Corporation");
        Smartphone smartphone2 = new Smartphone(24,"Iphone", 10000,"Apple");

        ProductRepository repository = new ProductRepository();
        repository.save(book1);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(product1);
        repository.save(product2);

        repository.removeById(20);
        repository.findAll();


        ProductManager manager = new ProductManager(new ProductRepository());
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.searchBy("Xi");
        manager.matches(product1,"Harry");


    }
}
