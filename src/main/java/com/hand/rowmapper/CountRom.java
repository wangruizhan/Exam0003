package com.hand.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.util.RowMapper;

public class CountRom implements RowMapper {

	public Object getEntity(ResultSet rs) throws SQLException {
		return rs.getObject(1);
	}



}
