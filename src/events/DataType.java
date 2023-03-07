package events;
import java.util.ArrayList;

public abstract class DataType {

	// Status enum is accessible without any subclass instantiation
	public static enum Status{
		FINDSPEED, 
		GO,
		STOP, 
		WIPE,
		FINDLOCATION,
		RESOLVED
	}
	public static int numEvents = 0;
	private int id; 
	private Status status;
	private String message;
	private double speed; 
	private ArrayList<Double> location = new ArrayList<Double>() {
		{
			add(0.0);
			add(0.0);
			add(0.0);
		}
	};
	public int getID() {
		return id;
	}
	public void setID() {
		numEvents++;
		id = numEvents; 
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status s) {
		this.status = s;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String msg) {
		this.message = msg;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public ArrayList<Double> getLocation() {
		return location;
	}
	public void setLocation(double x, double y, double z) {
		this.location.clear();
		this.location.add(0, x);
		this.location.add(1,y);
		this.location.add(2,z);
	} 
	@Override
	public String toString(){
		String pattern = "ID: %s \n\tEventType: %s \n\tStatus: %s \n\tMessage: %s";
		String msg = String.format(pattern, this.getID(), this.getClass(), this.getStatus(), this.getMessage());
		return msg; 
	}
	
}
