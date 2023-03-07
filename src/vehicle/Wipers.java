package vehicle;

import events.*;
import events.DataType.Status;

public class Wipers implements Member {

	@Override
	public void accept(DataType event) {
		// call eventHandler for a specific event Type and status
		if(event instanceof Rain) {
			handleEvent((Rain) event);
		}
	}
	
	private void handleEvent(Rain event) {
		if(event.getStatus() == Status.WIPE) {
			engage();
		}
	}
	
	public void engage() {
		System.out.println("\tWindshield Wipers:Engaged");
	}

}
