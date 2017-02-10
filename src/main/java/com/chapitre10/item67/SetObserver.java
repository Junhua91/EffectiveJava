package com.chapitre10.item67;

import com.chapitre10.item67.ObservableSet;

public interface SetObserver<E> {
	void added(ObservableSet<E> set, E element);
}
