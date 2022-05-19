package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;

public class C_Sorted {
	/*
	 *  정렬
	 *    - 스트림은 요소가 최종 처리 되기 전에 중간 단계에서 요소를 정렬해서 최종 처리 순서를 변경할 수 있다.
	 *    - Stream<T> 은 요소객체가 Comparable 구현하지 않을 경우 예외가 발생한다.
	 *    - IntStream, LongStream, DoubleStream 은 요소를 오름차순으로 정렬한다.
	 */
	
	// 요소가 객체일 때 정렬
	public void method1( ) {
		List<String> names = Arrays.asList("변백현", "도경수", "김종인", "김준면", "오세훈");
		
		// Comparable 구현내용에 따라서 정렬
		names.stream()
//				.sorted()
//				.sorted((n1, n2) -> n1.compareTo(n2))
				.sorted(Comparator.naturalOrder())
				.forEach(name -> System.out.println(name));
		
		System.out.println();
		
		// Comparable 구현내용에 반대로 정렬
		names.stream()
//				.sorted((n1, n2) -> n2.compareTo(n1)) // 기준을 반대로 해주면 됨
				.sorted(Comparator.reverseOrder()) // reverseOrder() 
				.forEach(name -> System.out.println(name));		
		
	}
	
	// 요소가 기본 자료형일 때
	public void method2() {
		// 기본 자료형의 요소를 가지는 스트림은 오름차순으로 정렬한다.
		Arrays.stream(new int[] {5, 2, 4, 3, 1})
			.sorted()
			.forEach(value -> System.out.println(value));
		
		System.out.println();
		
		// 기본자료형을 내림차순으로 정렬하는 방법
		Arrays.stream(new int[] {5, 2, 4, 3, 1})
				.boxed() // 기본자료형을 객체로 매핑!
				.sorted(Comparator.reverseOrder())
				.mapToInt(value -> value.intValue())
				.forEach(value -> System.out.println(value));
		
		
		
		
		
		
		
	}
}
