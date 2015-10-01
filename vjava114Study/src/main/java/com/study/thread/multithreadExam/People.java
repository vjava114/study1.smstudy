package com.study.thread.multithreadExam;

public class People  extends Thread{

	
	public void run(){
		
		System.out.println(this.getName()  +  "Ω√¿€");
		
		SdkMini.init();
		
	}
	
	public static void main(String[] args) {
		


		People click1 = new People();
		click1.start();
		
		People click2 = new People();
		click2.start();
		
		People click3 = new People();
		click3.start();
		
		
		
	}
}
