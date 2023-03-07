package vehicle;

import events.DataType;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class DataBus {

	//DataBus implements Singleton to prevent multiple instances
	private static final DataBus INSTANCE = new DataBus();
	//Set of subscribers
	private final Set<Member> listeners = new HashSet<>();
	//Log of events
	private final ArrayList<DataType> eventLog = new ArrayList<>();
	//Singleton Instance accesser
	public static DataBus getInstance() {
		return INSTANCE;
	}
	//Add new subscriber to bus
	public void subscribe(final Member member) {
		this.listeners.add(member);
	}
	//Remove subscriber from bus
	public void unsubscribe(final Member member) {
		this.listeners.remove(member);
	}
	//Publish an event to the bus, notify all subscribers of new event
	public void publish(final DataType event) {
		//for each listener, call their accept method
		//members handle accepting events they are interested in
		eventLog.add(event.getID() - 1, event);
		listeners.forEach(listener -> listener.accept(event));
	}
	public ArrayList<DataType> getEventLog(){
		return eventLog; 
	}
	public void printEventLog() {
		System.out.println("-----Event Log-----");
		try {
			
			eventLog.forEach(event -> System.out.println(event.toString()));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
