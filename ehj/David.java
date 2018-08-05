import javax.swing.ImageIcon;


public class David extends Sprite{
	
	private int numStones;
	public David(){
		super();
		image = new ImageIcon("david.png");
		
		numStones=0;
		
	}
	public void pickUpStone() {
		numStones += 1;
	}
	public boolean isArmed() {
		if ( numStones == 5) {
			return true;
		}
		else {
			return false;
		}
	}
	public void reset() {
		numStones = 0;
	}
}
