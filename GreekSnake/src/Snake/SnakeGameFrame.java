package Snake;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;


public class SnakeGameFrame extends GameFrame{
	Image img=GameUtil.getImage("images/bg.jpg");
	Snake s=new Snake();
	/*public SnakeGameFrame(){
		
		Direction=south; 
		headx=10;heady=4;
		tailx=10;taily=0;
    	for(int i=0;i<5;i++)
    	{
    		fillblock[10][i]=south;
    	}
	}
	int headx,heady,tailx,taily,tail,foodx,foody,food,sfood;
	int[][] fillblock= new int[20][20];
	int Direction;
	final int north=1,south=2,west=3,east=4;*/
	public void LauchFrame()
	{
		super.LauchFrame();
		addKeyListener(new KeyMonitor());
	}
	public static void main (String[] args)
	{
		new SnakeGameFrame().LauchFrame();
	}
	public void paint(Graphics g)
	{
	g.drawImage(img, 0, 0, null);
	s.move();
	s.foodLocation();
	s.draw(g);
	/*	g.drawImage(img, 0, 0, null);
		if(sfood==0)
		{
			do
			{
				Random r =new Random();
				foodx=r.nextInt(20);
				foody=r.nextInt(20);
				sfood=1;
			}while(fillblock[foodx][foody]!=0);
		}
		if(headx>19||headx<1||heady>19||heady<1)
		System.exit(0);
		fillblock[headx][heady]=Direction;
		switch(Direction)
		{
			case 1: heady--;break;
			case 2: heady++;break;
			case 3: headx--;break;
			case 4: headx++;break;
		}
		
		System.out.println(fillblock[headx][heady]+" "+fillblock[tailx][taily]+" "+tailx+" "+taily+" "+tail+" "+Direction+" "+headx+" "+heady+" "+food);
		
		if(food<1)
		{
			tail=fillblock[tailx][taily];
			fillblock[tailx][taily]=0;
			switch(tail)
			{
				case 1: taily--;break;
				case 2: taily++;break;
				case 3: tailx--;break;
				case 4: tailx++;break;
			}
		}
		else 
		{
			food--;
		}
		for(int i=0;i<20;i++)
			for(int j=0;j<20;j++)
				if(fillblock[i][j]!=0)
				{
					Color c=g.getColor();
					g.setColor(Color.BLUE);
					g.drawRect(i*25, j*25, 24, 24);
					g.setColor(c);
				}
		Color c=g.getColor();
		g.setColor(Color.RED);
		g.drawRect(foodx*25, foody*25, 24, 24);
		g.setColor(c);
		if(foodx==headx&&foody==heady)
		{
			sfood=0;
			food=2;
		}*/
	}
 
    
    class KeyMonitor extends KeyAdapter
    {

		@Override
		public void keyPressed(KeyEvent e) {
			/*switch(e.getKeyCode())
			{
				case KeyEvent.VK_UP : if(Direction!=south)Direction=north;break;
				case KeyEvent.VK_DOWN : if(Direction!=north)Direction=south;break;
				case KeyEvent.VK_LEFT : if(Direction!=east)Direction=west;break;
				case KeyEvent.VK_RIGHT : if(Direction!=west)Direction=east;break;
			}*/
			s.KeyCOntral(e);
		}
    	
    }
    
}
