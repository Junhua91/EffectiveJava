package com.junhua.interview;

public class InitialOrderTest {
	/* 静态变量 */
	public static String staticField = "静态变量";
	/* 变量 */
	public String field = "变量";
	/* 静态初始化块 */
	static {
		System.out.println(staticField);
		System.out.println("静态初始化块");
	}
	/* 初始化块 */
	{
		System.out.println(field);
		System.out.println("初始化块");
	}

	/* 构造器 */
	public InitialOrderTest() {
		System.out.println("构造器");
	}

	public static void main(String[] args) {
		new InitialOrderTest();
	}
}