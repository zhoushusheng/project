package Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Snake {
	int headx,heady,tailx,taily,tail,foodx,foody,food,sfood;
	int[][] fillblock= new int[20][20];
	int Direction;
	final int north=1,south=2,west=3,east=4;
	public Snake()
	{
		Direction=south; 
		headx=10;heady=4;
		tailx=10;taily=0;
    	for(int i=0;i<5;i++)
    	{
    		fillblock[10][i]=south;
    	}
	}
	public void move()
	{
		
		
		fillblock[headx][heady]=Direction;
		
		switch(Direction)
		{
			case 1: heady--;break;
			case 2: heady++;break;
			case 3: headx--;break;
			case 4: headx++;break;
		}
		if(headx>19||headx<1||heady>19||heady<1||fillblock[headx][heady]!=0)
			System.exit(0);
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
		
		if(foodx==headx&&foody==heady)
		{
			sfood=0;
			food=2;
		}
	}
	public void draw(Graphics g)
	{
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
	}
	public void foodLocation()
	{
		if(sfood==0)
		{
			do
			{
				Random r =new Random();
				foodx=r.nextInt(20);
				foody=r.nextInt(20);
				sfood=1;
			}while(fillblock[foodx][foody]!=0&&foody>1);
		}
	}
	public void KeyCOntral(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_UP : if(Direction!=south)Direction=north;break;
			case KeyEvent.VK_DOWN : if(Direction!=north)Direction=south;break;
			case KeyEvent.VK_LEFT : if(Direction!=east)Direction=west;break;
			case KeyEvent.VK_RIGHT : if(Direction!=west)Direction=east;break;
		}
	}
}
