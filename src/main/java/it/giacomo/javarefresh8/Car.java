package it.giacomo.javarefresh8;

public class Car implements Vehicle, FourWheeler{

	public void print() {
		//System.out.println("I am a four wheeler car vehicle!");
		Vehicle.super.print();
		FourWheeler.super.print();
		Vehicle.blowHorn();
		System.out.println("I am a car!");
	}

}
