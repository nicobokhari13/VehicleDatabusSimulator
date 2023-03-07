package events;

public class RedLight extends DataType {

	public RedLight() {
		this.setID();
		this.setStatus(Status.STOP);
		this.setMessage("There is a red light ahead. Stop.");
	}
	public RedLight(Status s, String msg) {
		this.setID();
		this.setStatus(s);
		this.setMessage(msg);
	}
}
