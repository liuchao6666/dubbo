package com.liuchao.dubbo.consumer;

import com.liuchao.dubbo.api.PersonInfoService;

public class CheckPersonStatus {
	
	private PersonInfoService personInfoService;
	
	public void setPersonInfoService(PersonInfoService personInfoService) {
		this.personInfoService = personInfoService;
	}
	
	public String checkAllPersonStatus() {
		return personInfoService.queryPersonInfoAll();
	}
	
	public String checkPersonStatusByPersonNumber(String personNumber) {
		return personInfoService.queryPersonInfoByNumber(personNumber);
	}
	
	
}
