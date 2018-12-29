package com.liuchao.dubbo.provider;

import com.liuchao.dubbo.api.DemoService;

public class DemoServiceImpl implements DemoService {

	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

}
