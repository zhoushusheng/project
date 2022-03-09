package Solar;

import java.awt.Graphics;
import java.awt.Image;

import Util.Constant;
import Util.GameFrame;
import Util.GameUtil;

public class SolarFrame extends GameFrame{
	Image bg=GameUtil.getImage("images/bg.jpg");
	Star sun=new Star(Constant.Game_Width/2,Constant.Game_Height/2,"images/solar.jpg");
	Planet mercury=new Planet("images/mercury.jpg",50,50,0.15,sun);
	Planet venus=new Planet("images/venus.jpg",100,70,0.08,sun);
	Planet earth=new Planet("images/earth.jpg",140,120,0.07,sun);
	Planet moon=new Planet("images/moon.jpg",25,25,0.5,earth,true);
	Planet mars=new Planet("images/mars.jpg",200,140,0.05,sun);
	Planet jupiter=new Planet("images/jupiter.jpg",260,180,0.03,sun);
	Planet saturn=new Planet("images/saturn.png",360,240,0.03,sun);
	Planet uranus=new Planet("images/uranus.png",430,340,0.02,sun);
	Planet neptune=new Planet("images/neptune.jpg",530,530,0.01,sun);
	public void paint(Graphics g)
	{
		g.drawImage(bg,0,20,null);
		sun.draw(g);
		mercury.draw(g);
		venus.draw(g);
		earth.draw(g);
		moon.draw(g);
		mars.draw(g);
		jupiter.draw(g);
		saturn.draw(g);
		uranus.draw(g);
		neptune.draw(g);
	}
	public static void  main(String[] args)
	{
		SolarFrame gf=new SolarFrame();
		gf.LauchFrame();
	}
}
