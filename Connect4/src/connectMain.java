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
	private static final Color BackgroundColor = Color.LIGHT_GRAY;
	private static final Color Player_1_Color = Color.red;
	private static final Color Player_2_Color = Color.yellow;
	private static final int Empty_Space_Value = 0;
	private static final int Player_1_Value = 1;
	private static final int Player_2_Value = 2;
	private int Current_Player = 1;
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
				board[r][c] = Empty_Space_Value;
				NewJButton b = new NewJButton(r, c);
				b.addActionListener(new MyAction());
				b.setBackground(BackgroundColor);
				this.add(b);
			}
		}
	}
	public boolean checkWin(NewJButton b) {
		int c1 = down(b,Current_Player);
		int c2 = left(b,Current_Player);
		c1 = Math.max(c1, c2);
//		c1 = right(b,0,Current_Player);
//		c3 = Math.max(c1, c3);
//		c1 = upRight(b,0,Current_Player);
//		c3 = Math.max(c1, c3);
//		c1 = upLeft(b,0,Current_Player);
//		c3 = Math.max(c1, c3);
//		c1 = downRight(b,0,Current_Player);
//		c3 = Math.max(c1, c3);
//		c1 = downLeft(b,0,Current_Player);
//		c3 = Math.max(c1, c3);
		return c1==4;
	}
//	public int up(NewJButton b,int count,int player) {
//		if(count==3) return count;
//		System.out.print(b.Row+""+b.Col);
//		if(board[b.Row][b.Col]!=player) return 0;
//		count++;
//		int index = ((b.Row) * Rows) + (b.Row) - Cols;
//		if(index>=42||index<0) return 0;
//		System.out.print(index);
//		NewJButton j = (NewJButton) b.getParent().getComponent(index);
//		return count += up(j,count,player);
//	}
	public int down(NewJButton b,int player) {
		int count = 0;
		int check = b.Row;
		while(check<5&&check>=0) {
			if(count==4) break;
			if(board[check][b.Col]!=player) break;
			check++;
			count++;
		}
		return count;
	}
	public int left(NewJButton b,int player) {
		int count = 0;
		for(int check = b.Col;check>6&&check<0;check--) {
			if(count==4) break;
			if(board[b.Row][check]!=player) break;
			count++;
			System.out.print(count);
		}
		return count;
	}
//	public int right(NewJButton b,int player) {
//		int count = 0;
//		int check = b.Col;
//		while(check<6&&check>0) {
//			if(count==4) break;
//			if(board[b.Row][check]!=player) break;
//			check++;
//			count++;
//			System.out.print(count);
//		}
//		return count;
//	}
//	public int upRight(NewJButton b,int count,int player) {
//		if(count==3) return count;
//		if(board[b.Row][b.Col]!=player) return 0;
//		count++;
//		int index = ((b.Row) * Rows) + (b.Row) + 1;
//		if(index>=42||index<0) return 0;
//		NewJButton j = (NewJButton) b.getParent().getComponent(index);
//		return count += upRight(j,count,player);
//	}
//	public int upLeft(NewJButton b,int count,int player) {
//		if(count==3) return count;
//		if(board[b.Row][b.Col]!=player) return 0;
//		count++;
//		int index = ((b.Row) * Rows) + (b.Row) - 1;
//		if(index>=42||index<0) return 0;
//		NewJButton j = (NewJButton) b.getParent().getComponent(index);
//		return count += upLeft(j,count,player);
//	}
//	public int downRight(NewJButton b,int count,int player) {
//		if(count==3) return count;
//		if(board[b.Row][b.Col]!=player) return 0;
//		count++;
//		int index = ((b.Row) * Rows) + (b.Col) + (b.Row) + (b.Col) + 1;
//		if(index>=42||index<0) return 0;
//		NewJButton j = (NewJButton) b.getParent().getComponent(index);
//		return count += downRight(j,count,player);
//	}
//	public int downLeft(NewJButton b,int count,int player) {
//		if(count==3) return count;
//		if(board[b.Row][b.Col]!=player) return 0;
//		count++;
//		int index = ((b.Row) * Rows) + (b.Col) + (b.Row) + (b.Col) - 1;
//		if(index>=42||index<0) return 0;
//		NewJButton j = (NewJButton) b.getParent().getComponent(index);
//		return count += downLeft(j,count,player);
//	}
	private class MyAction implements ActionListener{
	    public void actionPerformed(ActionEvent event){
	    	if(!run) return;
	    	NewJButton b = (NewJButton)event.getSource();
	    	b = putMark(b);
	    	if(checkWin(b)) {
		    	run=false;
		    	setTitle(Current_Player+" won game");
	    	}
	    }
	    public NewJButton putMark(NewJButton b) {
	    	b = placeUnder(b);
	    	b.setEnabled(false);
	    	if(Current_Player==Player_1_Value) {
	    		board[b.Row][b.Col] = Player_1_Value;
	    		b.setBackground(Player_1_Color);
	    		//Current_Player = Player_2_Value;
	    		return b;
	    	}
	    	else {
	    		board[b.Row][b.Col] = Player_2_Value;
	    		b.setBackground(Player_2_Color);
	    		//Current_Player = Player_1_Value;
	    		return b;
	    	}
	    }
	    public NewJButton placeUnder(NewJButton b) {
	    	int index = ((b.Row) * Rows) + (b.Col) + (b.Row+1) + (Rows);
	    	if(index<42&&index>=0) {
				NewJButton j = (NewJButton) b.getParent().getComponent(index);
				if(j.getBackground().equals(BackgroundColor)) {
					b=placeUnder(j);
				}
	    	}
			return b;
	    }
	}
}
