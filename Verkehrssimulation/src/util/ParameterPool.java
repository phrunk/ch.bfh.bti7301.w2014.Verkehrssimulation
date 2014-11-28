/**
 * 
 */
package util;

/**
 * @author bublm1
 */
public class ParameterPool {

	public static int FRAMES_PER_SECOND = 30; // Simulationsgeschwindigkeit in Frames pro Sekunde
//	private int speedDelta = 3; 				// Standardbeschleunigung in Meter pro Sekunde
//	private int securityDistance = 1;			// Sicherheitsabstand
//  Trödel Factor
	
	public static int VIEW_OFFSET = 0;

	/**
	 * @author bublm1
	 */
	public static void moveTrackRight() {
		VIEW_OFFSET -= 25;
	}

	/**
	 * @author bublm1
	 */
	public static void moveTrackLeft() {
		VIEW_OFFSET += 25;
	}

}
