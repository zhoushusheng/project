package Game;

import java.awt.Color;
import java.awt.Graphics;

public class Food {

	MyRectangle food;
	public void rand(){
		food=GameFrame.rect[(int)(Math.random()*30)][(int)(Math.random()*30)];
		for(MyRectangle x:GameFrame.snake.snake){
			if(food.x==x.x&&food.y==x.y){
				rand();
			}
		}
	}
	public void draw(Graphics g){
		Color c=g.getColor();
		g.setColor(Color.gray);
		g.fillRect((int)food.x,(int)food.y, 10, 10);
		g.setColor(c);
	}
}
