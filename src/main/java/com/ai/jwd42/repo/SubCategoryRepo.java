package com.ai.jwd42.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ai.jwd42.dto.SubCategory;

@Repository
public class SubCategoryRepo extends BaseRepo {
	public boolean addsubCategory(SubCategory subcategory) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO sub_category (name, category_id) VALUES (?,?);");
			ps.setString(1, subcategory.getName());
			ps.setInt(1, subcategory.getCategoryId());

			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public List<SubCategory> findAll() {
		try {
			Connection conn = getConnection();

			List<SubCategory> subcategories = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement("SELECT sc.*,c.name as category_name \r\n"
					+ "FROM category c\r\n" + "INNER JOIN sub_category sc ON c.id = sc.category_id;");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SubCategory subcategory = new SubCategory();
				subcategory.setId(rs.getInt(1));
				subcategory.setName(rs.getString(2));
				subcategory.setCategoryId(rs.getInt(3));
				subcategory.setCategoryName(rs.getString(4));
				subcategories.add(subcategory);
			}
			return subcategories;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
