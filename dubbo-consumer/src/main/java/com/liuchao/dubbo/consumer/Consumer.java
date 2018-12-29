package com.liuchao.dubbo.consumer;

import java.nio.charset.Charset;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.common.utils.Assert;

public class Consumer {
	public static void main(String[] args) throws Exception {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"consumer.xml"});
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"META-INF/spring/applicationContext.xml"});
        context.start();
//        // Obtaining a remote service proxy
//        DemoService demoService = (DemoService)context.getBean("demoService");
//        // Executing remote methods
//        String hello = demoService.sayHello("world");
//        // Display the call result
//        System.out.println(hello);
        
        CheckPersonStatus checkPersonStatus = context.getBean(CheckPersonStatus.class);
        System.out.println(checkPersonStatus.checkAllPersonStatus());
        System.out.println(checkPersonStatus.checkPersonStatusByPersonNumber("12345678"));
        
        HttpClient httpClient = HttpClientBuilder.create().build();
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(3000)
        	.setSocketTimeout(3000).build();
        HttpGet httpGet = new HttpGet("http://192.168.1.49:8080/provider/person/all");
        httpGet.setConfig(requestConfig);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (200 != statusCode) {
        	System.out.println("WARN: Response code is " + statusCode);
        }
        String response = EntityUtils.toString(httpResponse.getEntity(), Charset.forName("UTF-8"));
        Assert.notNull(response, "Return null when invoke rest interface.");
        System.out.println("Rest result: " + response);
        
        
//        Thread.sleep(3600 * 24);
        
//        for (int i=0;i<1000;i++) {
//        	String oneInfo = checkPersonStatus.checkPersonStatusByPersonNumber("12345678");
//        	System.out.println(oneInfo);
//        	Thread.sleep(1000);
//        }
        
        
        context.close();
        
    }
}
