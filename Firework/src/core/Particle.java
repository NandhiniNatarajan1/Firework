package core;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Particle {

  float x;
  float y;
  float xSpeed;
  float ySpeed;
  float gravity;
  boolean isExpired;
  
	Particle(float x, float y,float gr,float xs, float ys)
	{
		this.x = x;
		this.y = y;
    xSpeed = xs;
    ySpeed = ys;
    gravity = gr;
    isExpired = false;

	}
	
  void update()
  { 
  }

  void render(Graphics g)
  {
	  
  }
  public float getRandomNumberBetween(int min, int max){
	    return (int) Math.floor(Math.random()*(max-min+1)+min);
	}
  
}
