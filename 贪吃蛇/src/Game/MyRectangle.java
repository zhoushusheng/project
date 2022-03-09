package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MyRectangle {

	Color RectangleColor=Color.gray;
	double x=0;
	double y=0;
	public MyRectangle(double x,double y){
		this.x=x;
		this.y=y;
	}
	public void draw(Graphics g){
		Color c=g.getColor();
		g.setColor(RectangleColor);
		g.drawRect((int)x, (int)y, 10, 10);
		g.setColor(c);
	}
	public void setRectangleColor(Color c){
		RectangleColor=c;
	}
	public Rectangle getRect(){
		
		return new Rectangle((int)x,(int)y,10,10);
	}
}
