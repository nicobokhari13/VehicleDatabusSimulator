package project;

import vehicle.*;
import events.*;
import events.DataType.Status;

import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		
		System.out.println("Starting Autonomous Vehicle Simulator...");
		
		Scanner stream = new Scanner(System.in);
		
		String menu = "\nINPUT AN EVENT FOR THE VEHICLE TO REACT: \n"
				+ "---------------------------------------------\n"
				+ "PotHole - Vehicle must slow down to proceed\n" 
				+ "RedLight - Vehicle must stop steering, stop accelerator, and brake\n"
				+ "GreenLight - Vehicle may proceed according to the Speed Limit\n"
				+ "Rain - Vehicle's windshield will be covered in rain\n"
				+ "Emergency - Vehicle must pull over to allow an emergency vehicle to pass\n"
				+ "q - Exit Program";
		
		System.out.println("Creating Vehicle Databus...");
		DataBus bus = DataBus.getInstance();
		Accelerator accel = new Accelerator();
		Brakes brake = new Brakes();
		GPS gps = new GPS();
		LiDar lidar = new LiDar();
		Steering steer = new Steering();
		Wipers wiper = new Wipers();
		bus.subscribe(accel);
		bus.subscribe(brake);
		bus.subscribe(gps);
		bus.subscribe(lidar);
		bus.subscribe(steer);
		bus.subscribe(wiper);
		int exit = 0;
		
		while(exit != 1) {
			System.out.println(menu);
			System.out.print("\nEvent:");
			String input = stream.nextLine();
			
			if(input.equals("PotHole")) {
				bus.publish(new PotHole());
				bus.publish(new PotHole(Status.RESOLVED, "PotHole successfully crossed"));	
			}
			else if(input.equals("RedLight")) {
				bus.publish(new RedLight());
				bus.publish(new RedLight(Status.RESOLVED, "Vehicle made a complete stop"));
			}
			else if(input.equals("GreenLight")) {
				bus.publish(new GreenLight());
				bus.publish(new GreenLight(Status.RESOLVED, "Vehicle proceeded at the Speed Limit"));
			}
			else if(input.equals("Rain")) {
				bus.publish(new Rain());
				bus.publish(new Rain(Status.RESOLVED, "Vehicle removed rain with windshield wipers"));
			}
			else if(input.equals("Emergency")) {
				bus.publish(new EmergencyVehicleNearby());
				bus.publish(new EmergencyVehicleNearby(Status.RESOLVED, "Vehicle successfully pulled over to a safe location and is at a complete stop"));
			}
			else if(input.equals("q")) {
				exit = 1;
				continue;
			}
			else {
				System.out.println("Invalid Event Option");
			}
			System.out.println();
		}
		stream.close();
		bus.printEventLog();
		
		System.out.println("Shutting down Autonomous Vehicle Simulator");
	}

}
