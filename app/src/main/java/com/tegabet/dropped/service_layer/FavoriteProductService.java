package com.tegabet.dropped.service_layer;

import com.tegabet.dropped.data_layer.Product;

import java.util.ArrayList;

/**
 * Created by sultankhan on 3/17/17.
 */
public class FavoriteProductService {

    ArrayList<Product> data;

    private static FavoriteProductService ourInstance = new FavoriteProductService();

    public static FavoriteProductService getInstance() {
        return ourInstance;
    }

    private FavoriteProductService() {
        data = new ArrayList<Product>();
    }

    public ArrayList<Product> getData(){
        return data;
    }

    public void addFavorite(Product product){
        data.add(product);
    }
}
