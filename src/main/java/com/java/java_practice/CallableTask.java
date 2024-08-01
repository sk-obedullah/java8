package com.java.java_practice;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<String>{

	@Override
	public String call() throws Exception {
		 
		return "Task Completed";
	}
	
	

}
