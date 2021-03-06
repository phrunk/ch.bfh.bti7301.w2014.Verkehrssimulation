/**
 *
 */
package util;

/**
 * @author bublm1
 */
public class MetricToPixel {
	public static int SCALING_FACTOR = 8;

	/**
	 * @author bublm1
	 * @param length
	 * @return
	 */
	public static int scale(int distance) {
		return distance * MetricToPixel.SCALING_FACTOR;
	}

	/**
	 * @author bublm1
	 * @param stepBackPosition
	 * @return
	 */
	public static int scale(float distance) {
		return (int) (distance * (float)MetricToPixel.SCALING_FACTOR);
	}
	
	/**
	 * @author bublm1
	 * @return
	 */
	public static int getImageSize() {
		return 4 * MetricToPixel.SCALING_FACTOR;
	}
	
	/**
	 * @author bublm1
	 * @return
	 */
	public static int getFontSize() {
		return 2 * MetricToPixel.SCALING_FACTOR;
	}
	
	/**
	 * @author bublm1
	 * @return
	 */
	public static int getTurnSignalSize() {
		double turnSignalSize = (double) MetricToPixel.SCALING_FACTOR / 3;
		return (int) Math.ceil(turnSignalSize);
	}

	/**
	 * @author bublm1
	 */
	public static void zoomIn() {
		SCALING_FACTOR++;
	}

	/**
	 * @author bublm1
	 */
	public static void zoomOut() {
		SCALING_FACTOR--;
	}
}
