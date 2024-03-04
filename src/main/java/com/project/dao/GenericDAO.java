package com.project.dao;

import java.util.List;

import com.project.mapper.RowMapper;

public interface GenericDAO<T> {
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object...parameters);
	public int save(String sql, Object...parameters);
	public void update(String sql, Object...parameters);
}	