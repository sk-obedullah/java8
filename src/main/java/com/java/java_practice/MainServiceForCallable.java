package com.java.java_practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.java8.stream.ChotaEmp;

public class MainServiceForCallable {

	public static void main(String[] args) throws Exception {
//		Callable<String> task=new CallableTask();
//		task.call();

		Callable<ChotaEmp> task = () -> {
			return new ChotaEmp();
		};
 
		ExecutorService executorService=Executors.newFixedThreadPool(2);
		Future<ChotaEmp> submit = executorService.submit(task);
		System.out.println(submit.get());

	}
}
