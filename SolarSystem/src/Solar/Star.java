package Solar;

import java.awt.Graphics;
import java.awt.Image;

import Util.GameUtil;

public class Star 
{
	Image img;
	double x,y;
	double width,height;
	public void draw(Graphics g)
	{
		g.drawImage(img, (int)x, (int)y, null);
	}
	public Star(Image img)
	{
		this.img=img;
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
	}
	public Star(double x,double y,Image img)
	{
		this(img);
		this.x=x;
		this.y=y;
		
	}
	public Star(double x,double y,String imgpath)
	{
		this((int)x,(int)y,GameUtil.getImage(imgpath));
	}
	public Star(){}
}
