package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * @author stahr2
 * 
 * Repräsentiert die Strecke
 *
 */

public class Track {
	private ArrayList<Lane> Lanes;
		
	public Track(){
		this.Lanes = new ArrayList<Lane>();		
	}

	public ArrayList<Lane> getTrack() {
		return Lanes;
	}
	
	public void addLane(Lane lane){
		this.Lanes.add(lane);
	}

	public void setTrack(ArrayList<Lane> lanes) {
		Lanes = lanes;
	}
	
	public Lane getLane(int Lane){
		return this.Lanes.get(Lane);
	}
	
	public void update(){
		for (Lane lane : this.Lanes){
			Car car = lane.getLane().firstEntry().getValue();
			
			while(!(car == null))
			{
				Random rn = new Random();
				double res = rn.nextDouble();
				if(car.getSpeed() < lane.getMaxVelocity()){
					car.setSpeed(car.getSpeed() + 1);
				}
				if(!(lane.getNextCar(car) == null)){
					if(((lane.getNextCar(car).getPosition() - car.getPosition()) - 1) < car.getSpeed()){
						car.setSpeed(lane.getNextCar(car).getPosition() - car.getPosition() - 1);
					}	
				}
				else{
					int rest = lane.getLength() - car.getPosition();
					int firstCarPosition = lane.getFirstCar().getPosition();
					if(rest + firstCarPosition -1 < car.getSpeed()){
						car.setSpeed(rest + firstCarPosition -1);
					}		
				}
				if(res <= car.getFactor() && car.getSpeed() > 0){
					car.setSpeed(car.getSpeed()-1);
				}
				
				car = lane.getNextCar(car);
			}
			car = lane.getLane().firstEntry().getValue();
					
			Collection<Car> cars = lane.getAllCars();
			for (Car  currentCar : cars){
				//if((currentCar.getPosition() + currentCar.getSpeed()) > lane.getLength()){
				//lane.removeCar(currentCar);
				//Car oldCar = currentCar;
				int oldPosition = currentCar.getPosition();
				currentCar.setPosition((currentCar.getPosition() + currentCar.getSpeed()) % lane.getLength());
				lane.getLane().updatePosition(oldPosition, currentCar.getPosition());
				//lane.addCar(currentCar);
				//}
				//else{
				//	currentCar.setPosition(currentCar.getPosition() + currentCar.getSpeed());
				//}	
			}
		}		
	}

	public ArrayList<Lane> getAllLanes() {
		// TODO Auto-generated method stub
		return this.Lanes;
	}

}
