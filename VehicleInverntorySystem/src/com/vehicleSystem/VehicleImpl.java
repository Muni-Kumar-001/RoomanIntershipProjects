package com.vehicleSystem;

import java.util.ArrayList;
import java.util.Comparator;

public class VehicleImpl implements IVehicle{
	
	ArrayList<Vehicle> vehicles;
	VehicleImpl(){
		vehicles = new ArrayList<>();
	}
	@Override
	public void addVehicle(Vehicle v) {
		vehicles.add(v);
	}

	@Override
	public void display(int sortType) {
		switch (sortType) {
        case 1:
            vehicles.sort(Comparator.comparing(Vehicle::getvName));
            break;
        case 2:
            vehicles.sort(Comparator.comparingInt(Vehicle::getMfgYear));
            break;
        case 3:
            vehicles.sort(Comparator.comparingInt(Vehicle::getPrice));
            break;
        default:
            System.out.println("Invalid sort type. Please choose 'vName', 'mfgYear', or 'price'.");
            return;
    }
		vehicles.sort(null);
		System.out.println("Vehicle\tmfgYear\tprice");
		for(Vehicle vh: vehicles) {
			System.out.println(vh.getvName()+"\t"+vh.getMfgYear()+"\t"+vh.getPrice());
		}
			
	}

}
