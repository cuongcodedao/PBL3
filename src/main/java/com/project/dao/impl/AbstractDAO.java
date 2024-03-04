package com.project.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.project.dao.GenericDAO;
import com.project.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T>{
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/pbl3";
			String username = "root";
			String password = "123456";
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<T> result = new ArrayList<T>();
		try {
			ps = conn.prepareStatement(sql);
			setParameter(ps, parameters);
			rs = ps.executeQuery();
			while(rs.next()) {
				result.add(rowMapper.rowMapper(rs));
			}
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}
	
	public void setParameter(PreparedStatement state, Object... parameters) {
		try {
			for(int i=0;i<parameters.length;i++) {
				Object parameter = parameters[i];
				int index = i+1;
				if(parameter instanceof Long) {
					state.setLong(index, (Long)parameter);
				}
				if(parameter instanceof String) {
					state.setString(index, (String)parameter);
				}
				if(parameter instanceof Timestamp) {
					state.setTimestamp(index, (Timestamp)parameter);
				}
				if(parameter instanceof Integer) {
					state.setInt(index, (Integer)parameter);
				}
				if(parameter instanceof Boolean) {
					state.setBoolean(index, (Boolean)parameter);
				}
				if(parameter == null) {
					state.setNull(index, Types.NULL);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int save(String sql, Object... parameters) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = 0;
		if(conn!=null) {
			try {
				conn.setAutoCommit(false);
				ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				setParameter(ps, parameters);
				ps.executeUpdate();
				rs = ps.getGeneratedKeys();
				while(rs.next()) {
					id = rs.getInt(1);
				}
				conn.commit();
				return id;
				
			} catch (Exception e) {
				try {
					conn.rollback();
					e.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
				return id;
			}
			finally {
				try {
					if (conn != null) {
						conn.close();
					}
					if (ps != null) {
						ps.close();
					}
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return id;
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection conn = getConnection();
		PreparedStatement state = null;
		try {
			conn.setAutoCommit(false);
			state = conn.prepareStatement(sql);
			setParameter(state, parameters);
			state.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (state != null) {
					state.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	

}
