// src/Main.java
import models.Customer;
import models.Order;
import models.Product;
import models.Supplier;
import services.SupplyChainService;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SupplyChainService supplyChainService = new SupplyChainService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("------------------------------WELCOME TO SAGAR RAMESH DUBILE 23BCE7315 SUPPLY CHAIN MANAGEMENT SYSTEM------------------------------");
            System.out.println("1. Add Supplier");
            System.out.println("2. View All Suppliers");
            System.out.println("3. Add Product");
            System.out.println("4. View All Products");
            System.out.println("5. Create Order");
            System.out.println("6. View All Orders");
            System.out.println("7. Add Customer");
            System.out.println("8. View All Customers");
            System.out.println("9. Exit");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
            System.out.print("");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addSupplier();
                    break;
                case 2:
                    viewAllSuppliers();
                    break;
                case 3:
                    addProduct();
                    break;
                case 4:
                    viewAllProducts();
                    break;
                case 5:
                    createOrder();
                    break;
                case 6:
                    viewAllOrders();
                    break;
                case 7:
                    addCustomer();
                    break;
                case 8:
                    viewAllCustomers();
                    break;
                case 9:
                    System.out.println("Saving All Data............");
                    System.out.println("Data Saved Successfully............");
                    System.exit(0);
            }
        }
    }

    private static void addSupplier() {
        System.out.println(" ");
        System.out.println("------------------------------------------------------------------Add Supplier------------------------------------------------------------------");
        System.out.println(" ");
        System.out.print("Enter supplier name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact info: ");
        String contactInfo = scanner.nextLine();
        Supplier supplier = new Supplier();
        supplier.setName(name);
        supplier.setContactInfo(contactInfo);
        supplyChainService.createNewSupplier(supplier);
        System.out.println(" ");
        System.out.println("Supplier added successfully!!");
        System.out.println(" ");
    }

    private static void viewAllSuppliers() {
        List<Supplier> suppliers = supplyChainService.viewAllSuppliers();
        if (suppliers.isEmpty()) {
            System.out.println(" ");
            System.out.println("No suppliers found.");
            System.out.println(" ");
        } else {
            System.out.println("---------------------------------------------------------List Of All Suppliers---------------------------------------------------------");
            System.out.println(" ");
            System.out.println("Supplier Id\t\tName\t\tContact");
            for (Supplier supplier : suppliers) {
                System.out.println(supplier.getSupplierId() + "\t\t\t\t" + supplier.getName() + "\t\t" + supplier.getContactInfo());
            }
            System.out.println(" ");
        }
    }

    private static void addProduct() {
        System.out.println("------------------------------------------------------------------Add Products------------------------------------------------------------------");
        System.out.println(" ");
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter supplier ID: ");
        int supplierId = scanner.nextInt();
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setSupplierId(supplierId);
        supplyChainService.createNewProduct(product);
        System.out.println(" ");
        System.out.println("Product added successfully!");
        System.out.println(" ");
    }

    private static void viewAllProducts() {
        List<Product> products = supplyChainService.viewAllProducts();
        if (products.isEmpty()) {
            System.out.println(" ");
            System.out.println("No products found.");
            System.out.println(" ");
        } else {
            System.out.println("---------------------------------------------------------List Of All Products---------------------------------------------------------");
            System.out.println(" ");
            System.out.printf("%-13s %-20s %-20s %-10s %-10s%n", "Product ID", "Name", "Description", "Price", "Supplier ID");
            for (Product product : products) {
                System.out.printf("%-13d %-20s %-20s %-10.2f %-10d%n", product.getProductId(), product.getName(), product.getDescription(), product.getPrice(), product.getSupplierId());
            }
            System.out.println(" ");
        }
    }

    private static void createOrder() {
        System.out.println("-------------------------------------------------------------Create Orders-------------------------------------------------------------");
        System.out.println(" ");
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        System.out.print("Enter order status: ");
        scanner.nextLine(); // Consume newline
        String status = scanner.nextLine();
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setOrderDate(new Date());
        order.setStatus(status);
        supplyChainService.createNewOrder(order);
        System.out.println(" ");
        System.out.println("Order created successfully!");
        System.out.println(" ");
    }

    private static void viewAllOrders() {
        List<Order> orders = supplyChainService.viewAllOrders();
        if (orders.isEmpty()) {
            System.out.println(" ");
            System.out.println("No orders found.");
            System.out.println(" ");
        } else {
            System.out.println("---------------------------------------------------------List Of All Orders---------------------------------------------------------");
            System.out.println(" ");
            System.out.printf("%-10s %-20s %-20s %-10s%n", "Order ID", "Customer ID", "Order Date", "Status");
            for (Order order : orders) {
                System.out.printf("%-10d %-20s %-20s %-10s%n", order.getOrderId(), order.getCustomerId(), order.getOrderDate(), order.getStatus());
            }

            System.out.println(" ");
        }
    }

    private static void addCustomer() {
        System.out.println("------------------------------------------------------------------Add Customers------------------------------------------------------------------");
        System.out.println(" ");
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        customer.setEmail(email);
        supplyChainService.createNewCustomer(customer);
        System.out.println(" ");
        System.out.println("Customer added successfully!");
        System.out.println(" ");
    }

    private static void viewAllCustomers() {
        List<Customer> customers = supplyChainService.viewAllCustomers();
        if (customers.isEmpty()) {
            System.out.println(" ");
            System.out.println("No customers found.");
            System.out.println(" ");
        } else {
            System.out.println("---------------------------------------------------------List Of All Customers---------------------------------------------------------");
            System.out.printf("%-15s %-20s %-20s %-10s%n", "Customer ID", "Name", "Address", "Email");
            for (Customer customer : customers) {
                System.out.printf("%-15s %-20s %-20s %-10s%n", customer.getCustomerId(), customer.getName(), customer.getAddress(), customer.getEmail());
            }

            System.out.println(" ");
        }
    }
}
