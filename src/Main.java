import java.util.*;

// 1. Inheritance(Kalıtım): Ürün sınıfından türetilmiş alt sınıflar
abstract class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void displayInfo(); // Polymorphism

    public double getPrice() {
        return price;
    }

    // Fiyat güncelleme
    public void setPrice(double price) {
        this.price = price;
    }
}

class BookProduct extends Product {
    public BookProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public void displayInfo() {
        System.out.println("Kitap: " + name + ", Fiyat: " + price + " TL");
    }
}

class StationeryProduct extends Product {
    public StationeryProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public void displayInfo() {
        System.out.println("Kırtasiye Ürünü: " + name + ", Fiyat: " + price + " TL");
    }
}

// 2. Interface: Stok işlemleri için arayüz
interface Stockable {
    void addToStock(Product product, int quantity);
    void removeFromStock(Product product, int quantity);
    int getStockQuantity(Product product);
}

// 3. Generic class/method: Stok yöneticisi sınıfı
class StockManager<T extends Product> implements Stockable {
    private Map<T, Integer> stock = new HashMap<>();

    @Override
    public void addToStock(Product product, int quantity) {
        stock.put((T) product, stock.getOrDefault(product, 0) + quantity);
    }

    @Override
    public void removeFromStock(Product product, int quantity) {
        if (stock.containsKey(product)) {
            int currentQuantity = stock.get(product);
            if (currentQuantity >= quantity) {
                stock.put((T) product, currentQuantity - quantity);
            } else {
                System.out.println("Yeterli stok yok!");
            }
        } else {
            System.out.println("Ürün stokta bulunmuyor!");
        }
    }

    @Override
    public int getStockQuantity(Product product) {
        return stock.getOrDefault(product, 0);
    }

    // 5. Generic collections (List ve Map kullanımı)
    public void displayStock() {
        stock.forEach((product, quantity) -> {
            product.displayInfo();
            System.out.println("Stok Miktarı: " + quantity);
        });
    }
}
