
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main
{
	private static int ROWS = 9;
	private static int COLS = 9;
	private static BoardTray board[][] = new BoardTray[ROWS][COLS];
	private static JFrame mainFrame = new JFrame("Soduko Solver");
	private static JPanel menuPanel = new JPanel();
	private static JPanel boardPanel = new JPanel();
	private static JButton solveButton = new JButton("Solve");
	private static JButton resetButton = new JButton("Reset");

	public static void main(String args[])
	{
		initBoard();
		intiGUI();
	}

	public static void intiGUI()
	{
		mainFrame.setSize(450, 500);
		mainFrame.setLayout(new BorderLayout());
		menuPanel.add(solveButton);
		ActionListener runListener = new ActionListener() {
	        public void actionPerformed(ActionEvent event) 
	        {
	            solve();
	        }
      	};
      	solveButton.addActionListener(runListener);
		menuPanel.add(resetButton);
		ActionListener resetListener = new ActionListener() {
	        public void actionPerformed(ActionEvent event) 
	        {
	            reset();
	        }
      	};
      	resetButton.addActionListener(resetListener);
		menuPanel.setBackground(Color.black);
		boardPanel.setBackground(Color.black);
		boardPanel.setSize(450, 450);
		boardPanel.setLayout(new GridLayout(9, 9, 5, 5));
		mainFrame.add(menuPanel, BorderLayout.PAGE_START);
		mainFrame.add(boardPanel, BorderLayout.CENTER);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}

	public static void solve()
	{
		//Solving
	}

	public static void reset()
	{
	for(int i = 0; i < ROWS; i++)
		{
			for(int j = 0; j < COLS; j++)
			{
				board[i][j].resetTray();
			}	
		}
	}
	public static void initBoard()
	{
		for(int i = 0; i < ROWS; i++)
		{
			for(int j = 0; j < COLS; j++)
			{
				board[i][j] = new BoardTray();
				boardPanel.add(board[i][j]);
			}	
		}
	}

	public static void printBoard()
	{
		for(int i = 0; i < ROWS; i++)
		{
			for(int j = 0; j < COLS; j++)
			{
				System.out.print(board[i][j].getNumber() + " ");
			}
			System.out.println();	
		}
	}

	public static void setNumber(int i, int j, int number)
	{
		board[i][j].setNumber(number);
	}

	public static void setNumberAsStartNumber(int i, int j, int number)
	{
		board[i][j].setAsStartNumber(number);
	}
}
