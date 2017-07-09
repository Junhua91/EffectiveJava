package com.junhua.interview;

public class OuterClass {

	public void outerMethod() {
		InnerClass innerClass = new InnerClass();
	}

	public class InnerClass {

	}

	public static class InnerClass2 {

	}

	public static void main(String[] args) {
		OuterClass out = new OuterClass();
		out.outerMethod();

		OuterClass.InnerClass in = out.new InnerClass();

		String a = "programming";
		String b = "program" + "ming";
		String c = new String("programming");

		System.out.println(a == b);
		System.out.println(a == c);
		System.out.println(a.equals(c));
		System.out.println(a.equals(b));

		InnerClass2 inn2 = new InnerClass2();
		
		System.out.println(reverse("hello"));
		
		System.out.println(tryTest());
	}

	public static String reverse(String originStr) {
		if (originStr == null || originStr.length() <= 1)
			return originStr;
		return reverse(originStr.substring(1)) + originStr.charAt(0);
	}
	
	public static int tryTest(){
		
		int a =0;
		
		try{
			a++;
			return a;
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			a+=3;
		}
		return a;
	}

}
