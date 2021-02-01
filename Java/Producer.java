package Threads;

import java.util.Random;

public class Producer {

	/*
	 * Consumer's
	 * Buffer Length
	 * Sleep Length
	 * Create one producer, multiple N consumers
	 * One 
	 */
	
	private int id=0;
	private final int sleep=5;
	private int totalRequest;
	private Queue q;
	
	public Producer(Queue q, int totalRequest) {
		this.q=q;
		this.totalRequest=totalRequest;
	}
	//try: to encapsulate.
	//if queue is full, keep trying to put in the queue
	public void start() {
		try {
			while(true) {
				if (id>=totalRequest) {
					System.out.println("Producer: all requests produced, Job Done!");
					break;
				}
				if (!q.isFull()) {
					Random myRandom = new Random(); //random number
					int rando = myRandom.nextInt(10)+5;
					CustomRequest cr = new CustomRequest(id,rando); //create a new request with random length
					boolean status = q.insert(cr);
					if (status)
						System.out.println("Producer: produced request ID " + cr.requestId + ", request length: "+ cr.requestLength + " seconds.");
						id++;
				}
				else {
					System.out.println("Producer: Sleeping for " + sleep + " seconds.");
					Thread.sleep(sleep*1000); //cleep timer
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
