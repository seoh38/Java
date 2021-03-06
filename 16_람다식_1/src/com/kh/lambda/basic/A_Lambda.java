package com.kh.lambda.basic;

public class A_Lambda {
	
	public void method1() {

		// 스레드 클래스를 상속하는 새로운 클래스 생성
		Thread thread;
		
		//  Runnable 인터페이스 구현하는 클래스 생성
		// 인터페이스를 객체로 구현할 수 없지만 추상 메소드로 구현하면 된다.
		thread = new Thread(new Runnable() {
			
			//  Runnable 인터페이스 익명구현 객체로 구현
			@Override
			public void run() {
				System.out.println("익명 구현 객체를 사용한 Thread 생성");
			}
		});
		
		thread.start();
		

		// 람다식을 사용한 스레드 생성
		// Runnable ()인터페이스와 모습이 같아야함!!!!(중요)!!!!!!

		thread = new Thread(() -> {
			System.out.println("람다식을 사용한 Thread 생성");
		});
		
		thread.start();		
	}


	}


