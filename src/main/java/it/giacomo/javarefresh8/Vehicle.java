package it.giacomo.javarefresh8;

public interface Vehicle {

	default void print() {
		System.out.println("I am a vehicle!");
	}
	
	//Static Default Methods
	static void blowHorn() {
		System.out.println("Blowing horn!");
	}
}
