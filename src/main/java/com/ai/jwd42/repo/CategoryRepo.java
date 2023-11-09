package com.ai.jwd42.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ai.jwd42.dto.Category;

@Repository
public class CategoryRepo extends BaseRepo {
	public boolean addCategory(Category category) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO category (name) VALUES (?)");
			ps.setString(1, category.getName());

			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public List<Category> findAll() {
		try {
			Connection conn = getConnection();

			List<Category> categories = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement("select * from category;");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt(1));
				category.setName(rs.getString(2));
				categories.add(category);
			}
			return categories;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
