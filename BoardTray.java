import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class BoardTray extends JTextField
{
	private int number;
	private boolean isStartNumber;

	public BoardTray(){
		number = 0;
		isStartNumber = false;
		this.setBackground(Color.WHITE);
		this.setFont(new Font(this.getFont().getName(),1,20));
		this.setHorizontalAlignment(JTextField.CENTER);
	}

	public boolean setTrayAsStartNumber()
	{
		try
		{
			this.number = Integer.parseInt(this.getText());
			if(Integer.parseInt(this.getText()) > 9 || Integer.parseInt(this.getText()) < 1)return false;
		}catch(Exception e)
		{
			return false;
		}
		this.setBackground(Color.LIGHT_GRAY);
		isStartNumber = true;
		this.setText(this.getText());
		this.update(this.getGraphics());
		return true;
	}

	public boolean readNumber()
	{
		if(!this.getText().equals(""))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void setTray(int number)
	{
		this.number = number;
		this.setText(Integer.toString(number));
		this.update(this.getGraphics());
	}
	
	public int getNumber()
	{
		return number;
	}

	public boolean isStartNumber()
	{
		return isStartNumber;
	}

	public void resetTray()
	{
		number = 0;
		isStartNumber = false;
		this.setBackground(Color.WHITE);
		this.setText("");
		this.update(this.getGraphics());
	}
}
