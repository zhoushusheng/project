package plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import Util.GameFrame;
import Util.GameUtil;

public class PlaneGameFrame extends GameFrame{
	Image bg=GameUtil.getImage("images/bg.jpg");
	
	Plane p=new Plane("images/earth.jpg",50,50);
	ArrayList bulletlist=new ArrayList();
	Date starTime,endTime;
	Explode bang;
	public void paint(Graphics g)
	{
		g.drawImage(bg,0,0,null);
		p.draw(g);
		for(int i=0;i<bulletlist.size();i++)
		{
			Bullet b=(Bullet)bulletlist.get(i);
			b.draw(g);
			boolean boom=b.getRect().intersects(p.getRect());
			if(boom)
			{
				if(p.isLive())
					endTime=new Date();
				p.setLive(false);
				
				if(bang==null)
					bang=new Explode(p.x,p.y);
				bang.draw(g);
			}
		}
		if(!p.isLive())
		{
			printInfo(g,"Game Over",50,100,200,Color.white);
			int peroid=(int)(endTime.getTime()-starTime.getTime())/1000;
			printInfo(g,"survive time:"+peroid,30,50,400,Color.BLUE);
			switch(peroid/10)
			{
			case 10:
			case 9:
			case 8:
			case 7:
			case 6:
			case 5:
			case 4:
			case 3:
				printInfo(g,"good",20,50,500,Color.BLUE); break;
			case 2:
			case 1:
				printInfo(g," Just so so",20,50,500,Color.BLUE); break;
			case 0:
				printInfo(g,"so bad",20,50,500,Color.BLUE); break;
			default:;
			}
		}
		printInfo(g,"·ÖÊý:",10,50,50,Color.BLUE);
	}
	public void printInfo(Graphics g ,String str,int size,int x,int y,Color color)
	{
	
			Color c=g.getColor();
			g.setColor(color);
			Font f=new Font("ºÚÌå",Font.BOLD,size);
			g.setFont(f);
			g.drawString(str,x,y);
			g.setColor(c);
	}
	public static void main(String[] agrs)
	{
		new PlaneGameFrame().LauchFrame();
	}
	public void LauchFrame()
	{
		super.LauchFrame();
		addKeyListener(new KeyMonitor());
		for(int i=0;i<10;i++)
		{
			Bullet b=new Bullet();
			bulletlist.add(b);
		}
		starTime =new Date();
	}
	class KeyMonitor extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e) {
			
			//System.out.println("press"+e.getKeyCode());
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			//System.out.println("release"+e.getKeyCode());
			p.minusDirection(e);
		}
	}

}
