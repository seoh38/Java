package com.kh.lambda.standard;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

import com.kh.lambda.standard.model.vo.Student;

public class D_Operator {
	/*
	 * Operator
	 *   - Operator 함수적 인터페이스는 매개값과 리턴값이 있는 applyXXX() 메소드를 가지고 있다.
	 *   - Function 함수적 인터페이스와 다르게 주로 매개값을 이용해서 연산하고 동일한 타입으로 결과를 리턴하는 역할을 한다.
	 */
	
	public void method1() {
		// 항이 두개
		IntBinaryOperator intBinaryOperator = (a, b) -> a * b;

		System.out.println(intBinaryOperator.applyAsInt(10, 20));
		
		// IntUnaryOperator : 항이 하나임
		IntUnaryOperator intUnaryOperator = (a) -> a * a;
		
		System.out.println(intUnaryOperator.applyAsInt(30));
		
		// BinaryOperator : <T>타입을 받아서 Bifunction의 타입을 모두 t 타입으로 변경
		BinaryOperator<Student> binaryOperator = (Student s1, Student s2) -> {
			if (s1.getMath() > s2.getMath()) {
				return s1;
			}else {
				return s2;
			}
		};
		
		Student student1 = new Student("이서희", 26, "여자", 90, 100); 
		Student student2 = new Student("도경수", 29, "남자", 100, 80); 
		
		System.out.println(binaryOperator.apply(student1, student2));
		
	}

}
