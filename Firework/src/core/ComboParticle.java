package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class ComboParticle extends Particle{

	   ComboParticle(float x, float y,float gr,float xs,float ys){
		  super(x,y,gr,xs,ys);
		}
		void render(Graphics g){

			g.setColor(new Color (100,25,34));
			g.fillRect(x, y, 10,10);
			g.setColor(new Color (0, 75, 150));
		    g.fillRect(x+ 10,y - 10,20,20);
		  }
		  void update (){
		    x = x + getRandomNumberBetween(-10,10);
		   
		   y = y + ySpeed;
		   x = x + xSpeed;
		   ySpeed = ySpeed + gravity; 
//		   if (x > Main.getScreenWidth()) {
//			    y = my;
//				x = mx ;
//				xSpeed =  -1 * xSpeed;
//			}
//			if ( y > Main.getScreenHeight()) {
//				 y = my;
//				 x = mx;
//				 ySpeed = -1 * ySpeed;
//			}
		   
		   if (x > Main.getScreenWidth() || y > Main.getScreenHeight()) {
				isExpired = true;
		    }
		  }
	
}
