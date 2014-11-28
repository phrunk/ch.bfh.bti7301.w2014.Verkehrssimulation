package segment;

import java.util.ArrayList;

import model.Car;

public class MeasuringSegment implements Segment {
	
	
	private int start;
	private int end;
	private int trafficDensity;
	private int trafficFlow;
	ArrayList<Car> carsOnSegment = new ArrayList<Car>();
	
	public MeasuringSegment(int start, int end){
		this.start = start;
		this.end = end;
	}

	@Override
	public int start() {
		// TODO Auto-generated method stub
		return this.start;
	}

	@Override
	public int end() {
		// TODO Auto-generated method stub
		return this.end;
	}
	
	public void register(Car car){
		if(!(carsOnSegment.contains(car))){
			carsOnSegment.add(car);		
		}	
	}
	
	public void deRegister(Car car){
		calculateTrafficDensity();
		carsOnSegment.remove(car);
	}

	public int getTrafficDensity() {
		return trafficDensity;
	}

	public int getTrafficFlow() {
		return trafficFlow;
	}
	
	private void calculateTrafficDensity(){
		trafficDensity = carsOnSegment.size() / (this.end - this.start);
	}
	
	private void calculateTrafficFlow(){
		
	}

}