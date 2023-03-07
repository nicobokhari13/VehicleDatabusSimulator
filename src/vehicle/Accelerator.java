package vehicle;

import events.DataType;
import events.EmergencyVehicleNearby;
import events.GreenLight;
import events.PotHole;
import events.RedLight;
import events.DataType.Status;

public class Accelerator implements Member {
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
			disengage();
		}
	}
	
	private void handleEvent(RedLight event) {
		if(event.getStatus() == Status.STOP) {
			disengage();
		}
	}
	
	private void handleEvent(EmergencyVehicleNearby event) {
		if(event.getStatus() == Status.STOP) {
			disengage();
			System.out.println("\tThe Vehicle is no longer accelerating");
		}
	}
	
	private void handleEvent(GreenLight event) {
		if(event.getStatus() == Status.GO) {
			engage();
			System.out.println("\tThe Vehicle will accelerated until it reaches " + event.getSpeed() + "mph");
		}
	}
	
	private void engage() {
		System.out.println("\tAccelerator:Engaged");
	}
	
	private void disengage() {
		System.out.println("\tAccelerator:Disengaged");
	}
	

}
