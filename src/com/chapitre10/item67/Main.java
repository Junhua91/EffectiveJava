package com.chapitre10.item67;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 
 * @author jdeng
 * notes
 * 
 * In summary, to avoid deadlock and data corruption, never call an alien method
	from within a synchronized region. More generally, try to limit the amount of
	work that you do from within synchronized regions.
 */

public class Main {

	public static void main(String[] args) {
		
		ObservableSet<Integer> set =
				new ObservableSet<Integer>(new HashSet<Integer>());
		
		set.addObserver(new SetObserver<Integer>() {
			
			@Override
			public void added(ObservableSet<Integer> set, Integer element) {
				System.out.println(element);
				if(element==23) {
					ExecutorService executor = Executors.newSingleThreadExecutor();
					SetObserver<Integer> setObserver = this;
					try {
						executor.submit(new Runnable() {
							
							@Override
							public void run() {
								set.removeObserver(setObserver);
							}
						}).get();
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		for (int i = 0; i < 100; i++)
			set.add(i);
		
	}
}
