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
			
			sendServer("gps ���");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void ble(){
		try {
			Thread.sleep(4000);
			
			sendServer("ble ���");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void network(){
		try {
			Thread.sleep(1000);
			sendServer("network ���");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static synchronized void sendServer(String msg){
		// �������� ��� success 
		if(!isSend){
			isSend = true;
			System.out.println(msg + " ����");
		} else {
			System.out.println("�̹� �������� ����� ���ƽ��ϴ�.");
		}
	}
}
