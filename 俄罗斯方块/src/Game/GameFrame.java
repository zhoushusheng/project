package Game;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends Panel{

	int random;
	static int score;
	static boolean left,right,top;
	static int speed=1000;
	static Body body;
	Body nextbody;
	static MyRectangle[][] rect=new MyRectangle[10][23];
	static MyRectangle[][] rectangle=new MyRectangle[4][4];
	static boolean live=true;
	static double difficulty=1;
	public GameFrame(){
		this.setLayout(null);
		this.setSize(350, 500);
		this.setVisible(true);
		this.setLocation(0, 0);
		//this.setFocusable(true);
		//this.setTitle("俄罗斯方块");
		/*panel=new Panel(new BorderLayout());
		panel2=new Panel();
		panel.add(panel2, BorderLayout.EAST);
		button=new Button();
		panel2.add(button);
		this.add(panel);*/
		for(int i=0;i<10;i++){
			for(int j=0;j<23;j++){
				rect[i][j]=new MyRectangle((i+1)*20,j*20);
			}
		}
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				rectangle[i][j]=new MyRectangle((i+12)*20,(j+7)*20);
			}
		}
		body=new Body((int)(Math.random()*4));
		random=(int)(Math.random()*4);
		nextbody=new Body(random,body.colornumber%4);
		new PaintThread().start();
		//new MoveThread().start();
		/*this.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});*/
		this.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent e) {
				if(live){
					if(e.getKeyCode()==37){
						left=true;
						for(int i=(body.a%4)*4;i<(body.a%4)*4+4;i++){
							int x=body.array[i]/10;
							int y=body.array[i]%10;
							GameFrame.rect[body.headx+x][body.heady+y].k=0;
								if(body.headx+x-1<0||rect[body.headx+x-1][body.heady+y].k==2){
									left=false;
								}
						}
						if(left==true){
							body.headx--;
						}
						repaint();
					}
					if(e.getKeyCode()==38){
						top=true;
						for(int i=((body.a+1)%4)*4;i<((body.a+1)%4)*4+4;i++){
							int x=body.array[i]/10;
							int y=body.array[i]%10;
							if(body.headx+x>=0&&body.headx+x<=9)
							{
								if(body.heady+y>=23||GameFrame.rect[body.headx+x][body.heady+y].k==2){
									top=false;
								}
							}
						}
						if(top)
						{
							for(int i=(body.a%4)*4;i<(body.a%4)*4+4;i++){
								int x=body.array[i]/10;
								int y=body.array[i]%10;
								GameFrame.rect[body.headx+x][body.heady+y].k=0;
							}
							body.a++;
							repaint();
						}
					}
					if(e.getKeyCode()==39){
						right=true;
						for(int i=(body.a%4)*4;i<(body.a%4)*4+4;i++){
							int x=body.array[i]/10;
							int y=body.array[i]%10;
							GameFrame.rect[body.headx+x][body.heady+y].k=0;
							if(body.headx+x+1>=10||rect[body.headx+x+1][body.heady+y].k==2){
								right=false;
							}
						}
						if(right==true){
							body.headx++;
						}
						repaint();
					}
					if(e.getKeyCode()==40){
							speed=(int)(50/difficulty);
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==40){
					speed=1000;
				}
			}
		});
	}
	public void paint(Graphics g){
		//body.draw();
		body.draw();
		Font f=new Font("宋体",Font.BOLD,15);
		g.setFont(f);
		g.drawString("难度："+String.valueOf(6-(int)(difficulty/0.2)), 30, 50);
		g.drawString("得分："+String.valueOf(score*100), 130, 50);
		g.drawString("下个方块：", 240, 120);
		for(int i=0;i<10;i++){
			for(int j=3;j<23;j++){
				rect[i][j].draw(g);
			}
		}
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				rectangle[i][j].draw(g, Color.red);
			}
		}
		nextbody.draw2();
		for(int j=3;j<23;j++){
			boolean yes=true;
			for(int i=0;i<10;i++){
				if(rect[i][j].k!=2){
					yes=false;
				}
			}
			if(yes){
				score++;
				for(int p=j;p>3;p--){
					for(int i=0;i<10;i++){
						if(rect[i][p].k!=1&&rect[i][p-1].k!=1){
						rect[i][p].k=rect[i][p-1].k;
						}
					}
				}
			}
		}
		if(!live){
			Font font=new Font("宋体",Font.BOLD,40);
			g.setFont(font);
			g.drawString("游戏结束", 40, 230);
			font=new Font("宋体",Font.BOLD,20);
			g.setFont(font);
			g.drawString("游戏得分："+String.valueOf(score*100),50, 270);
		}
	}
	/*private Image off = null;
	public void update(Graphics g)
	{
		if(off == null)
			off = this.createImage(240, 500);
		
		Graphics goff=off.getGraphics();
		paint(goff);
		g.drawImage(off, 0, 0, null);
	}*/
	/*class MoveThread extends Thread{
		
		public void run(){
			while(true){
				repaint();
				try {
					this.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}*/
	class PaintThread extends Thread{
		
		public void run(){
			while(live){
				boolean yes=false;
				for(int i=(body.a%4)*4;i<(body.a%4)*4+4;i++){
					int x=body.array[i]/10;
					int y=body.array[i]%10;
					if(body.heady+y+1>=23||GameFrame.rect[body.headx+x][body.heady+y+1].k==2){
						yes=true;
					}
				}
				if(yes){
					for(int i=(body.a%4)*4;i<(body.a%4)*4+4;i++){
						int x=body.array[i]/10;
						int y=body.array[i]%10;
						GameFrame.rect[body.headx+x][body.heady+y].k=2;
					}
					for(int i=0;i<10;i++){
						for(int j=0;j<4;j++){
							if(rect[i][j].k==2){
								live=false;
							}
						}
					}
					if(live){
						body=new Body(random);
						random=(int)(Math.random()*4);
						nextbody=new Body(random,(body.colornumber)%4);
					}
				}
				body.move();
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
/*	class MoveThread extends Thread{
		
		public void run(){
			while(true){
				if(left==true||right==true||top==true){
					body.remove();
					repaint();
					try {
							this.sleep(100);
						}
					catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}*/
}
