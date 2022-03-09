package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Snake {

	boolean left,right,top;
	boolean down=true;
	boolean live=true;
	int headx=0;
	int heady=3;
	int endx=0;
	int endy=0;
	int oldheadx=headx;
	int oldheady=heady;
	List<MyRectangle> snake=new ArrayList();
	Color SnakeColor=Color.gray;
	MyRectangle rect;
	public  Snake(){
		for(int i=0;i<4;i++){
			snake.add(GameFrame.rect[0][i]);
		}
	}
	public void draw(Graphics g){
		List<Rectangle> rect=new ArrayList();
		for(MyRectangle x:snake){
			Color c=g.getColor();
			g.setColor(SnakeColor);
			g.fillRect((int)x.x, (int)x.y, 10, 10);
			g.setColor(c);
			rect.add(x.getRect());
		}
		for(int i=0;i<rect.size()-1;i++){
			if(rect.get(rect.size()-1).intersects(rect.get(i))){
				live=false;
			}
		}
	}
	public void move(KeyEvent e){
		if(oldheadx!=headx||oldheady!=heady){
			if(right==false){
				if(e.getKeyCode()==37){
					left=true;
					top=false;
					right=false;
					down=false;
				}	
			}
			if(down==false){
				if(e.getKeyCode()==38){
					left=false;
					top=true;
					right=false;
					down=false;
				}
			}
			if(left==false){
				if(e.getKeyCode()==39){
					left=false;
					top=false;
					right=true;
					down=false;
				}
			}
			if(top==false){
				if(e.getKeyCode()==40){
					left=false;
					top=false;
					right=false;
					down=true;
				}
			}
			oldheadx=headx;
			oldheady=heady;
		}
	}
	public void remove(){
		try{
			if(down==true){
				rect=snake.get(0);
				snake.remove(0);
				snake.add(GameFrame.rect[headx][++heady]);
			}
			if(top==true){
				rect=snake.get(0);
				snake.remove(0);
				snake.add(GameFrame.rect[headx][--heady]);
			}
			if(left==true){
				rect=snake.get(0);
				snake.remove(0);
				snake.add(GameFrame.rect[--headx][heady]);
			}
			if(right==true){
				rect=snake.get(0);
				snake.remove(0);
				snake.add(GameFrame.rect[++headx][heady]);
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			live=false;
		}
	}
	public void growup(){
		snake.add(0,rect);
	}
}
