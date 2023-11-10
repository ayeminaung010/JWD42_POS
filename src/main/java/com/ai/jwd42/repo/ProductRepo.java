package com.ai.jwd42.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ai.jwd42.dto.Product;

@Repository
public class ProductRepo extends BaseRepo {
	public boolean addProduct(Product product) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO products (title, description, price, discount, brand_id, sub_category_id, thumbnail, images, stock)\r\n"
							+ "VALUES (?,?,?,?,?,?,?,?,?);\r\n" + "");
			ps.setString(1, product.getTitle());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setDouble(4, product.getDiscount());
			ps.setInt(5, product.getBrand_id());
			ps.setInt(6, product.getSub_category_id());
			ps.setString(7, product.getThumbnail());
			ps.setString(8, product.getImages());
			ps.setInt(9, product.getStock());

			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	public List<Product> findAll() {
		try {
			Connection conn = getConnection();

			List<Product> products = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement("select * from products;");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setTitle(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setDiscount(rs.getDouble(4));
				product.setBrand_id(rs.getInt(5));
				product.setSub_category_id(rs.getInt(6));
				product.setThumbnail(rs.getString(7));
				product.setImages(rs.getString(8));
				product.setStock(rs.getInt(9));

				products.add(product);
			}
			return products;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
