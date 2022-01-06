import javax.swing.JButton;

public class NewJButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int Row;
	public final int Col;
	public NewJButton(int row,int col) {
		this.Row=row;
		this.Col=col;
	}
}
