/**
 * 
 */
package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.Lane;
import segment.PassableSegment;
import segment.Segment;
import util.MetricToPixel;

/**
 * @author bublm1
 */
@SuppressWarnings("serial")
public class PassableSegmentPanel extends SegmentPanel {

	public static BufferedImage STRAIGHT;
	public static BufferedImage STRAIGHT_LEFT;
	public static BufferedImage STRAIGHT_RIGHT;
	
	/**
	 * @author bublm1
	 * @param segment
	 * @param numberOfLanes
	 * @param fastLaneOffset
	 * @param trackOffset
	 */
	public PassableSegmentPanel(Segment segment, int numberOfLanes, int fastLaneOffset, int trackOffset) {
		super(segment, numberOfLanes, fastLaneOffset, trackOffset);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		boolean isNotPassableLeft = !((PassableSegment) this.segment).isPassableLeft();
		boolean isNotPassableRight = !((PassableSegment) this.segment).isPassableRight();
		
		if (isNotPassableLeft || isNotPassableRight) {
			
			int xPosition = MetricToPixel.scale(this.segment.start());
			int yPosition = MetricToPixel.scale(this.trackOffset + Lane.WIDTH * this.fastLaneOffset);
			
			if (isNotPassableLeft && isNotPassableRight) {
				g.drawImage(STRAIGHT, xPosition, yPosition + 5, 20, 20, this);
			} else if (isNotPassableLeft) {
				g.drawImage(STRAIGHT_LEFT, xPosition, yPosition + 5, 20, 20, this);
			} else if (isNotPassableRight) {
				g.drawImage(STRAIGHT_RIGHT, xPosition, yPosition + 5, 20, 20, this);
			}
		}
		
//		g.drawString((new File("").getAbsolutePath()), xPosition+10, yPosition+20);
	}

}
