package com.tegabet.dropped.service_layer;

import com.tegabet.dropped.data_layer.Product;

import java.util.ArrayList;

/**
 * Created by sultankhan on 3/17/17.
 */
public class ProductService {

    ArrayList<Product> data;

    private static ProductService ourInstance = new ProductService();

    public static ProductService getInstance() {
        return ourInstance;
    }

    private ProductService() {
        data = new ArrayList<Product>();
        data.add(new Product("Item 1", 0.2f, 12.05, 50));
        data.add(new Product("Item 2", 0.7f, 20.00, 40));
        data.add(new Product("Item 3", 0.6f, 32.05, 20));
        data.add(new Product("Item 4", 0.3f, 70.00, 40));
        data.add(new Product("Item 5", 0.2f, 42.05, 80));
        data.add(new Product("Item 6", 0.9f, 80.00, 90));
    }

    public ArrayList<Product> getData(){
        return data;
    }
}
