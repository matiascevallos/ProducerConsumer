package Threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Queue extends Thread{

	CustomRequest[] customBuffer;
	int start;
	int limit;
	
	public Queue(int n) {
		customBuffer = new CustomRequest[n];
		start=-1;
		limit=n; //limit taken as argument
		synchronized (this) { //implemented java synchronization
			this.customBuffer=customBuffer;
			this.start=start;
			this.limit=limit;
		}
	}
	//synchronization monitors.
	public synchronized boolean isFull() {
		if (start==limit-1)
			return true;
		else return false;
	}
	public synchronized boolean isEmpty() {
		if (start==-1) {
			return true;
		}
		else return false;
	}
	public synchronized boolean insert(CustomRequest cr) {
		if (isFull()) {
			return false;
		}
		else {
			start++;
			customBuffer[start] = cr;
			return true;
		}
	}
	
	public synchronized CustomRequest getRequest() {
		if (isEmpty()) {
			return null;
		}
		else {
			CustomRequest c = customBuffer[start];
			start--;
			return c;
		}
	}
}
