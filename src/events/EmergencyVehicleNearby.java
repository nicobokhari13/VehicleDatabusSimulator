package events;

public class EmergencyVehicleNearby extends DataType {

	public EmergencyVehicleNearby() {
		this.setID();
		this.setStatus(Status.FINDLOCATION);
		this.setMessage("Pull over! There is an emergency vehicle nearby.");
	}
	public EmergencyVehicleNearby(Status s, String msg) {
		this.setID();
		this.setStatus(s);
		this.setMessage(msg);
	}
	
}
