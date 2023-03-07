package vehicle;

import events.*;
import events.DataType.Status;

public class Steering implements Member {

	@Override
	public void accept(DataType event) {
		// call eventHandler for a specific event Type and status

		if(event instanceof RedLight) {
			handleEvent((RedLight) event);
		}
		else if(event instanceof EmergencyVehicleNearby) {
			handleEvent((EmergencyVehicleNearby) event);
		}
	}
	//private eventHandlers that are only called by Brakes class
	
	private void handleEvent(RedLight event) {
		if(event.getStatus() == Status.STOP) {
			disengage();
		}
	}
	
	private void handleEvent(EmergencyVehicleNearby event) {
		if(event.getStatus() == Status.STOP) {
			engage();
			System.out.println("\tSteering:Vehicle is being directed to coordinates: " + event.getLocation().toString());
		}
	}
	
	private void engage() {
		System.out.println("\tSteering:Engaged");
	}
	
	private void disengage() {
		System.out.println("\tSteering:Disengaged");
	}
}
