package com.kh.stream.basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.kh.stream.model.vo.Student;

public class A_Create {
	/*
	 *  스트림의 종류
	 *   - java.util.stream 패키지에 존재하고 BaseStream 인터페이스를 부모로 해서
	 *     자식 인터페이스들이 상속 관계를 이루고 있다.
	 *   - Stream, IntStream, LongStream, DoubleStream  
	 *   
	 *  스트림의 생성 
	 *   - 컬렉션으로부터 스트림 얻기
	 *     - 컬렉션 stream() 메소드로부터 얻어올 수 있다. (java.util.collection.stream())
	 *   - 배열로부터 스트림 얻기
	 *     - Arrays.stream(배열) 메소드를 통해서 얻어오거나 각 스트림(Stream, IntStream, ...)
	 *       of() 메소드를 통해서 얻어올 수 있다.
	 *   - 숫자 범위로 스트림 얻기 
	 *     - IntStreamdml range(), rangeClosed() 메소드를 이용해서
	 *       첫 번째 매개값부터 두 번째 매개값까지 혹은 이전까지 제공하는 스트림을 얻어올 수있다.
	 */
	
	// 컬렉션으로부터 스트림 얻기
	public void method1() {
		List<Student> list = Arrays.asList(
				new Student("도경수", 29, "남자", 80, 70),
				new Student("오세훈", 29, "남자", 70, 90),
				new Student("이서희", 29, "여자", 100, 100)
			);
		
		// for 구문 사용
		for (Student student : list) {
			System.out.println(student);
		}
		
		System.out.println();
		
//		Stream 사용
//		Stream<Student> stream = list.stream(); // 변수 생성
//		stream.forEach((s) -> System.out.println(s)); // 처리할 내용을 람다식으로 넘겨준다.
		
		// 위의 stream사용 구문을 한 줄로 작성해준다
		list.stream().forEach((s) -> System.out.println(s));
		
	}
	
	// 배열로부터 스트림 얻기
	public void method2() {
		String[] names = {"이서희", "도경수","정재현"};
		
//		Stream<String> stream =  Arrays.stream(names);
		
		Stream<String> stream = Stream.of(names);
		
		stream.forEach(str -> System.out.println(str));
	}
	
	// 숫자 범위로 스트림 얻기
	// 숫자 범위로 스트림을 얻으려면 IntStream 사용
	public void method3() {
		// 첫 번째 매개값 ~ 두 번째 매개값 이전까지의 값을 요소로 갖는 스트림 객체 생성한다.
		// 1 부터 9까지!
		IntStream stream = IntStream.range(1, 10);
	
		// 최종처리 메소드(sum())를 사용면 closed가 된다.
		// 다시 사용하고 싶다면 다시 만들어라
		int sum = stream.peek(i -> System.out.println(i + " ")).sum();
		
		System.out.println("\nSum : " + sum);
		
		
		// 첫 번째 매개값 ~ 두 번째 매개 값까지의 값을 요소로 갖는 스트림 객체 생성한다.
		// 1부터 10 까지!!
		stream = IntStream.rangeClosed(1, 10);
		sum = stream.sum();
		
		System.out.println("Sum : " + sum);
	}
	
}
