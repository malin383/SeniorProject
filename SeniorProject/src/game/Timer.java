package game;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Timer extends JFrame{
	
	public Timer(){
		initUI();
	}
	
	private void initUI(){
		
		add(new Game());
		
		setResizable(false);
		pack();
		
		setTitle("Test");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            
            public void run() {                
                JFrame ex = new Timer();
                ex.setVisible(true);                
            }
        });
	}

}
