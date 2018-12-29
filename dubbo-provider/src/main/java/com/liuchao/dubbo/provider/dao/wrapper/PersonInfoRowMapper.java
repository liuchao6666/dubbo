package com.liuchao.dubbo.provider.dao.wrapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.liuchao.dubbo.api.entity.PersonInfo;

public class PersonInfoRowMapper implements RowMapper<PersonInfo> {

	@Override
	public PersonInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		PersonInfo info = new PersonInfo();
		info.setPersonNumber(rs.getString("person_number"));
		info.setPersonName(rs.getString("person_name"));
		info.setPersonAddress(rs.getString("person_address"));
		info.setPersonPhoneNumber(rs.getString("person_phone_number"));
		info.setPersonStatus(rs.getString("person_status"));
		return info;
	}

}
