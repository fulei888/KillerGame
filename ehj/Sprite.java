import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;


public abstract class Sprite implements Drawable {

	protected ImageIcon image;
	protected Room currentRoom;

	public Sprite() {
		 currentRoom = null;
		image = null;
	}
	public void setCurrentRoom(Room r) {
		currentRoom = r;
	}
	public Room getCurrentRoom() {
		return currentRoom; 
	}
	
	public void draw(Graphics g) {
		if(currentRoom != null && image != null){
			Point p = currentRoom.getPosition();
			image.paintIcon(null, g, p.x+7, p.y+7);
			}
		}
	public void moveSouth() {
		if (currentRoom.hasSouthExit()) {
			currentRoom = currentRoom.getSouthExit();
			}
	}
	
	public void moveNorth() {
		if (currentRoom.hasNorthExit()) {
			currentRoom = currentRoom.getNorthExit();
			}
	}
	public void moveEast() {
		if (currentRoom.hasEastExit()) {
			currentRoom = currentRoom.getEastExit();
			}
	}
	public void moveWest() {
		if (currentRoom.hasWestExit()) {
			currentRoom = currentRoom.getWestExit();
			}
	}
}
