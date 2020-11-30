package com.saljoqi;


import com.saljoqi.models.DataSource;
import com.saljoqi.models.Products;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            System.out.println("can't open datasource");
        }


        List<Products> product = dataSource.queryProducts();
        if(product == null){
            System.out.println("no products are found");
            return;
        }
        for (Products products: product) {
            System.out.println("product id = " + products.getProduct_id() + " "+ "product name = "+  products.getProduct_name() + "product price = " + products.getProduct_price() + "count in stock = " + products.getCount_in_stock() + "product brand id = " +products.getProduct_brandID() + "product supplier id = " +  products.getProduct_supplierID());
        }

        dataSource.close();

    }
}
