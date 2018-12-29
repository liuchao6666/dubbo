package com.liuchao.dubbo.provider;

import java.util.concurrent.atomic.AtomicInteger;

import com.liuchao.dubbo.api.PersonInfoService;


public class PersonInfoServiceImpl implements PersonInfoService {
	
	private static final AtomicInteger count = new AtomicInteger(0);

	@Override
	public String queryPersonInfoAll() {
		System.out.println("接口实现：queryPersonInfoAll");
		return "from PersonInfoServiceImpl: some person Info";
	}

	@Override
	public String queryPersonInfoByNumber(String personNumber) {
		count.incrementAndGet();
		System.out.println("接口实现：queryPersonInfoByNumber");
		System.out.println("接口被调用了" + count.get() + "次");
		return "from PersonInfoServiceImpl: " + personNumber + "'s Info";
	}

}
