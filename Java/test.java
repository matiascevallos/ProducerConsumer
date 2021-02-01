package Threads;

import java.util.ArrayList;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		//every 2 seconds they check to see the boudned buffer and see if there a request.
		//If theres a request it retrieves the quest and makes the consumer be busy. 
		//Len of buffer is the length of amount that can be in the buffer.
		//creates that amount 
		Scanner input = new Scanner(System.in);
		System.out.println("How many consumers?"); //one to many
		int numConsumers = input.nextInt();
		System.out.println("Length of the buffer?");
		int sizeBuffer = input.nextInt();
		System.out.println("How many total requests to be made?");
		int totalRequest = input.nextInt();
		
		//create a queue, producer for requests.
		//arraylist 
		Queue q1 = new Queue(sizeBuffer);
		Producer p1 = new Producer(q1,totalRequest);
		ArrayList<Consumer> arrayConsumer = new ArrayList<Consumer>();
		for (int i=0;i<numConsumers;i++) //create n consumers wanted by the consumer
			arrayConsumer.add(new Consumer(q1,i));	
		
		//creates a fork in the program so you can produce threads while consuming them simulatenously
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				p1.start();
			}
		});
		//starts new thread
		th.start();
		//thread for each new consumer
		for (Consumer c:arrayConsumer) {
			//fork new runnable
			Thread th1 = new Thread(new Runnable() {
				@Override
				public void run() {
					c.start();
				}
			});
			th1.start();
			
		}
			
	}

}
