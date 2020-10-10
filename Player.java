public class Player{
	
	private static final int FORWARD = 1;
	private static final int BACKWARD = -1;
	private static int row = 0;
	private static int col = 0;
	private static int direction = 1;

	public Player()
	{

	}

	public static int getRow()
	{
		return row;
	}

	public static int getCol()
	{
		return col;
	}

	public static void stepForward()
	{
		if(col == 8)
		{
			row = row + 1;
			col = 0;
		}else
		{
			col = col + 1;
		}
	}

	public static void stepBackward()
	{
		if(col == 0)
		{
			row = row - 1;
			col = 8;			
		}else{
			col = col - 1;
		}
	}

	public void setDirection(int direction)
	{
		this.direction = direction;
	}

	public static void move()
	{
		if(direction == 1)
		{
			stepForward();
		}else
		{
			stepBackward();
		}
		if(row < 0 || col < 0)
		{
			row = 0;col = 0; direction = FORWARD;
		}
	}
}