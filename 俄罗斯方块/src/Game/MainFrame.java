package Game;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Game.GameFrame.PaintThread;

public class MainFrame extends Frame{

	Button button,button2,button3;
	//Panel panel;
	Panel panel2;
	GameFrame panel;
	public MainFrame(){
		this.setSize(350, 500);
		this.setVisible(true);
		this.setLocation(0, 0);
		this.setTitle("俄罗斯方块");
		this.setLayout(null);
		this.requestFocus();
		button=new Button("重新开始");
		button.setBounds(240, 300, 80, 30);
		button2=new Button("提高难度");
		button2.setBounds(240, 350, 80, 30);
		button3=new Button("降低难度");
		button3.setBounds(240, 400, 80, 30);
		panel=new GameFrame();
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
		//panel.add(button2);
		this.add(panel);
		this.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		button.addActionListener(new Action());
		button2.addActionListener(new Action());
		button3.addActionListener(new Action());
		this.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent e) {
				if(GameFrame.live){
					if(e.getKeyCode()==37){
						GameFrame.left=true;
						for(int i=(GameFrame.body.a%4)*4;i<(GameFrame.body.a%4)*4+4;i++){
							int x=GameFrame.body.array[i]/10;
							int y=GameFrame.body.array[i]%10;
							GameFrame.rect[GameFrame.body.headx+x][GameFrame.body.heady+y].k=0;
								if(GameFrame.body.headx+x-1<0||GameFrame.rect[GameFrame.body.headx+x-1][GameFrame.body.heady+y].k==2){
									GameFrame.left=false;
								}
						}
						if(GameFrame.left==true){
							GameFrame.body.headx--;
						}
						panel.repaint();
					}
					if(e.getKeyCode()==38){
						GameFrame.top=true;
						for(int i=((GameFrame.body.a+1)%4)*4;i<((GameFrame.body.a+1)%4)*4+4;i++){
							int x=GameFrame.body.array[i]/10;
							int y=GameFrame.body.array[i]%10;
							if(GameFrame.body.headx+x>=0&&GameFrame.body.headx+x<=9)
							{
								if(GameFrame.body.heady+y>=23||GameFrame.rect[GameFrame.body.headx+x][GameFrame.body.heady+y].k==2){
									GameFrame.top=false;
								}
							}
						}
						if(GameFrame.top)
						{
							for(int i=(GameFrame.body.a%4)*4;i<(GameFrame.body.a%4)*4+4;i++){
								int x=GameFrame.body.array[i]/10;
								int y=GameFrame.body.array[i]%10;
								GameFrame.rect[GameFrame.body.headx+x][GameFrame.body.heady+y].k=0;
							}
							GameFrame.body.a++;
							panel.repaint();
						}
					}
					if(e.getKeyCode()==39){
						GameFrame.right=true;
						for(int i=(GameFrame.body.a%4)*4;i<(GameFrame.body.a%4)*4+4;i++){
							int x=GameFrame.body.array[i]/10;
							int y=GameFrame.body.array[i]%10;
							GameFrame.rect[GameFrame.body.headx+x][GameFrame.body.heady+y].k=0;
							if(GameFrame.body.headx+x+1>=10||GameFrame.rect[GameFrame.body.headx+x+1][GameFrame.body.heady+y].k==2){
								GameFrame.right=false;
							}
						}
						if(GameFrame.right==true){
							GameFrame.body.headx++;
						}
						panel.repaint();
					}
					if(e.getKeyCode()==40){
						GameFrame.speed=50;
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==40){
					GameFrame.speed=1000;
				}
			}
		});
	}
	class Action implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() instanceof Button){
				Button b=(Button)e.getSource();
				if(b.getLabel().equals("重新开始")){
					if(GameFrame.live==false){
						panel.new PaintThread().start();
					}
					GameFrame.live=true;
					GameFrame.score=0;
					for(int i=0;i<10;i++){
						for(int j=0;j<23;j++){
							GameFrame.rect[i][j]=new MyRectangle((i+1)*20,j*20);
						}
					}
					GameFrame.body=new Body((int)(Math.random()*4));
					panel.requestFocus();
				}
				if(b.getLabel().equals("提高难度")){
					if(GameFrame.difficulty>0.3){
						GameFrame.difficulty-=0.2;
					}
					panel.requestFocus();
				}
				if(b.getLabel().equals("降低难度")){
					if(GameFrame.difficulty<0.9){
						GameFrame.difficulty+=0.2;
					}
					panel.requestFocus();
				}
			}
		}
	}
}
