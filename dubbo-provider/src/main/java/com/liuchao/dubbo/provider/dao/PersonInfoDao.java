package com.liuchao.dubbo.provider.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.liuchao.dubbo.api.entity.PersonInfo;
import com.liuchao.dubbo.provider.dao.wrapper.PersonInfoRowMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonInfoDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public PersonInfo queryPersonInfo(String personNumber) {
		String sql = "select * from person_info where person_number=?";
		log.info("执行sql：{}", sql);
		// TODO 查询不到数据会抛异常
		return jdbcTemplate.queryForObject(sql, new PersonInfoRowMapper(), personNumber);
	}

	public List<PersonInfo> queryPersonInfoList() {
		String sql = "select * from person_info";
		log.info("执行sql：{}", sql);
		return jdbcTemplate.query(sql, new PersonInfoRowMapper());
	}
}
