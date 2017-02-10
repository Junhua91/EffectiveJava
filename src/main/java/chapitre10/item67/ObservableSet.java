package com.chapitre10.item67;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ObservableSet<E> extends ForwardingSet<E> {

	public ObservableSet(Set<E> set) {
		super(set);
	}

	private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<>();
	// private final List<SetObserver<E>> observers = new
	// ArrayList<SetObserver<E>>();

	public void addObserver(SetObserver<E> observer) {
		observers.add(observer);
	}

	public boolean removeObserver(SetObserver<E> observer) {
		return observers.remove(observer);
	}
	
	// public void addObserver(SetObserver<E> observer) {
	// synchronized (observers) {
	// observers.add(observer);
	// }
	// }
	//
	// public boolean removeObserver(SetObserver<E> observer) {
	// synchronized (observers) {
	// return observers.remove(observer);
	// }
	// }

	private void notifyElementAdded(E element) {
		for (SetObserver<E> observer : observers)
			observer.added(this, element);
	}
//	private void notifyElementAdded(E element) {
//		List<SetObserver<E>> snapshot = null;
//		synchronized (observers) {
//			snapshot = new ArrayList<SetObserver<E>>(observers);
//		}
//		
//		for (SetObserver<E> observer : snapshot)
//			observer.added(this, element);
//	}

	@Override
	public boolean add(E element) {
		boolean added = super.add(element);
		if (added)
			notifyElementAdded(element);
		return added;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean result = false;
		for (E element : c)
			result |= add(element);
		return result;
	}
}
