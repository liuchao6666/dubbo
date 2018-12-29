package com.liuchao.dubbo.provider;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.liuchao.dubbo.api.PersonInfoService;
import com.liuchao.dubbo.api.entity.PersonInfo;
import com.liuchao.dubbo.provider.dao.PersonInfoDao;

import cn.hutool.json.JSONUtil;


public class PersonInfoServiceImpl implements PersonInfoService {
	
	private static final AtomicInteger count = new AtomicInteger(0);
	
	private PersonInfoDao personInfoDao;
	
	public void setPersonInfoDao(PersonInfoDao personInfoDao) {
		this.personInfoDao = personInfoDao;
	}

	@Override
	public String queryPersonInfoAll() {
		System.out.println("接口实现：queryPersonInfoAll");
		List<PersonInfo> personInfoList = personInfoDao.queryPersonInfoList();
		return JSONUtil.toJsonStr(personInfoList);
	}

	@Override
	public String queryPersonInfoByNumber(String personNumber) {
		count.incrementAndGet();
		System.out.println("接口实现：queryPersonInfoByNumber");
		System.out.println("接口被调用了" + count.get() + "次");
		PersonInfo personInfo = personInfoDao.queryPersonInfo(personNumber);
		return JSONUtil.toJsonStr(personInfo);
	}

}
