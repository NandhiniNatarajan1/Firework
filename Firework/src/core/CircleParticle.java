package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class CircleParticle extends Particle{

  CircleParticle(float x, float y,float gr,float xs,float ys){
  super(x,y,gr,xs,ys);
  }
  void render(Graphics g){
	  g.setColor(new Color(125, 50, 70));
      g.fillOval(x,y,10,10);
  }
  void update()
  { 
   x = x + xSpeed;
   y = y + ySpeed;
   ySpeed = ySpeed + gravity; 

 
   if (x > Main.getScreenWidth() || y > Main.getScreenHeight()) {
		isExpired = true;
    }
	   
  }

}
