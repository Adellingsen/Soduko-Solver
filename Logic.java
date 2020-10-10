public class Logic
{
	public static boolean rowColIsValid(BoardTray[][] board, int number, int row, int col)
	{
		for(int i = 0; i < 9; i++)
		{
			if(board[row][i].getNumber() == number || board[i][col].getNumber() == number)
			{
				return false;
			}
		}
		return true;
	}

	public static boolean boxIsValid(BoardTray[][] board, int number, int row, int col)
	{
		for(int i = row; i < row + 3; i++)
		{
			for(int j = col; j < col + 3; j++)
			{
				if(board[i][j].getNumber() == number)
				{
					return false;
				}
			}
		}
		return true;
	}
}