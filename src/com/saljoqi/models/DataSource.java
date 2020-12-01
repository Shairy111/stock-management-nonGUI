package com.saljoqi.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static final String DB_NAME = "stock.db";

    public static final String CONNECTION = "jdbc:sqlite:/home/shairy/IdeaProjects/Stock_management_system(NonGUI)/" + DB_NAME;

    //Brand Table and Column
    public static final String TABLE_BRANDS = "brands";
    public static final String COLUMN_BRAND_ID = "brand_id";
    public static final String COLUMN_BRAND_NAME = "brand_name";
    public static final String COLUMN_BRAND_ORIGIN = "brand_origin";

    //BRAND TABLE INDICES
    public static final int INDEX_BRAND_ID = 1;
    public static final int INDEX_BRAND_NAME = 2;
    public static final int INDEX_BRAND_ORIGIN = 3;



    //Products Table and column
    public static final String TABLE_PRODUCTS = "products";
    public static final String COLUMN_PRODUCT_ID = "product_id";
    public static final String COLUMN_PRODUCT_NAME = "product_name";
    public static final String COLUMN_PRODUCT_PRICE = "product_price";
    public static final String COLUMN_COUNT_IN_STOCK = "count_in_stock";
    public static final String COLUMN_PR_BRAND_ID = "product_brandID";
    public static final String COLUMN_PR_SUPPLIER_ID = "product_supplierID";

    //Product table indices
    public static final int INDEX_PRODUCT_ID = 1;
    public static final int INDEX_PRODUCT_NAME = 2;
    public static final int INDEX_PRODUCT_PRICE = 3;
    public static final int INDEX_COUNT_IN_STOCK = 4;
    public static final int INDEX_PR_BRAND_ID = 5;
    public static final int INDEX_PR_SUPPLIER_ID = 6;


    //Suppliers Table and Column
    public static final String TABLE_SUPPLIER = "suppliers";
    public static final String COLUMN_SUPPLIER_ID = "supplier_id";
    public static final String COLUMN_SUPPLIER_NAME = "supplier_name";
    public static final String COLUMN_SUPPLIER_ADDRESS = "supplier_address";

    //Supplier table indices
    public static final int INDEX_SUPPLIER_ID = 1;
    public static final int INDEX_SUPPLIER_NAME = 2;
    public static final int INDEX_SUPPLIER_ADDRESS = 3;


    private Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION);
            return true;
        } catch (SQLException e) {
            System.out.println("something went wrong" + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("some bad happened" + e.getMessage());

        }
    }

    public List<Products> queryProducts() {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM" + " " + TABLE_PRODUCTS);
            List<Products> product = new ArrayList<>();
            while (resultSet.next()) {
                Products products = new Products();
                products.setProduct_id(resultSet.getInt(COLUMN_PRODUCT_ID));
                products.setProduct_name(resultSet.getString(COLUMN_PRODUCT_NAME));
                products.setProduct_price(resultSet.getInt(COLUMN_PRODUCT_PRICE));
                products.setCount_in_stock(resultSet.getInt(COLUMN_COUNT_IN_STOCK));
                products.setProduct_brandID(resultSet.getInt(COLUMN_PR_BRAND_ID));
                products.setProduct_supplierID(resultSet.getInt(COLUMN_PR_SUPPLIER_ID));
                product.add(products);

            }
            return product;


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());

            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
