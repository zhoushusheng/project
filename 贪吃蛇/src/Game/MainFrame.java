package Game;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends Frame{

	GameFrame panel;
	Panel panel2;
	Button button,button2,button3;
	Label label;
	public MainFrame(){
		this.setSize(440,360);
		this.setLocation(0, 0);
		this.setVisible(true);
		this.setLayout(null);
		panel=new GameFrame();
		panel2=new Panel();
		panel2.setLayout(null);
		panel2.setBounds(340,200,100,160);
		button=new Button("重新开始");
		button2=new Button("提高难度");
		button3=new Button("降低难度");
		button.setBounds(0, 0, 80, 30);
		button2.setBounds(0, 50, 80, 30);
		button3.setBounds(0, 100, 80, 30);
		panel2.add(button);
		panel2.add(button2);
		panel2.add(button3);
		/*label=new Label("sadsad");
		Font f=new Font("宋体",Font.BOLD,10);
		label.setFont(f);
		label.
		panel2.add(label);*/
		panel.add(panel2);
		this.add(panel);
		panel.requestFocus();
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosed(e);
				System.exit(0);
			}
		});
		/*this.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent e) {
				GameFrame.snake.move(e);
			}
		});*/
		button.addActionListener(new Action());
		button2.addActionListener(new Action());
		button3.addActionListener(new Action());
	}
	class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() instanceof Button){
				Button b=(Button)e.getSource();
				if(b.getLabel().equals("重新开始")){
					if(panel.snake.live==false){
						panel.new PaintThread().start();
					}
					panel.snake=new Snake();
					System.out.println(b.getLabel());
					panel.difficulty=1;
				}
				if(b.getLabel().equals("提高难度")){
					if(panel.difficulty>0.5){
						panel.difficulty-=0.2;
					}
				}
				if(b.getLabel().equals("降低难度")){
					if(panel.difficulty<0.9){
						panel.difficulty+=0.2;
					}
				}
			}
			panel.requestFocus();
		}
		
	}
}
