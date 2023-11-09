package com.ai.jwd42.repo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.ai.jwd42.dto.PaymentType;

@Repository
public class PaymentTypeRepo extends BaseRepo {
	public boolean addPaymentType(PaymentType paymentType) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO payment_type (name) VALUES (?)");
			ps.setString(1, paymentType.getName());

			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public List<PaymentType> findAll() {
		try {
			Connection conn = getConnection();

			List<PaymentType> PaymentTypes = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement("select * from payment_type;");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PaymentType paymentType = new PaymentType();
				paymentType.setId(rs.getInt(1));
				paymentType.setName(rs.getString(2));
				PaymentTypes.add(paymentType);
			}
			return PaymentTypes;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
