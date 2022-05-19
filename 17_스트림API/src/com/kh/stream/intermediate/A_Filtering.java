package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class A_Filtering {
	/*
	 * 필터링
	 *   - 중간 처리 기능으로 요소를 걸러내는 역할을 한다.
	 *     distinct() : 중복을 제거하는 메소드, Stream의 경우 Object.equals()가 true를 리턴하면 동일객체로 판단한다. 
	 *     filter(Predicate) : 매개 값으로 전달 되는 Predicate(익명구현객체)가 false를 리턴하는 요소를 제거한다.
	 */
	
	// 중복제거
	public void method1() {
		List<String> names = Arrays.asList("이서희", "이제노", "정재현", "이서희", "이제노", "이민형");
		
		Stream<String> stream = names.stream();
		
		stream.forEach(str -> System.out.println(str));
		
		// 이미 최종처리 메소드까지 호출된 스트림은 다시 사용할 수 없다.(forEach())
		// (컬렉션(배열)로부터 다시 스트림을 얻어와야 한다.)
//		stream.forEach(str -> System.out.println(str));
		
		// 중간처리 메소드들은 새로운 스트림을 만들어서 리턴해준다. => new stream으로 리턴
		// forEach()메소드 다시 사용 가능!!!!
		System.out.println();
		
		// 중복이 제거되어 출력된다.
		names.stream().distinct().forEach(str -> System.out.println(str));
	}
	
	// 필터링
	public void method2() {
		List<String> names = Arrays.asList("이서희", "이제노", "정재현", "이서희", "이제노", "도경수", "김종인");
		
		names.stream()	
				.filter((name) -> name.startsWith("이")) // "이"로 시작하면 통과
				.forEach(name -> System.out.println(name)); // 하나의 스트림으로 만들어서 return	
		
		System.out.println();
		
		names.stream()
				.distinct()
				.filter((name) -> name.startsWith("도"))
				.forEach(name -> System.out.println(name));
	}

}
