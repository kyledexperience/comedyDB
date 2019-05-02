package co.demos.states.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.demos.states.entity.State;
import co.demos.states.entity.User;

@Repository
public class UsersDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<User> findAll() {
		return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(User.class));
	}

	public List<State> findAllStates() {
		return jdbcTemplate.query("SELECT * FROM users RIGHT JOIN states ON users.state_id=states.state_id",
				new BeanPropertyRowMapper<>(State.class));
	}

	public void create(User user) {

		String sql = "INSERT INTO Users (first_name, last_name, state_id) VALUES (?,?,?)";
		jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getStateId());

	}

	public void detete(Long id) {

		String sql = "DELETE FROM users WHERE id=?";
		jdbcTemplate.update(sql, id);

	}

}
