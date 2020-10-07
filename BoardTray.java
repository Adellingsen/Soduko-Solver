import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BoardTray extends JTextField implements ActionListener
{
	private int number = 0;
	private boolean isStartNumber;

	public BoardTray(){
		number = 0;
		isStartNumber = false;
		addActionListener(this);
		this.setBackground(Color.WHITE);
		this.setFont(new Font(this.getFont().getName(),1,20));
		this.setHorizontalAlignment(JTextField.CENTER);
	}

	public void actionPerformed(ActionEvent e)
	{
		number = Integer.parseInt(this.getText());
		isStartNumber = true;
		this.setBackground(Color.LIGHT_GRAY);
	}

	public void setAsStartNumber(int number)
	{
		this.number = number;
		isStartNumber = true;
	}

	public void setNumber(int number)
	{
		this.number = number;
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
	}
}
