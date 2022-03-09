package plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import Util.Constant;
import Util.GameUtil;

public class Plane extends GameObject{
	
	private boolean live=true;
	double x,y;
	private boolean left,up,right,down;
	public Rectangle getRect()
	{
		return new Rectangle((int)x,(int)y,width,height);
	}
	public void draw(Graphics g)
	{
		if(live)
		{
				g.drawImage(img,(int)x,(int)y, null);
				move();
		}
	
	}
	public Plane(String imgpath, double x, double y) {
		super();
		this.img =GameUtil.getImage("images/earth.jpg");
		this.x = x;
		this.y = y;
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
		speed=10;
	}
	public void addDirection(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_LEFT:
				left=true;
				break;
			case KeyEvent.VK_UP:
				up=true;
				break;
			case KeyEvent.VK_RIGHT:
				right=true;
				break;
			case KeyEvent.VK_DOWN:
				down=true;
				break;
			default:;
		}
	}
	public void minusDirection(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_LEFT:
				left=false;
			break;
			case KeyEvent.VK_UP:
				up=false;
			break;
			case KeyEvent.VK_RIGHT:
				right=false;
			break;
			case KeyEvent.VK_DOWN:
				down=false;
			break;
			default:;
		}
	}
	public void move()
	{
		if(left&&x>=0)
			x-=speed;
		if(right&&x<Constant.Game_Width-width)
			x+=speed;
		if(up&&y>=0)
			y-=speed;
		if(down&&y<Constant.Game_Height-height)
			y+=speed;
	}
	public Plane(){}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	
}
