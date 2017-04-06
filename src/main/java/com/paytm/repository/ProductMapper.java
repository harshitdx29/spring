package com.paytm.repository;

import com.paytm.domain.Product;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by harshitgupta on 5/4/17.
 */
public class ProductMapper implements RowMapper {
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setDescription(rs.getString("description"));
        product.setId(rs.getInt("id"));
        product.setPrice(rs.getDouble("price"));
        return product;
    }

    public int[] getRowsForPaths(TreePath[] path){
        int a[]={1,2,3};
        return a;
    }

}
