package com.kh.stream.terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

import com.sun.net.httpserver.Filter;

public class B_Aggregate {
	/*
	 *  기본 집계
	 *     - 최종 처리 기능으로 요소들을 처리해서 카운팅의 합계, 평균값, 최대값, 최소값 등과 같이 하나의 값으로 산출하는 것을 만한다.
	 *     - count() : 요소의 개수를 리턴
	 *     - sum() : 요소들의 합계를 리턴
	 *     - average() : 요소들의 평균을 리턴
	 *     - max() : 최대요소를 리턴
	 *     - min() : 최소 요소를 리턴
	 *     - findFirst() : 첫 번째 요소를 리턴
	 *     
	 *  커스텀 집계
	 *     - 스트림에서 기본집계 메소드를 제공하지만 다양한 집계 결과물을 만들수 있도록 reduce()라는 메소드를 제공
	 *       - 매개 타입으로 XXXOperator
	 *       - 리턴 타입으로 OptionalXXX  
	 *  
	 *  Optional 클래스
	 *     - 스트림의 최종 결과값을 저장하는 객체이다.
	 *     - 단순히 값만 저장하는 것이 아니라, 값의 존재여부를 확인하고 값이 존재하지 않을 경우 디폴트 값을 설정할 수 있는 객체이다.
	 *       - get() : 저장되어 있는 값을 얻기위해 사용한다. 
	 *       - isPresent() : 값이 저장되어 있는지 검사한다.
	 *       - orElse() : get()과 동일하게 저장되어 있는 값을 얻어오는 메소드로 값이 저장되어 있지 않을경우 디폴트값 지정 가능 
	 *       - isPresent(Consumer) : 값이 저장되어 있을 경우 Consumer에서 값을 처리한다.  
	 */
	
	public void method1( ) {
		int[] values = {1, 2, 3, 4, 5, 6};
		
		// 2의 배수의 개수
		long count = Arrays.stream(values).filter(value -> value % 2 == 0).count();
		
		System.out.println("2의 배수의 개수 : " + count);
		
		// 합계
		int sum = Arrays.stream(values).filter(value -> value % 2 == 0).sum();
		
		System.out.println("2의 배수의 합계 : " + sum);
		
		// 평균
		OptionalDouble average = Arrays.stream(values).filter(value -> value % 2 == 0).average();
		
		System.out.println("2의 배수의 평균 : " + average.getAsDouble());
		
		// 최대값
		OptionalInt max = Arrays.stream(values).filter(value -> value % 2 == 0).max();
		
		System.out.println("2의 배수의 최대값 : " + max.getAsInt());
		
		// 최소값
		OptionalInt min = Arrays.stream(values).filter(value -> value % 2 == 0).min();
		
		System.out.println("2의 배수의 최소값 : " + min.getAsInt());
		
		// 요소들 중의 첫번째 값
		OptionalInt findFirst = Arrays.stream(values).filter(value -> value % 2 == 0).findFirst();
		
		System.out.println("2의 배수의 첫번째 요소 : " + findFirst.getAsInt());
	}
	
	public void method2() {
		List<Integer> values = new ArrayList(); 
		
		// autoboxing 된다.
		// 요소를 넣어줌
		values.add(1);
		values.add(4);
		
//		System.out.println(values.stream().mapToInt(value -> value.intValue()).sum());
		
		// 스트림의 요소로는 객체들을 저장한다.
		// 객체들을 가지고 합계와 평균을 구할 수 없음!! .sum(), average() 사용 못함
		// 숫자 형태로 바꿔서 평균을 구해야한다. (mapToInt()로 형변환해줌)
//		double avg = values.stream()
//							.mapToInt(value -> value.intValue())
//							.average()
//							.getAsDouble();
		
		// 빈 값을 처리하는 방법 1 (값의 존재 여부 확인)
		// Optional은 최종 결과값을 저장하는 객체인데, 값의 존재 여부를 확인가능하다.
		// average()는 요소가 없으면 에러가 발생함으로 Optional에 담아준다.
		// OptionalDouble.empty!!
		OptionalDouble average = values.stream()
										.mapToInt(value -> value.intValue())
										.average();
		
		// isPresent() : 값이 저장되어 있는지????
		if(average.isPresent()) {
			System.out.println("평균 : " + average.getAsDouble());
		} else {
			System.out.println("데이터가 없음");
		}
		
		// 빈 값을 처리하는 방법 2 (디폴트값 설정)
		// orElse() : 기본 값을 설정해서 값이 없으면 기본값을 출력!
		double avg = values.stream()
				.mapToInt(value -> value.intValue())
				.average()
				.orElse(0.0);
		
		System.out.println("평균 : " + avg);
		
		// 빈 값을 처리하는 방법 3 (집계값을 처리하는 Consumer 등록)
		// ifPresent() :  값이 있으면 Cunsumer 실행, 값이 없으면 실행 안됨
		values.stream()
				.mapToInt(value -> value.intValue())
				.average()
				.ifPresent(d -> System.out.println("평균 : " + d));

	}
	
	// 커스텀 집계
	public void method3() {
		// 요소가 없으면 출력 안됨!
//		int[] values = {};
		int[] values = {1,2,3,4,5,6};
		
		Arrays.stream(values)
				// 연산된 값이 left로 들어가고 오른쪽 값을 곱해준다.
				.reduce((left, right) -> left * right)
				.ifPresent(value -> System.out.println(" 요소들의 곱은 얼마인가요? : " + value));
		
		int result = Arrays.stream(values)
				// 초기값 지정!!
				.reduce(2, (left, right) -> left * right);
		
		System.out.println(result);
	}
	
}
