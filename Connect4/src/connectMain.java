import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class connectMain extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int Window_Height = 750;
	private static final int Window_Width = 800;
	private static final int Cols = 7;
	private static final int Rows = 6;
	private static final Color BackgroundColor = Color.gray;
	private static final Color Player_1_Color = Color.red;
	private static final Color Player_2_Color = Color.yellow;
	private static final int Empty_Space_Value = 0;
	private static final int Player_1_Value = 1;
	private static final int Player_2_Value = 2;
	private boolean run = true;
	private int[][] board = new int[Rows][Cols];
	
	public static void main(String[] args) {
		new connectMain();	
	}
	public connectMain() {
		this.setTitle("Connect 4");
		this.setSize(Window_Width, Window_Height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(Rows, Cols, 0, 0));
		this.setResizable(false);
		this.makeBoard();
		this.setVisible(true);
	}
	public void makeBoard() {
		for(int r = 0;r<Rows;r++) {
			for(int c = 0;c<Cols;c++) {
				board[r][c] = 0;
				NewJButton b = new NewJButton(r, c);
				b.addActionListener(new MyAction());
				this.add(b);
			}
		}
	}
	private class MyAction implements ActionListener{
	    public void actionPerformed(ActionEvent event){
	    	
	    }
	}
}
