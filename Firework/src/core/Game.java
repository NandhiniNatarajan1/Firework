package core;

import java.awt.Font;
import org.newdawn.slick.Color;
//import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.Collections;

import org.lwjgl.input.Mouse;

public class Game extends BasicGameState 
{	
	private int id;
	private ArrayList<Particle> comboParticles;
	private ArrayList<Particle> rectParticles;
	private ArrayList<Particle> circleParticles;
	Font font;
	TrueTypeFont ttf;
	public Game(int id) 
	{
		this.id = id;
	}
	
	public int getID() 
	{
		return id;		
	}
	
	
	public ArrayList<Particle> getComboParticles() {
		
		return comboParticles;
	}

	public void setComboParticles(ArrayList<Particle> comboParticles) {
		this.comboParticles = comboParticles;
	}

	public ArrayList<Particle> getRectParticles() {
		return rectParticles;
	}

	public void setRectParticles(ArrayList<Particle> rectParticles) {
		this.rectParticles = rectParticles;
	}

	public ArrayList<Particle> getCircleParticles() {
		return circleParticles;
	}

	public void setCircleParticles(ArrayList<Particle> circleParticles) {
		this.circleParticles = circleParticles;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		// This code happens when you enter a game state for the *first time.*
		gc.setShowFPS(true);
		comboParticles = new ArrayList<Particle>();
	    rectParticles = new ArrayList<Particle>();
	    circleParticles = new ArrayList<Particle>();
	    font = new Font("Verdana", Font.BOLD, 20);
	    ttf = new  TrueTypeFont(font,true);
	    
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{	
	
			for (Particle cb : comboParticles) {
				cb.update(); 
			}

			for (Particle r : rectParticles) {
				r.update(); 
			}
		
			for (Particle c : circleParticles) {
				c.update(); 
			}
	
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
	{
		// This code renders shapes and images every frame.
		   //remove expired combo particles
			ArrayList<Integer> cbexpiredIndex = new ArrayList<Integer>();
	
			for (Particle cb : comboParticles) {
				if  (cb.isExpired) {
					cbexpiredIndex.add(comboParticles.indexOf(cb));
				}
			}
			Collections.sort(cbexpiredIndex, Collections.reverseOrder());  
			for(int j: cbexpiredIndex) {
				comboParticles.remove(j);
			}
			
			//render combo particles
			for (int i=0; i < comboParticles.size() ;i++) {
				comboParticles.get(i).render(g); 
				
				g.setColor(new Color(0xFFFFFF));
				ttf.drawString(20.0f,20.0f,"Count:  "+  comboParticles.size());
				
		    }
			
			//remove expired rect particles
			ArrayList<Integer> rexpiredIndex = new ArrayList<Integer>();
			
			for (Particle r : rectParticles) {
				if  (r.isExpired) {
					rexpiredIndex.add(rectParticles.indexOf(r));
				}
			}
			Collections.sort(rexpiredIndex, Collections.reverseOrder());  
			for(int j: rexpiredIndex) {
				rectParticles.remove(j);
			}
			//render rect particles
			for (Particle r : rectParticles) 
			{				
				r.render(g); 
				g.setColor(new Color(0xFFFFFF));
				ttf.drawString(20.0f,20.0f,"Count:  "+  rectParticles.size());
	
		    }
			//remove expired circle particles
			ArrayList<Integer> cexpiredIndex = new ArrayList<Integer>();
			
			for (Particle c : circleParticles) {
				if  (c.isExpired) {
					cexpiredIndex.add(circleParticles.indexOf(c));
				}
			}
			Collections.sort(cexpiredIndex, Collections.reverseOrder());  
			for(int j: cexpiredIndex) {
				circleParticles.remove(j);
			}
			//render circle particles
			for (Particle c : circleParticles) {				
				c.render(g); 
				g.setColor(new Color(0xFFFFFF));
				ttf.drawString(20.0f,20.0f,"Count:  "+  circleParticles.size());
		    }
	}
	
	public float getRandomNumberBetween(int min, int max){
	    return (float) Math.floor(Math.random()*(max-min+1)+min);
	}
	
	public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		// This code happens when you enter a gameState.  
	}

	public void leave(GameContainer gc, StateBasedGame sbg) 
	{
		// This code happens when you leave a gameState. 
	}

	public void keyPressed(int key, char c)
	{
		// This code happens every time the user presses a key
	}
	
	public void mousePressed(int button, int x, int y)
	{
		// This code happens every time the user presses the mouse
	  
		if(button == 0)
		{
				
			for (int i=0; i<100; i++) {
		   		comboParticles.add(new ComboParticle(x,y,(float).1,getRandomNumberBetween(-10,20),getRandomNumberBetween(-10,20))); 
		   }
			
		}
		if(button == 1)
		{
			for (int i=0; i<100; i++) {
		   		rectParticles.add(new RectParticle(x,y,(float).1,getRandomNumberBetween(-10,20),getRandomNumberBetween(-10,20))); 
		   }
	

		}
		if(button == 2)
		{
			for (int i=0; i<100; i++) {
		   		circleParticles.add(new CircleParticle(x,y,(float).1,getRandomNumberBetween(-10,20),getRandomNumberBetween(-10,20))); 
		   }

		}
		
	}
}
