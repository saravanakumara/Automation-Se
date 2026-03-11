package com.learningmind.learning;

public class TestOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Testing";
		TestOne t1obj = new TestOne();
		System.out.println(t1obj.add(1, 0.1));
		
		StringBuilder outStringBuilder = new StringBuilder();
		String res = str.replace('t', 'o').replace('T', 'o');
//		for(int i = 0; i < str.length(); i++) {
//			if(str.charAt(i) == 'T' || str.charAt(i) == 't') {
//				outStringBuilder.append("o");
//			} else {
//				outStringBuilder.append(str.charAt(i));
//			}
//		}
//		System.out.println(outStringBuilder.toString());

	}

	protected int add(int a, int b) {
		return a + b;
	}
	
	double add(double a, double b) {
		return a + b;
	}
}
