package com.study.thread.multithreadExam;

public class SdkMini {

	public static boolean isSend = false;
	
	
	
	public static void init(){
		
			
			
			gps();
			ble();
			network();
			
	}
	
	
	public static  void gps(){
		try {
			Thread.sleep(1000);
			
			sendServer("gps 통신");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void ble(){
		try {
			Thread.sleep(4000);
			
			sendServer("ble 통신");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void network(){
		try {
			Thread.sleep(1000);
			sendServer("network 통신");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static synchronized void sendServer(String msg){
		// 서버와의 통신 success 
		if(!isSend){
			isSend = true;
			System.out.println(msg + " 성공");
		} else {
			System.out.println("이미 서버와의 통신을 마쳤습니다.");
		}
	}
}
