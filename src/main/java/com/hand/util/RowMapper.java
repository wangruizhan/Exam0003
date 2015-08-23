package com.hand.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 将结果集中的一行映射成一个实体对象
 */
public interface RowMapper {
	public Object getEntity(ResultSet rs) throws SQLException;
}
