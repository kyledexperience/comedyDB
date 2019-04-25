package co.demos.states.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.demos.states.entity.User;

@Component
public class UsersDaoOld {

	public List<User> findAll() {
		try (Connection conn = getDBConnection()) {
			String query = "SELECT * FROM Users";
			// Step 3: create statement
			PreparedStatement st = conn.prepareStatement(query);

			// Step 4: retrieve results
			ResultSet rs = st.executeQuery();

			// Step 5: process results
			ArrayList<User> list = new ArrayList<>();
			while (rs.next()) {
				Long id = rs.getLong("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Integer stateId = rs.getInt("state_id");
				list.add(new User(id, firstName, lastName, stateId));
			}

			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<>(0);
		}
	}

	private Connection getDBConnection() throws ClassNotFoundException, SQLException {
		// prep for step # 2
		String url = "jdbc:mysql://localhost:3306/mydata?useSSL=false&serverTimezone=UTC";
		String userName = "root";
		String password = "javawins";

		// Step #1: Load and Register Driver
		Class.forName("com.mysql.jdbc.Driver");

		// Step #2: Create Connection
		Connection con = DriverManager.getConnection(url, userName, password);
		return con;
	}

}
