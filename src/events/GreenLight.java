package events;

public class GreenLight extends DataType {

	public GreenLight() {
		this.setID();
		this.setStatus(Status.FINDSPEED);
		this.setMessage("There is a green light ahead. Proceed.");
	}
	public GreenLight(Status s, String msg) {
		this.setID();
		this.setStatus(s);
		this.setMessage(msg);
	}
}
