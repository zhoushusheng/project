package Game;

import java.awt.Color;
import java.awt.event.KeyEvent;

public class Body {

	int headx=3;
	int heady=0;
	int[] array;
	int a=0;
	Color c;
	static int colornumber=0;
	public Body(int k){
		switch((int)(colornumber++%4)){
		case 0:c=Color.blue;break;
		case 1:c=Color.green;break;
		case 2:c=Color.red;break;
		case 3:c=Color.yellow;break;
		}
		if(k==0){
			array=new int[]{10,11,12,13,2,12,22,32,10,11,12,13,2,12,22,32};
		}
		if(k==1){
			array=new int[]{11,12,21,22,11,12,21,22,11,12,21,22,11,12,21,22};
		}
		if(k==2){
			array=new int[]{1,11,21,12,10,11,12,21,10,1,11,21,1,10,11,12};
		}
		if(k==3){
			array=new int[]{10,11,12,22,1,11,21,20,0,10,11,12,2,10,11,12};
		}
	}
	public Body(int k,int color){
		switch((int)color){
		case 0:c=Color.blue;break;
		case 1:c=Color.green;break;
		case 2:c=Color.red;break;
		case 3:c=Color.yellow;break;
		}
		if(k==0){
			array=new int[]{10,11,12,13,2,12,22,32,10,11,12,13,2,12,22,32};
		}
		if(k==1){
			array=new int[]{11,12,21,22,11,12,21,22,11,12,21,22,11,12,21,22};
		}
		if(k==2){
			array=new int[]{1,11,21,12,10,11,12,21,10,1,11,21,1,10,11,12};
		}
		if(k==3){
			array=new int[]{10,11,12,22,1,11,21,20,0,10,11,12,2,10,11,12};
		}
	}
	public void draw(){
		for(int k=0;k<10;k++){
			for(int l=0;l<23;l++){
				if(GameFrame.rect[k][l].k==1){
					GameFrame.rect[k][l].k=0;
				}
			}
		}
			for(int i=(a%4)*4;i<(a%4)*4+4;i++){
				int x=array[i]/10;
				int y=array[i]%10;
//				if(headx+x<0)
//				{
//					headx=headx-headx-x;
//				}
//				if(headx+x>9)
//				{
//					headx=headx-(headx+x-9);
//				}
					GameFrame.rect[headx+x][heady+y].color=c;
					GameFrame.rect[headx+x][heady+y].k=1;
			}
		/*for(int i=0;i<4;i++){
			body[i].k=1;
		}*/
	}
	public void draw2(){
		headx=0;
		for(int k=0;k<4;k++){
			for(int l=0;l<4;l++){
				if(GameFrame.rectangle[k][l].k==1){
					GameFrame.rectangle[k][l].k=0;
				}
			}
		}
			for(int i=(a%4)*4;i<(a%4)*4+4;i++){
				int x=array[i]/10;
				int y=array[i]%10;
//				if(headx+x<0)
//				{
//					headx=headx-headx-x;
//				}
//				if(headx+x>9)
//				{
//					headx=headx-(headx+x-9);
//				}
					GameFrame.rectangle[headx+x][heady+y].color=c;
					GameFrame.rectangle[headx+x][heady+y].k=1;
			}
		/*for(int i=0;i<4;i++){
			body[i].k=1;
		}*/
	}
	
	public void move(){
		if(GameFrame.live){
			for(int i=(a%4)*4;i<(a%4)*4+4;i++){
				int x=array[i]/10;
				int y=array[i]%10;
				GameFrame.rect[headx+x][heady+y].k=0;
			}
			heady++;
		}
	}
/*	public void remove(){
		if(GameFrame.left==true){
			for(int i=(a%4)*4;i<(a%4)*4+4;i++){
				int x=array[i]/10;
				int y=array[i]%10;
				GameFrame.rect[headx+x][heady+y].k=0;
			}
			headx--;
		}
		if(GameFrame.right==true){
			for(int i=(a%4)*4;i<(a%4)*4+4;i++){
				int x=array[i]/10;
				int y=array[i]%10;
				GameFrame.rect[headx+x][heady+y].k=0;
			}
			headx++;
		}
		if(GameFrame.top=true){
			for(int i=(a%4)*4;i<(a%4)*4+4;i++){
				int x=array[i]/10;
				int y=array[i]%10;
				GameFrame.rect[headx+x][heady+y].k=0;
			}
			a++;
		}
	}*/
}
