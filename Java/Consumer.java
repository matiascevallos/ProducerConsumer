package Threads;

public class Consumer {	//creates the consumer class
	private int sleep=2;
	private Queue q;
	private String Tag;
	public Consumer(Queue q, int id) { //tags the id for the consumer
		this.q = q;
		this.Tag="Consumer "+id+" : ";
	}
	public void start() {
		try {
			while(true) {
				if (!q.isEmpty()){
					CustomRequest c1 = q.getRequest();
					if (c1!=null) {
						System.out.println(Tag + "assigned request id "+ c1.requestId + ", processing request for the next"+c1.requestLength+" seconds.");
						System.out.println(Tag + "Current time is " +java.time.LocalTime.now());
						Thread.sleep(c1.requestLength*1000);
						System.out.println(Tag + " completed request at "+java.time.LocalTime.now());
					}
					else {
						System.out.println(Tag + "Couldn't find a request/thread");
						System.out.println(Tag + "Going to sleep for " + sleep + " seconds!");
						Thread.sleep(sleep*1000);
					}
				}
				else {
					System.out.println(Tag + "Couldn't find a request/thread");
					System.out.println(Tag + "Going to sleep for " + sleep + " seconds!");
					Thread.sleep(sleep*1000);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
