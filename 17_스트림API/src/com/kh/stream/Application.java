package com.kh.stream;

import com.kh.stream.basic.A_Create;
import com.kh.stream.intermediate.A_Filtering;
import com.kh.stream.intermediate.B_Mapping;
import com.kh.stream.intermediate.C_Sorted;
import com.kh.stream.intermediate.D_Looping;
import com.kh.stream.terminal.A_Match;
import com.kh.stream.terminal.B_Aggregate;
import com.kh.stream.terminal.C_Collect;

public class Application {
	/*
	 * Stream
	 *   - 스트림은 자바 8부터 추가된 기능으로 컬렉션(배열)의 저장 요소들을 하나씩 참조해서 란다식으로
	 *     처리할 수 있도록 해주는 반복자이다.
	 *   - 스트림은 Iterator와 비슷한 역하을 하지만 람다식으로 요소 처리 코드를 제공할 수 있고 ,
	 *     내부 반복자를 사용해서 병렬 처리와 중간 처리, 최종 처리 작업을 수행할 수 있다는 점에서 차이가 있다.
	 *   - 스트림은 컬렉션 요소에 대해서 중간처리와 최종처리를 할 수 있다.  
	 *     -  중간 처리에서는 반복, 매핑, 필터링, 정렬 등을 수행한다.
	 *     - 최종 처리에서는 반복, 카운팅, 평균, 총합 등의 집계 처리를 수행한다.
	 *     
	 *   - 중간처리 메소드와 최종 처리 메소드를 쉽게 구분하는 방법  
	 *     ==> 리턴 타입을 보면 쉽게 구분이 가능하다.
	 *         리턴 타입이 Stream이라면 중간처리 메소드이다.
	 *         But, 리턴 타입이 기본타입이거나, OptionalXXX이라면 최종 처리 메소드이다.
	 *     
	 *      내부 반복자?
	 *        - 인터럴 아이터레이터 컬렌션 내부에서 요소들을 반복시키고 요소들에 대한 처리 코드를 제공!
	 *        - 반복을 컬렉션에게 맡겨두고 처리 코드만 신경쓰면 됨
	 *        - 여러개의 스레드를 활용해서 동시에 병렬적으로 처리 가능!
	 */

	public static void main(String[] args) {
		
//		System.out.println("==============================================");
//		new A_Create().method1();
//		new A_Create().method2();
//		new A_Create().method3();
		
//		System.out.println("==============================================");
//		new A_Filtering().method1();
//		new A_Filtering().method2();

//		System.out.println("==============================================");
//		new B_Mapping().method1();
//		new B_Mapping().method2();
//		new B_Mapping().method3();
		
//		System.out.println("==============================================");
//		new C_Sorted().method1();
//		new C_Sorted().method2();
//		new D_Looping().method1();
		
		System.out.println("==============================================");
//		new A_Match().method1();
//		new A_Match().method2();
		
		System.out.println("==============================================");
//		new B_Aggregate().method1();
//		new B_Aggregate().method2();
//		new B_Aggregate().method3();
		new C_Collect().method1();
	}

}
