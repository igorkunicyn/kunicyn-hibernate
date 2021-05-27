package com.hibernate;

public class MainClass {
    public static void main(String[] args) {

        ProductDao productDao = new ProductDao();
        Product product1 = productDao.productFindById(1L);
        product1.setTitle("milk");
        product1.setPrice(68);
        productDao.saveOrUpdate(product1);
        System.out.println(productDao.productFindById(1l));

//        Product product = new Product("meat", 450);
//        productDao.saveOrUpdate(product);
//        System.out.println(productDao.productFindById(3L));
//        productDao.deleteProductFindById(3l);
//        System.out.println(productDao.FindAll());
    }
}
