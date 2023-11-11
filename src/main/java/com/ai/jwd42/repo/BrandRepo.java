package com.ai.jwd42.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ai.jwd42.dto.Brand;
import com.mysql.cj.protocol.Resultset;

@Repository
public class BrandRepo extends BaseRepo {
//	public boolean addBrand(Brand brand) {
//		try {
//			Connection conn = getConnection();
//			PreparedStatement ps = conn
//					.prepareStatement("INSERT INTO brand name VALUES ?");
//			ps.setString(1, brand.getName());
//
//			ps.executeUpdate();
//			return true;
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		return false;
//	}

	public List<Brand> findAll() {
		try {
			Connection conn = getConnection();

			List<Brand> brand = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement("select * from brand;");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Brand brands = new Brand();
				brands.setId(rs.getInt(1));
				brands.setName(rs.getString(2));
				brand.add(brands);
			}
			return brand;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

	public int insert(Brand brand) {
		int result = 0;
		Connection con = getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into brand (name) values (?)");
			ps.setString(1, brand.getName());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return result;
	}

	public void update(Brand brand) {
		Connection con = getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("update brand set name = ? where id=?;");
			ps.setString(1, brand.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public Brand FindById(int id) {
		Connection con = getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select*from brand where id=?;");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Brand brand = new Brand();
				brand.setId(rs.getInt(1));
				brand.setName(rs.getString(2));

				return brand;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
