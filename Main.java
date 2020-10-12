
import javax.swing.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;

public class Main
{
	private static final int ROWS = 9;
	private static final int COLS = 9;
	private static final int FORWARD = 1;
	private static final int BACKWARD = -1;
	private static Player player = new Player();
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
      	solveButton.addActionListener(new ActionListener(){
      		public void actionPerformed(ActionEvent event) 
	        {
	            solve();
	        }
      	});
      	menuPanel.add(solveButton);
		resetButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent event) 
	        {
	            reset();
	        }
      	});
      	menuPanel.add(resetButton);
		menuPanel.setBackground(Color.black);
		boardPanel.setBackground(Color.black);
		boardPanel.setSize(450, 450);
		boardPanel.setLayout(new GridLayout(9, 9, 5, 5));
		mainFrame.add(menuPanel, BorderLayout.PAGE_START);
		mainFrame.add(boardPanel, BorderLayout.CENTER);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}

	public static boolean solve()
	{
		if(!setStartNumbers())
		{
			reset();
			JOptionPane.showMessageDialog(mainFrame, "Wrong input", "Soduko Solver - Info", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		boolean numberIsSet = false;

		while(player.getRow() < ROWS && player.getCol() < COLS)
		{
			if(!board[player.getRow()][player.getCol()].isStartNumber())
			{
				for(int number = board[player.getRow()][player.getCol()].getNumber() + 1; number <= 9; number++)
				{	
					if(Logic.rowColIsValid(board, number, player.getRow(), player.getCol()) && Logic.boxIsValid(board, number, 3*((int)player.getRow()/3), 3*((int)player.getCol()/3)))
					{
						board[player.getRow()][player.getCol()].setTray(number);
						player.setDirection(FORWARD);
						numberIsSet = true;
						break;
					}
				}
				if(!numberIsSet)
				{
					board[player.getRow()][player.getCol()].resetTray();
					player.setDirection(BACKWARD);
				}
				numberIsSet = false;
			}
			player.move();
		}
		return true;
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

	public static void printBoardInTerminal()
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

	public static boolean setStartNumbers()
	{
		for(int i = 0; i < ROWS; i++)
		{
			for(int j = 0; j < COLS; j++)
			{
				//fix if not right number
				if(board[i][j].readNumber())
				{
					if(!board[i][j].setTrayAsStartNumber())
					{
						return false;
					}
				}
			}	
		}
		return true;
	}
}
