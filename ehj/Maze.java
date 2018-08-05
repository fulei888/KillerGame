
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.JOptionPane;

/**
 * This is the "main" class of the program.
 * This is where all the other objects are created, and where
 * all the rendering (drawing) is initiated.
 *
 */
public class Maze extends JApplet implements KeyListener{

	private ArrayList<Room> rooms;
	private David a;
	private Goliath d;
	private ArrayList<Stone> c = new ArrayList<Stone>();
	
	ArrayList<Drawable> drawableList = new ArrayList<Drawable>();
	Stone s1;
	Stone s2;
	Stone s3; 
	Stone s4;
	Stone s5; 
	
	Room r1;
	Room r2;
	Room r3;
	Room r4;
	Room r5;
	Room r6;
	Room r7;
	Room r8;
	Room r9;
	Room r10;
	Room r11;
	Room r12;
	Room r13;
	Room r14;
	Room r15;
	Room r16;
	Room r17;
	/**
	 * The init method runs once, at the very start of the program.
	 */
	@Override
	public void init() {
		addKeyListener(this);
		a = new David();
		d = new Goliath();
		

		rooms = new ArrayList<Room>();
		r1 = new Room(10, 10);
		r2 = new Room(70, 10);
		r3 = new Room(130, 10);
		r4 = new Room(190, 10);
		r5 = new Room(10, 70);
		r6 = new Room(70, 70);
		 r7 = new Room(130, 70);
		 r8 = new Room(190, 70);
		 r9 = new Room(10, 130);
		 r10 = new Room(70, 130);
		 r11 = new Room(130, 130);
		 r12 = new Room(190, 130);
		 r13 = new Room(10, 190);
		 r14 = new Room(70, 190);
		 r15 = new Room(130, 190);
		 r16 = new Room(190, 190);

		rooms.add(r1);
		rooms.add(r2);
		rooms.add(r3);
		rooms.add(r4);
		rooms.add(r5);
		rooms.add(r6);
		rooms.add(r7);
		rooms.add(r8);
		rooms.add(r9);
		rooms.add(r10);
		rooms.add(r11);
		rooms.add(r12);
		rooms.add(r13);
		rooms.add(r14);
		rooms.add(r15);
		rooms.add(r16);

		r1.setEastExit(r2);
		r2.setEastExit(r3);
		r2.setSouthExit(r6);
		r3.setEastExit(r4);
		r5.setEastExit(r6);
		r6.setEastExit(r7);
		r8.setSouthExit(r12);
		r9.setEastExit(r10);
		r9.setSouthExit(r13);
		r10.setEastExit(r11);
		r10.setNorthExit(r6);
		r11.setNorthExit(r7);
		r11.setSouthExit(r15);
		r12.setSouthExit(r16);
		r14.setEastExit(r15);
		r15.setEastExit(r16);
		
		
	    s1 = new Stone();
		s1.setCurrentRoom(r13);
		s2 = new Stone();
		s2.setCurrentRoom(r8);
		 s3 = new Stone();
		s3.setCurrentRoom(r3);
		 s4 = new Stone();
		s4.setCurrentRoom(r6);
		 s5 = new Stone();
		s5.setCurrentRoom(r15);
		c.add(s1);
		c.add(s2);
		c.add(s3);
		c.add(s4);
		c.add(s5);
		
		a.setCurrentRoom(r1);
		d.setCurrentRoom(r14);
		drawableList.add(s1);
        drawableList.add(s2);
        drawableList.add(s3);
        drawableList.add(s4);
        drawableList.add(s5);
        drawableList.add(a);
        drawableList.add(d);
        for (Room r: rooms){
        	 drawableList.add(r);
        }
		
	}


	/**
	 * This method initiates all the drawing for the applet.
	 * Rather than drawing things directly, however, it delegates
	 * all the rendering to the individual Room/Sprite objects.
	 */
	@Override
	public void paint(Graphics g) {
		
		requestFocusInWindow();
		//fill in the background color
		g.setColor(new Color(200, 255, 200));
		g.fillRect(0, 0, getWidth(), getHeight());

		//draw the rooms
		
		for (Drawable s: drawableList) {
			s.draw(g);
		}

	}
// move David 
	public void keyPressed(KeyEvent e) {
		int m = e.getKeyCode();
		if( m == KeyEvent.VK_NUMPAD8 || m ==KeyEvent.VK_UP ) {
			 
			a.moveNorth();
	}
		if( m == KeyEvent.VK_NUMPAD2 || m ==KeyEvent.VK_DOWN) {
			 
			a.moveSouth();
	}
		if( m == KeyEvent.VK_NUMPAD4 || m ==KeyEvent.VK_LEFT) {
			 
			a.moveWest();
	}
		if( m == KeyEvent.VK_NUMPAD6 || m ==KeyEvent.VK_RIGHT) {
			 
			a.moveEast();
	}
		
	// move Goliath	
			int g = e.getKeyCode();
			if( g ==KeyEvent.VK_W ) {
				 
				d.moveNorth();
		}
			if(  g ==KeyEvent.VK_S) {
				 
				d.moveSouth();
		}
			if(  g ==KeyEvent.VK_A) {
				 
				d.moveWest();
		}
			if(  g ==KeyEvent.VK_D) {
				 
				d.moveEast();
		}
			
			
		for (int i=0; i<5; i++){
			if (c.get(i).getCurrentRoom() == a.getCurrentRoom()) {
				a.pickUpStone();
				c.get(i).setCurrentRoom(null);
				
			}
		    if (a.getCurrentRoom() == d.getCurrentRoom()) {
		    	if(a.isArmed()) {
		    		int choice = JOptionPane.showConfirmDialog(null, "Congratulations David! You slew Goliath!", "YOU WIN!", JOptionPane.YES_NO_OPTION);
		    	
		    
		    if(choice == JOptionPane.NO_OPTION){
				System.exit(0);
			}
			else {
				this.reset();
			}
		}
		else{
			int choice =JOptionPane.showConfirmDialog(null, "Oh no David! Goliath got you! ", "GAME OVER!", JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.NO_OPTION) {
					System.exit(0);
			}
			else {
				this.reset();
			}
					
			}
		}
	
			
			//when character move, it repaints
	repaint();
	}
	}


	private void reset() {
	// TODO Auto-generated method stub
		s1.setCurrentRoom(r13);
		s2.setCurrentRoom(r8);
		s3.setCurrentRoom(r3);
		s4.setCurrentRoom(r6);
		s5.setCurrentRoom(r15);
		a.setCurrentRoom(r1);
		d.setCurrentRoom(r14);
		a.reset();
}


	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
