
public class ProductManager {
    private Product[] products = new Product[0];
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product products : repository.findAll()) {
            if (matches(products, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];

                }
                tmp[tmp.length - 1] = products;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product products, String text) {
        if (products.getName().contains(text)) {
            return true;
        } else {
            return false;
        }


    }
}


