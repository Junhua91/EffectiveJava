package com.junhua.chapitre6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//ע��������ʱ����
@Target (ElementType.METHOD)
//Test ע��ֻ�ڷ��������й���
public @interface Test {
}
