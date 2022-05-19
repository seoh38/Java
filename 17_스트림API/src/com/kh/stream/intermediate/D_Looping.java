package com.kh.stream.intermediate;

import java.util.Arrays;

public class D_Looping {
	/*
	 *  루핑
	 *     - 요소 전체를 반복하는 것을 말한다.
	 *     - peek()
	 *     	   - 중간 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용한다.
	 *         - 최종 처리 메소드가 호출되어야 동작한다.(모든 중간 처리 메소드 적용)
	 *     - forEach()
	 *         - 최종 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용한다.
	 *         - 최종 처리 메소드이기 때문에 이후 sum()과 같은 다른 최종 처리 메소드를 호출할 수 없다.
	 */
	
	public void method1() {
		int sum = 0;
		int[] values = {1, 2, 3, 4, 5};
		
		// 최종 처리 메소드가 실행되지 않으면 실행되지 않기 때문에 최종처리 메소드가 호출되어야 한다.
//		Arrays.stream(values)
//				.filter(value -> value % 2 == 0)
//				.peek(value -> System.out.println(value));
		
		Arrays.stream(values)
				.filter(value -> value % 2 == 0)
				.peek(value -> System.out.println(value))
				.sum(); // 최종처리 메소드
		
		System.out.println("Sum : " + sum);
		System.out.println();
		
		Arrays.stream(values)
				.filter(value -> value % 2 != 0)
				.forEach(value -> System.out.println(value));
//				.sum(); // 최종 처리 메소드 호출 이후에 다른 최종 처리 메소드 호출 못함!!!
				
	}

}
