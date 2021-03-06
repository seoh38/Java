package com.kh.lambda.standard;

import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.kh.lambda.standard.model.vo.Student;

public class E_Predicate {
	/*
	 * Predicate
	 *   - Predicate 함수적 인터페이스는 매개변수와 boolean 리턴값이 있는 testXXX() 메소드를 가지고 있다.
	 *   - 이 메소드들은 매개값을 조사해서 true/false를 리턴하는 역할을 한다.
	 */
	public void method1() {
		Student student1 = new Student("이서희", 26, "여자", 90, 100); 
		Student student2 = new Student("도경수", 29, "남자", 100, 80); 
		
		// 객체를 받아서 true/ false를 리턴한다.
		Predicate<Student> predicate = (s) -> {
			return s.getGender().equals("남자");
		};
		
		System.out.println("이서희는 남자 입니까? : " + predicate.test(student1));
		System.out.println("도경수는 남자 입니까? : " + predicate.test(student2));
		
		IntPredicate intPredicate = (int i) ->  i > 100;

		System.out.println(intPredicate.test(100));
		System.out.println(intPredicate.test(101));
		
	}

}
