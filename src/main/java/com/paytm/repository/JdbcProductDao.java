package com.paytm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import com.paytm.domain.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * Created by harshitgupta on 4/4/17.
 */
@Repository
public class JdbcProductDao implements ProductDao {
    private JdbcTemplate jdbcTemplate;
    public JdbcProductDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Product> getProductList() {
        String SQL = "select * from products";
        List<Product> products = jdbcTemplate.query(SQL, new BeanPropertyRowMapper(Product.class));
        return products;
    }

    public void saveProduct(Product product) {
        Double price = product.getPrice();
        String description = product.getDescription();
        String SQL = "insert into products (price, description) values (?, ?)";
        jdbcTemplate.update( SQL, price, description);
        System.out.println("Created Record Price = " + price + " Description = " + description);
        return;
    }
}
