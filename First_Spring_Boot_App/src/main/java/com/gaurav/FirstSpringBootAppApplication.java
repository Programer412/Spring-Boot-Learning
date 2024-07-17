package com.gaurav;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import com.gaurav.config.MyMessage;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

//@SpringBootApplication
//public class FirstSpringBootAppApplication implements CommandLineRunner{//two runner commandlinerunner and application runner

//	public static void main(String[] args) {
//		ConfigurableApplicationContext run=SpringApplication.run(FirstSpringBootAppApplication.class, args);
//		int i=run.getBeanDefinitionCount();
//  System.out.println(i);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("command line runner");
//	}
//
//}
	
	@SpringBootApplication
	public class FirstSpringBootAppApplication {

 	public static void main(String[] args) {
	ConfigurableApplicationContext context=SpringApplication.run(FirstSpringBootAppApplication.class, args);
MyMessage msg=context.getBean(MyMessage.class);
System.out.println(msg.getMessage());



}
	}
