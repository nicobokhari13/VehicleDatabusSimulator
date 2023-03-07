package events;

public class Rain extends DataType {
	
	public Rain() {
		this.setID();
		this.setStatus(Status.WIPE);
		this.setMessage("Rain is covering the Windshield");
	}
	public Rain(Status s, String msg) {
		this.setID();
		this.setStatus(s);
		this.setMessage(msg);
	}
}
