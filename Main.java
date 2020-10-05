public class Main
{
	private static int ROWS = 9;
	private static int COLS = 9;
	private static int board[][] = new int[ROWS][COLS];

	public static void main(String args[])
	{
		print_board();
	}

	public static void print_board()
	{
		for(int i = 0; i < ROWS; i++)
		{
			for(int j = 0; j < COLS; j++)
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();	
		}
	}
}