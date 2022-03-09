package Solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import Util.GameUtil;

public class Planet extends Star {
	double longAxis,shortAxis;
	double speed;
	Star center;
	double degree;
	boolean satellite;
	public Planet(String imagepath, double longAxis,
			double shortAxis, double speed, Star center) {
		super(GameUtil.getImage(imagepath));
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		this.center = center;
		this.x=center.x+longAxis;
		this.y=center.y+shortAxis;
	}
	public Planet(String imagepath, double longAxis,
			double shortAxis, double speed, Star center,boolean satellite) {
		this(imagepath, longAxis, shortAxis, speed, center);
		this.satellite=satellite;
	}
	public Planet(double x, double y, Image img) {
		super(x, y, img);
		
	}
	public Planet(double x, double y, String imgpath) {
		super(x, y, imgpath);
		
	}
	
	public void draw(Graphics g)
	{
		super.draw(g);
		move();
		if(!satellite)
			drawTrace(g);
	}
	public void drawTrace(Graphics g)
	{
		double ovalx=(center.x+center.width/2)-longAxis,ovaly=(center.y+center.height/2)-shortAxis,ovalwidth=2*longAxis,ovalheight=2*shortAxis;
		Color c=g.getColor();
		g.setColor(Color.BLUE);
		g.drawOval((int)ovalx,(int) ovaly,(int) ovalwidth,(int) ovalheight);
		g.setColor(c);
	}
	private void move()
	{
		x=center.x+center.width/2+longAxis*Math.cos(degree+=speed);
		y=center.y+center.height/2+shortAxis*Math.sin(degree+=speed);
	}

}
