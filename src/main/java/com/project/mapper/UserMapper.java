package com.project.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.model.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User rowMapper(ResultSet rs) {
		User user = new User();
		try {
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setFirstname(rs.getString("firstname"));
			user.setLastname(rs.getString("lastname"));
			user.setEmail(rs.getString("email"));
			user.setPhoneNumber(rs.getString("phone"));
			user.setAddress(rs.getString("address"));
			user.setRole(rs.getString("role"));
			user.setDel(rs.getBoolean("del"));
			return user;
		} catch (SQLException e) {
			return null;
		}
	}

}
