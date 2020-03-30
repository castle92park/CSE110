
public class Timer {
	
	private double timeStart, timeEnd, timeElapsed;
	private String name;
	

	public Timer(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void start() {
		timeStart = System.currentTimeMillis();
	} 
	
	public void end() {	
		timeEnd = System.currentTimeMillis();
	}
	
	public double getTime() {
		
		timeElapsed = timeEnd - timeStart;		
		return timeElapsed;
	}
	
	
	
}
