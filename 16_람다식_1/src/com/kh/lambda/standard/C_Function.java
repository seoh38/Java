package com.kh.lambda.standard;

import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import com.kh.lambda.standard.model.vo.Student;

public class C_Function {
	/*
	 * Function
	 *   - Function 함수적 인터페이스는 매개값 리턴값이 있는 applyXXX() 메소드를 가지고 있다.
	 *   - 주로 매개값을 리턴값으로 매핑(타입을 변환) 하는 역할을 한다.
	 */
	
	public void method1() {
		Student student = new Student("이서희", 26, "여자", 100, 90);
		
		Function<Student, String> function = s ->  s.getName();
			
			System.out.println("넌 이름이 뭐니? : " + function.apply(student));
			
			System.out.println("[수학 점수] : ");
			// 매개값으로 람다식을 만들어서 넘겨준다.
			printInt((s) -> s.getMath(), student);
			
			System.out.println("[영어 점수] : ");
			printInt((s) -> s.getEnglish(), student);
			
			System.out.println("[평균점수] : ");
			printInt((s) -> (s.getMath() + s.getEnglish()) / 2 , student);
	}
	
	public void printInt(ToIntFunction<Student> function, Student student) {
		System.out.println(function.applyAsInt(student));
		
	}

}
