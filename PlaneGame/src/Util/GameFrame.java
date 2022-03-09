package Util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class GameFrame extends Frame{
	//Image img=GameUtil.getImage("images/smile.jpg");
	public void LauchFrame()
	{
		setSize(Constant.Game_Width,Constant.Game_Height);
		//setLocation(200,200);
		setVisible(true);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e) 
			{
				System.exit(0);
			}	
		});
		new PaintThread().start();
	}
	
	class PaintThread extends Thread
	{
		public void run()
		{
			while(true)
			{
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		}
	}
	private Image offScreenImage=null;
	public void update(Graphics g)
	{
		if(offScreenImage==null)
			offScreenImage=this.createImage(Constant.Game_Width,Constant.Game_Height);
		Graphics goff=offScreenImage.getGraphics();
		paint(goff);
		g.drawImage(offScreenImage,0,0,null);
	}
}
