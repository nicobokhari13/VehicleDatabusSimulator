package events;

public class PotHole extends DataType {

	public PotHole() {
		this.setID();
		//when PotHole event is created, set Status to STOP
		this.setStatus(Status.STOP);
		this.setMessage("Slow down! There is a pothole");
	}
	public PotHole(Status s, String msg) {
		this.setID();
		this.setStatus(s);
		this.setMessage(msg);
	}
	
	
}
