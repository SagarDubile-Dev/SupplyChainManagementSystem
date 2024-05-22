// src/services/SupplyChainService.java
package services;

import dao.CustomerDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import dao.SupplierDAO;
import models.Customer;
import models.Order;
import models.Product;
import models.Supplier;
import java.util.List;

public class SupplyChainService {
    private final SupplierDAO supplierDAO = new SupplierDAO();
    private final ProductDAO productDAO = new ProductDAO();
    private final OrderDAO orderDAO = new OrderDAO();
    private final CustomerDAO customerDAO = new CustomerDAO();

    public void createNewSupplier(Supplier supplier) {
        supplierDAO.addSupplier(supplier);
    }

    public List<Supplier> viewAllSuppliers() {
        return supplierDAO.getAllSuppliers();
    }

    public void createNewProduct(Product product) {
        productDAO.addProduct(product);
    }

    public List<Product> viewAllProducts() {
        return productDAO.getAllProducts();
    }

    public void createNewOrder(Order order) {
        orderDAO.addOrder(order);
    }

    public List<Order> viewAllOrders() {
        return orderDAO.getAllOrders();
    }

    public void createNewCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    public List<Customer> viewAllCustomers() {
        return customerDAO.getAllCustomers();
    }
}
