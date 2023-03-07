package vehicle;

import events.*;
import events.DataType.Status;

public class GPS implements Member {

	@Override
	public void accept(DataType event) {
		// call eventHandler for a specific event Type and status
		if(event instanceof GreenLight) {
			handleEvent((GreenLight) event);
		}
	}
	
	private void handleEvent(GreenLight event) {
		if(event.getStatus() == Status.FINDSPEED) {
			System.out.println("\tGPS:Found Speed Limit is 45 mph");
			GreenLight update = new GreenLight(Status.GO, event.getMessage());
			update.setSpeed(45.0);
			sendToBus(update);
		}
	}
	
	//GPS may publish events to bus
	private void sendToBus(DataType event) {
		if(event instanceof GreenLight) {
			DataBus.getInstance().publish((GreenLight)event);
		}
	}

}
