import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test

    public void RemoveProduct() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Печенье", 22);
        Product product2 = new Product(2, "Молоко", 120);
        Product product3 = new Product(3, "Хлеб", 89);

        repo.add(product1);
        repo.add(product3);
        repo.add(product2);
        repo.remove(1);

        Product[] actual = repo.findAll();
        Product[] expected = {product3, product2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void RemoveNonexistentProduct() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Печенье", 22);
        Product product2 = new Product(2, "Молоко", 120);
        Product product3 = new Product(3, "Хлеб", 89);

        repo.add(product1);
        repo.add(product3);
        repo.add(product2);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(244));

    }

    @Test

    public void AddProduct() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Печенье", 22);
        Product product2 = new Product(2, "Молоко", 120);
        Product product3 = new Product(3, "Хлеб", 89);

        repo.add(product1);
        repo.add(product3);
        repo.add(product2);


        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3, product2};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test

    public void AlreadyExistsProducts() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Печенье", 22);
        Product product2 = new Product(2, "Молоко", 120);
        Product product3 = new Product(3, "Хлеб", 89);

        repo.add(product1);
        repo.add(product3);
        repo.add(product2);

        Assertions.assertThrows(AlreadyExistsException.class, () -> repo.add(product1));

    }


}