package com.kh.stream.intermediate;

import java.util.Arrays;
import java.util.List;

import com.kh.stream.model.vo.Student;

public class B_Mapping {
	/*
	 * Mapping
	 *   - 중간 처리 기능으로 스트림의 요소를 다른 요소로 대체하는 작업을 말한다.
	 *     - flatMapXXX()     : 하나의 요소를 복수의 요소들로 구성된 새로운 스트림을 생성한다.
	 *     - Map()		      : 요소를 대체하는 요소로 구성된 새로운 스트림을 생성한다.
	 *     - asDoubleStream() : IntStream, LongStream => DoubleStream으로 변환해서 리턴한다.
	 *     - asLongStream()   : IntStream, DoubleStream => LongStream으로 변환해서 리턴한다.
	 *     - boxed()          : int, long. double 요소를 Integer, Long, Double 요소로 박싱해서 스트림을 생성한다.
	 */
	
	public void method1() {
		List<Student> list = Arrays.asList(
				new Student("도경수", 29, "남자", 80, 70),
				new Student("오세훈", 29, "남자", 70, 90),
				new Student("이서희", 29, "여자", 100, 100)
			);
		
		// 원하는 요소들을 뽑아와서 평균을 구하거나 합계를 구할 때 많이 사용!!
		// 요소를 대체하는 새로운 요소로 변경해줌
		// 매개값으로 함수적 인터페이스를 익명 구현 객체로 만들어주는 람다식을 넣어준다.
		list.stream()
		    // map()으로 감싸주면 리턴되는 값(name)만 모아서 새로운 stream 생성
			.map((student) -> student.getName())
			// student 타입의 요소를 String 타입으로 변경해서 처리
			.forEach((name) -> System.out.println(name));

		System.out.println();
		
		// student 타입을 받아서 정수형으로 리턴하게 람다식 작성
		double avg =list.stream()
					.mapToInt((student) -> student.getMath())
					.average() // 평균
					.getAsDouble();
		
		System.out.println("수학점수의 평균 : " + avg);
	}
	
	// flatMapXXX()
	public void method2() {
		List<String> list = Arrays.asList("Java11 Lambda", "StreamAPI Filtering Mapping");
		
		list.stream().forEach((str) -> System.out.println(str));
		
		System.out.println();
		
		// 각각의 문자들을 요소로 가지는 새로운 스트림을 생성해줌
		// 하나의 요소 "Java11 Lambda"를 각각 쪼개줌
		// 문자열을 쪼개서 배열로 담아서 리턴해준다. String[]
		list.stream()
			.flatMap((str) -> Arrays.stream(str.split(" ")))
			.forEach(str -> System.out.println(str));	
	}
	
	// asDoubleStream(), asLongStream(), boxed()
	public void method3() {
		int[] array = {1, 2, 3, 4, 5};
		
		Arrays.stream(array)
				.asDoubleStream() // 실수값으로 변경
				.forEach(value -> System.out.println(value));

		System.out.println();
		
		Arrays.stream(array)
				.boxed() // 정수값을 가지는 요소들을 객체형태로 aovlds
				.forEach(value -> System.out.println(value.intValue()));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
