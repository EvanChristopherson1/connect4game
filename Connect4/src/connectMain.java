import java.awt.GridLayout;

import javax.swing.*;
public class connectMain extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int WINDOW_HEIGHT = 750;
	private static final int WINDOW_WIDTH = 800;
	private static final int COLUMNS = 7;
	private static final int ROWS = 6;
	private static final String PLAYER_1_SYMBOL = "Y";
	private static final String PLAYER_2_SYMBOL = "R";
	private static final int EMPTY_SPACE_VALUE = 0;
	private static final int PLAYER_1_VALUE = 1;
	private static final int PLAYER_2_VALUE = 2;
	private boolean run = true;
	private int[][] board = new int[ROWS][COLUMNS];
	
	public static void main(String[] args) {
		new connectMain();	
	}
	public connectMain() {
		this.setTitle("Connect 4");
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(ROWS, COLUMNS, 0, 0));
		this.setResizable(false);
		this.createContents();
	}
	public void createContents() {
		
	}
}
