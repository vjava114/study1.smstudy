package com.study.thread.callableExam;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


public class CallableStart {

	
	public static void main(String[] args) {
		
		
		/*
		 * 	하나의 프로세스에서 2종류의 쿠폰을 multi thread 로 동작 시키기 위한 예제 
		 */
		GenCoupon g = new GenCoupon();
		g.setCouponInfo("A 쿠폰");
		GenCoupon g2 = new GenCoupon();
		g2.setCouponInfo("B 쿠폰");
		
		for (int i = 0; i < 10; i++) {
			g.generate(i);
			g2.generate(i);
		}
		
		
		/*
		 * 쓰레드가 수행되고 Callable 에 의해 만들어진 Future 객체를 반환받음 (Future 객체는 쓰레드와 동기적으로 작동한다)
		 * 메소드에 thread shotdown 호출이 있는데 매우 중요하므로 반드시 확인할것.
		 */
		List<Future<String>> resultList = g.closing();
		List<Future<String>> resultList2 = g2.closing();

		
		

		/*
		 *  아래의 Future 를 통해서 thread task들이 끝나고 반환 한 정보들을 확인 할 수있다.
		 *  반드시 futuer.get() 또는 future.isDon() 메소드가 실행되어야 한다.
		 */
		for (Future<String> future : resultList) {
			
			 try {
				System.out.println("1 Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		for (Future<String> future : resultList2) {
			
			 try {
				System.out.println("2 Future result is - " + " - " + future.get() + "; And Task done is " + future.isDone());
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
