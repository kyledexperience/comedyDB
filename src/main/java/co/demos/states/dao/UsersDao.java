package co.demos.states.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.demos.states.entity.User;

@Repository
public class UsersDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<User> findAll() {

		return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(User.class));
	}

}
