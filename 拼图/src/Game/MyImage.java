package Game;

import java.awt.Graphics;
import java.awt.Image;

public class MyImage {

	public int width=600;
	public int height=450;
	int x,y;
	int imagenumber;//正确的图序
	Image img;
	int i,j;
	public MyImage(int x,int y,int image){
		
		this.x=x;
		this.y=y;
		j=(x-8)/200;
		i=(y-30)/150;
		imagenumber=image;
	}
	public void draw(Graphics g){
		switch(imagenumber){
		
		case 0:break;
		case 1:g.drawImage(GameUtil.getimage("image/26-1.jpg"), x, y, null);break;
		case 2:g.drawImage(GameUtil.getimage("image/26-2.jpg"), x, y, null);break;
		case 3:g.drawImage(GameUtil.getimage("image/26-3.jpg"), x, y, null);break;
		case 4:g.drawImage(GameUtil.getimage("image/26-4.jpg"), x, y, null);break;
		case 5:g.drawImage(GameUtil.getimage("image/26-5.jpg"), x, y, null);break;
		case 6:g.drawImage(GameUtil.getimage("image/26-6.jpg"), x, y, null);break;
		case 7:g.drawImage(GameUtil.getimage("image/26-7.jpg"), x, y, null);break;
		case 8:g.drawImage(GameUtil.getimage("image/26-8.jpg"), x, y, null);break;//这里可以给文件名加变量最后就不要这么多函数名了
		default:break;
		}
	}
	public boolean getboolean(){
		int k=i*3+j;
		if(k<6) 
			k=k+1;//下表加一处理
		else if(k==6)
			k=0;//空位
		if(k==imagenumber)
			return true;
		else 
			return false;
	}
}
