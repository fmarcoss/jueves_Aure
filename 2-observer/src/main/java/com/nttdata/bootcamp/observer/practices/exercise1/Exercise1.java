package com.nttdata.bootcamp.observer.practices.exercise1;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class Exercise1 {

	public static void main(String[] args) {
		Observable<String> messageSender = Observable.just("Mensaje 1", "Mensaje 2", "Mensaje 3");
	    
		messageSender.subscribe(new Observer<String>() {
	        @Override
	        public void onSubscribe(Disposable d) {
	            System.out.println("Observer 1. Subscribed.");
	        }

	        @Override
	        public void onNext(String s) {
	            System.out.println("Observer 1. Received: " + s);
	        }

	        @Override
	        public void onError(Throwable e) {
	            System.out.println("Observer 1. Error: " + e.getMessage());
	        }

	        @Override
	        public void onComplete() {
	            System.out.println("Observer 1. Completed");
	        }
	    });
		
		messageSender.subscribe(new Observer<String>() {
	        @Override
	        public void onSubscribe(Disposable d) {
	            System.out.println("Observer 2. Subscribed.");
	        }

	        @Override
	        public void onNext(String s) {
	            System.out.println("Observer 2. Received: " + s);
	        }

	        @Override
	        public void onError(Throwable e) {
	            System.out.println("Observer 2. Error: " + e.getMessage());
	        }

	        @Override
	        public void onComplete() {
	            System.out.println("Observer 2. Completed");
	        }
	    });
	}
}
