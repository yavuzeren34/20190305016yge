import java.util.Scanner;

public class StockControlSystem {
    public static void main(String[] args) {

        Product book = new BookProduct("Kitap", 100);
        Product pen = new StationeryProduct("Kalem", 10);
        Product eraser = new StationeryProduct("Silgi", 8);

        StockManager<Product> manager = new StockManager<>();

        manager.addToStock(book, 20);
        manager.addToStock(pen, 100);
        manager.addToStock(eraser, 50);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Stok Yönetim Sistemi ---");
            System.out.println("1. Stok Durumunu Görüntüle");
            System.out.println("2. Ürün Ekle");
            System.out.println("3. Ürün Çıkar");
            System.out.println("4. Ürün Fiyatını Değiştir");
            System.out.println("5. Çıkış");
            System.out.print("Seçiminizi yapın (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // 6. Lambda functions: forEach ile stok gösterimi
                    manager.displayStock();
                    break;

                case 2:
                    // Ürün ekleme
                    System.out.print("Eklemek istediğiniz ürünün adını girin (Kitap / Kalem / Silgi): ");
                    scanner.nextLine();  // Scanner temizleme
                    String addProductName = scanner.nextLine();
                    System.out.print("Eklemek istediğiniz miktarı girin: ");
                    int addQuantity = scanner.nextInt();

                    switch (addProductName.toLowerCase()) {
                        case "kitap":
                            manager.addToStock(book, addQuantity);
                            break;
                        case "kalem":
                            manager.addToStock(pen, addQuantity);
                            break;
                        case "silgi":
                            manager.addToStock(eraser, addQuantity);
                            break;
                        default:
                            System.out.println("Geçersiz ürün adı!");
                            break;
                    }
                    break;

                case 3:
                    // Ürün çıkarma
                    System.out.print("Çıkarmak istediğiniz ürünün adını girin (Kitap / Kalem / Silgi): ");
                    scanner.nextLine();  // Scanner temizleme
                    String removeProductName = scanner.nextLine();
                    System.out.print("Çıkarmak istediğiniz miktarı girin: ");
                    int removeQuantity = scanner.nextInt();

                    switch (removeProductName.toLowerCase()) {
                        case "kitap":
                            manager.removeFromStock(book, removeQuantity);
                            break;
                        case "kalem":
                            manager.removeFromStock(pen, removeQuantity);
                            break;
                        case "silgi":
                            manager.removeFromStock(eraser, removeQuantity);
                            break;
                        default:
                            System.out.println("Geçersiz ürün adı!");
                            break;
                    }
                    break;

                case 4:
                    // Fiyat değiştirme
                    System.out.print("Fiyatını değiştirmek istediğiniz ürünün adını girin (Kitap / Kalem / Silgi): ");
                    scanner.nextLine();  // Scanner temizleme
                    String updateProductName = scanner.nextLine();
                    System.out.print("Yeni fiyatı girin: ");
                    double newPrice = scanner.nextDouble();

                    switch (updateProductName.toLowerCase()) {
                        case "kitap":
                            book.setPrice(newPrice);
                            System.out.println("Kitap fiyatı güncellendi: " + newPrice + " TL");
                            break;
                        case "kalem":
                            pen.setPrice(newPrice);
                            System.out.println("Kalem fiyatı güncellendi: " + newPrice + " TL");
                            break;
                        case "silgi":
                            eraser.setPrice(newPrice);
                            System.out.println("Silgi fiyatı güncellendi: " + newPrice + " TL");
                            break;
                        default:
                            System.out.println("Geçersiz ürün adı!");
                            break;
                    }
                    break;

                case 5:
                    // Çıkış
                    running = false;
                    System.out.println("Çıkılıyor...");
                    break;

                default:
                    System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
                    break;
            }
        }

        scanner.close();
    }
}
