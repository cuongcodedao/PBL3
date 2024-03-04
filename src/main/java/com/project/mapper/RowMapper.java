package com.project.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {
	T rowMapper(ResultSet rs);
}
