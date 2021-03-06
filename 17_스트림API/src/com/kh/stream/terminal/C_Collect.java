package com.kh.stream.terminal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.kh.stream.model.vo.Student;

public class C_Collect {
	/*
	 *  수집 
	 *    - 스트림 요소들은 필터링 또는 매핑한 후 요소들을 수집하는 최종 처리 메소드인 Collect()를 제공한다.
	 *    - Collect() 메소드를 사용하면 필요한 요소만 새로운 컬렌션으로 담아서 리턴받을 수 있다.
	 */

	public void method1( ) {
		List<Student> students = Arrays.asList(
				new Student("도경수", 29, "남자", 80, 70),
				new Student("오세훈", 29, "남자", 70, 90),
				new Student("이서희", 29, "여자", 100, 100),
				new Student("변백현", 19, "남자", 40, 80),
				new Student("순두부", 10, "여자", 100, 100)
			);
		
		List<Student> maleList = students.stream()
								.filter(student -> student.getGender().equals("남자"))
								// 남학생 컬렉션 객체만 List에 담아서 리턴
								.collect(Collectors.toList());
								
		System.out.println("남학생 : " + maleList);
		
		// maleList를 스트림으로 얻어와서 새로운 작업 가능!
		maleList.stream().forEach(student -> System.out.println(student));
		
		System.out.println();
		
		Set<Student> femaleList = students.stream()
								.filter(student ->student.getGender().equals("여자"))
								// 여학생 컬렉션 객체만 set객체에 담아서 리턴
								.collect(Collectors.toSet());
//								.collect(Collectors.toCollection(() -> {return new HashSet<>();}));
//								.collect(Collectors.toCollection(HashSet::new));
		
		femaleList.stream().forEach(student -> System.out.println(student));	
		
		System.out.println();
		
		Map<String, Student> studentMap = students.stream()
										.collect(Collectors.toMap(student -> student.getName(), student -> student));
		
		System.out.println(studentMap);
		
	}
	
	
}
