package com.study.thread.callableExam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class GenCoupon {

	
	/**
	 *	Pool 갯수 제한. 다른 서비스에서 한꺼번에 호출하더라도, 2개를 초과하지 않기 위해 static 으로 지정하여 객체를 공유
	 */
	private static ThreadPoolExecutor EXECUTOR = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);	
	
	/**
	 * 	Callable 수행 후 쓰레드의 반환값이 담기게 될 객체
	 */
	private List<Future<String>> resultList = new ArrayList<Future<String>>();	

	
	/**
	 *	상품이름
	 */
	private String rewardKnm;
	

	
	
	
	
	
	
	/**
	 * 쿠폰정보 set
	 * @param rewardKnm_
	 */
	public void setCouponInfo(String rewardKnm_){
		this.rewardKnm = rewardKnm_;
	}
	
	
	/**
	 * 	쿠폰 생성 메서드
	 * @param barcode_
	 */
	public void generate(final int barcode_){
		
		if(this.rewardKnm == null) throw new NullPointerException("rewardKnm 값의 set이 먼저 되어야 합니다.");

		/*
		 * 	Runnable 과 비슷하지만, thread의 결과값을 return 을 받을수 있는 Callable 객체를 사용하기로 함.
		 */
		Callable<String> r = new Callable<String>() {
			
			public String call() throws Exception {
				// TODO Auto-generated method stub
				return generate(barcode_, rewardKnm);
			}
		};
		
		
		
		/*
		 * 	실행 후 결과를 FutureList 에 add
		 */
		Future<String> result  =  (Future<String>) EXECUTOR.submit(r);
		resultList.add(result);
		
	}

	
	private String generate(int barcode_, String rewardKnm_){
		
		//	작업시간이 1초쯤 걸린다고 가정한 로직
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("barcode No. : "+barcode_ + "|||| reward name : "  + this.rewardKnm + " 생성완료");
		return "barcode No. : "+barcode_ + "|||| reward name : "  + rewardKnm_ +" 리턴";
	}
	


	/**
	 * Future 객체를 통해 쓰레드와 동기화 하여 작동할 수 있게 됨.
	 * @return List<Future<String>>
	 */
	public List<Future<String>> closing(){
		
		/*
		 *  반드시 closing 해 주어야 함. 안그러면 스레드가 안죽고 계속 남아있음.
		 */
		EXECUTOR.shutdown();
		
		/*
		 * 	Future 객체를 이용하여 쓰레드 태스크와 동기화 하여 작동할수 있게됨.
		 */
		return resultList;
	}
}
