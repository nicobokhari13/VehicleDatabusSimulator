package vehicle;

import events.*;
import events.DataType.Status;

public class LiDar implements Member {

	@Override
	public void accept(DataType event) {
		// call eventHandler for a specific event Type and status
		if(event instanceof EmergencyVehicleNearby) {
			handleEvent((EmergencyVehicleNearby) event);
		}
	}

	private void handleEvent(EmergencyVehicleNearby event) {
		if(event.getStatus() == Status.FINDLOCATION) {
			System.out.println("\tLiDar:Found safe location to pull over at coordinates [3.0, 4.0, 5.0]");
			EmergencyVehicleNearby update = new EmergencyVehicleNearby(Status.STOP, event.getMessage());
			update.setLocation(3.0, 4.0, 5.0);
			sendToBus(update);
		}
	}
	
	public void sendToBus(DataType event) {
		if(event instanceof EmergencyVehicleNearby) {
			DataBus.getInstance().publish((EmergencyVehicleNearby) event);
		}
	}

}
