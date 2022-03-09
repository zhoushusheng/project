package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameFrame extends Frame{

	int[] imgnumber=new int[9];
	MyImage[][] images=new MyImage[3][3];
	MyImage oldimage;
	public GameFrame(){
		this.setSize(608, 480);
		this.setVisible(true);
		this.setLocation(0, 0);
		for(int i=0;i<9;i++){
			imgnumber[i]=(int)(Math.random()*9);
			for(int j=0;j<i;j++){
				if(imgnumber[i]==imgnumber[j]){
					i--;//判断随机是否重复 若重复则回去重新随机
				}
			}
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++)
			{
				images[i][j]=new MyImage(j*200+8,i*150+30,imgnumber[i*3+j]);/*匹配到图盘*/
			}
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++)
			{
				if(images[i][j].imagenumber==0){//为空换到2 、0 位置
					images[i][j].imagenumber=images[2][0].imagenumber;
					images[2][0].imagenumber=0;
				}
			}
		}
		oldimage=images[2][0];
		this.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);//没这个关闭不了窗口
			}
			
		});
		this.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent e) {
				if(oldimage.j!=2)//特殊情况 不为底
				{
					if(e.getKeyCode()==37){
						oldimage.imagenumber=images[oldimage.i][oldimage.j+1].imagenumber;
						images[oldimage.i][oldimage.j+1].imagenumber=0;
						oldimage=images[oldimage.i][oldimage.j+1];
					}
				}
				if(oldimage.j!=0)
				{
					if(e.getKeyCode()==39){
						oldimage.imagenumber=images[oldimage.i][oldimage.j-1].imagenumber;
						images[oldimage.i][oldimage.j-1].imagenumber=0;
						oldimage=images[oldimage.i][oldimage.j-1];
					}
				}
				if(oldimage.i!=2)
				{
					if(e.getKeyCode()==38){
						oldimage.imagenumber=images[oldimage.i+1][oldimage.j].imagenumber;
						images[oldimage.i+1][oldimage.j].imagenumber=0;
						oldimage=images[oldimage.i+1][oldimage.j];
					}
				}
				if(oldimage.i!=0)
				{
					if(e.getKeyCode()==40){
						oldimage.imagenumber=images[oldimage.i-1][oldimage.j].imagenumber;
						images[oldimage.i-1][oldimage.j].imagenumber=0;
						oldimage=images[oldimage.i-1][oldimage.j];
					}
				}
				//System.out.println(e.getKeyCode());
				repaint();
			}
		});
	}
	public void paint(Graphics g){
		boolean win=true;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++)
			{
				images[i][j].draw(g);
				if(images[i][j].getboolean()==false)
					win=false;
			}
		}
		if(win)
		{
			Font font=new Font("宋体",Font.BOLD,120);
			g.setFont(font);
			Color c=g.getColor();
			g.setColor(Color.red);
			g.drawString("WINER", 150, 300);
			g.setColor(c);
		}
	}
}
