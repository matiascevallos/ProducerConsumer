package Threads;

//class Custom requests which takes the Request id and sets its length.
public class CustomRequest {
	int requestId;
	int requestLength;
	public CustomRequest(int requestId, int requestLength) {
		super();
		this.requestId = requestId;
		this.requestLength = requestLength;
	}
	public int getRequestId() {
		return requestId;
	}

	public int getRequestLength() {
		return requestLength;
	}
	
}
