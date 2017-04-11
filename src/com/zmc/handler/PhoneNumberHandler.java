package com.zmc.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import com.zmc.pojo.PhoneNumber;

public class PhoneNumberHandler extends BaseTypeHandler<PhoneNumber> {

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, String arg1)
			throws SQLException {
		return new PhoneNumber(rs.getString(arg1));
	}

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, int arg1)
			throws SQLException {
		return new PhoneNumber(rs.getString(arg1));
	}

	@Override
	public PhoneNumber getNullableResult(CallableStatement cs, int arg1)
			throws SQLException {
		return new PhoneNumber(cs.getString(arg1));
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			PhoneNumber phoneNumber, JdbcType type) throws SQLException {
		// TODO Auto-generated method stub
		ps.setString(i, phoneNumber.toString());
	}

}
