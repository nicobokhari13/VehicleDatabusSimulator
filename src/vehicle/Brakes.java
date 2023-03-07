package vehicle;

import events.*;
import events.DataType.Status;

public class Brakes implements Member {

	@Override
	public void accept(DataType event) {
		// call eventHandler for a specific event Type and status
		if(event instanceof PotHole) {
			handleEvent((PotHole) event);
		}
		else if(event instanceof RedLight) {
			handleEvent((RedLight) event);
		}
		else if(event instanceof EmergencyVehicleNearby) {
			handleEvent((EmergencyVehicleNearby) event);
		}
		else if(event instanceof GreenLight) {
			handleEvent((GreenLight) event);
		}
	}
	//private eventHandlers that are only called by Brakes class
	
	private void handleEvent(PotHole event) {
		if(event.getStatus() == Status.STOP) {
			engage();
			System.out.println("\tThe Vehicle is slowing down, and safely crosses the PotHole");
		}
	}
	
	private void handleEvent(RedLight event) {
		if(event.getStatus() == Status.STOP) {
			engage();
			System.out.println("\tThe Vehicle is coming to a complete stop");
		}
	}
	
	private void handleEvent(EmergencyVehicleNearby event) {
		if(event.getStatus() == Status.STOP) {
			engage();
			System.out.println("\tThe Vehicle is coming to a complete stop");
		}
	}
	
	private void handleEvent(GreenLight event) {
		if(event.getStatus() == Status.GO) {
			disengage();
		}
	}
	
	private void engage() {
		System.out.println("\tBrakes:Engaged");
	}
	
	private void disengage() {
		System.out.println("\tBrakes:Disengaged");
	}

}
