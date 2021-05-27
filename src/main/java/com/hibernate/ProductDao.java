package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDao {
    private final SessionFactory sessionFactory;
    private Session session;

    public ProductDao(){
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        session = null;

    }
//    Session session = null;

    public void saveOrUpdate(Product product) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product productNew = session.get(Product.class, product.getId());
        if (productNew != null){
            productNew.setTitle(product.getTitle());
            productNew.setPrice(product.getPrice());
        } else {
            session.save(product);
        }
        session.getTransaction().commit();
    }

    public Product productFindById(long id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        return product;
    }

    public void deleteProductFindById(long id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.delete(product);
        session.getTransaction().commit();
    }

    public List<Product> FindAll() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Product> productList = session.createQuery("from Product").getResultList();
        session.getTransaction().commit();
        return productList;
    }
}
