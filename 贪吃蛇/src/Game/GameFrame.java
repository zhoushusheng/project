package Game;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends Panel{


	static MyRectangle[][] rect=new MyRectangle[30][30];
	static Snake snake;
	Food food;
	double difficulty=1;
	int speed=250;
	int score=0;
	Thread thread;
	/*Button button;
	Button button2;
	Button button3;*/
	public GameFrame(){
		
		this.setSize(440,360);
		this.setVisible(true);
		this.setLocation(0,0);
		this.setLayout(null);
		/*button=new Button("重新开始");
		button2=new Button("提高难度");
		button3=new Button("降低难度");
		button.setBounds(340, 200, 80, 30);
		button2.setBounds(340, 250, 80, 30);
		button3.setBounds(340, 300, 80, 30);
		this.add(button);
		this.add(button2);
		this.add(button3);*/
		//this.requestFocus();
		for(int i=0;i<30;i++){
			for(int j=0;j<30;j++){
				rect[i][j]=new MyRectangle((i+2)*10,(j+4)*10);
			}
		}
		snake=new Snake();
		food=new Food();
		food.rand();
		/*for(int i=0;i<1;i++){
			for(int j=0;j<4;j++){
				rect[i][j].setfillColor(Color.gray);
			}
		}*/
		this.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent e) {
				snake.move(e);
				//System.out.println(snake.left);
			}
		});
	/*	this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosed(e);
				System.exit(0);
			}
		});*/
		thread=new PaintThread();
		thread.start();
		}
	public void paint(Graphics g){
	/*	for(int i=0;i<1;i++){
			for(int j=0;j<4;j++){
				rect[i][j].fill(g);
			}
		}*/
		for(int i=0;i<30;i++){
			for(int j=0;j<30;j++){
				rect[i][j].draw(g);
				//rect[i][j].fill(g);
			}
		}
		snake.remove();
		snake.draw(g);
		food.draw(g);
		if(snake.live==false){
			Font font=new Font("宋体",Font.BOLD,60);
			g.setFont(font);
			g.drawString("GAME OVER", 20, 200);
		}
		if(food.food.getRect().intersects(snake.snake.get(snake.snake.size()-1).getRect())){
			snake.growup();
			food.rand();
			score++;
		}
		Font font=new Font("宋体",Font.BOLD,12);
		g.setFont(font);
		g.drawString("分数："+String.valueOf(score*100), 340, 80);
		g.drawString("难度："+String.valueOf((int)(5-(difficulty-0.0001)/0.2)), 340, 120);
		//g.drawString("速度："+String.valueOf((int)(speed*difficulty)), 340, 160);
	}
	
	/*private Image off=null;
	public void update(Graphics g){
		if(off==null){
			off=this.createImage(340, 360);
		}
		paint(off.getGraphics());
		g.drawImage(off, 0, 0, null);
	}*/
	
	class PaintThread extends Thread{
		
		public void run(){
			while(snake.live)
			{
			repaint();
			try {
				this.sleep((int)(speed*difficulty));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}
	
}
