package com.junhua.chapitre6;

import java.util.EnumSet;
import java.util.Set;

/**
 * 将一个枚举类型的元素主要用在集合中
 * EnumSet 有效地表示从单个枚举类型中提取多个值得多个集合
 */

public class EnumSetTest {
	
	public enum style{
		BOLD, ITALIC,UNDERLINE, STRIKETHROUGH;
	}
	
	public void applyStyles(Set<style>styles){
		for (style style : styles) {
			System.out.println(style);
		}
	}
	
	public static void main(String[] args) {
		new  EnumSetTest().applyStyles(EnumSet.of(style.BOLD, style.UNDERLINE));
		//BOLD
		//UNDERLINE
		
		System.out.println(EnumSet.range(style.ITALIC, style.STRIKETHROUGH));
		//[BOLD, ITALIC, UNDERLINE, STRIKETHROUGH]

		for(style value: style.values())
		System.out.println(value);
//		BOLD
//		ITALIC
//		UNDERLINE
//		STRIKETHROUGH
		
	}
}
