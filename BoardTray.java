import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class BoardTray extends JTextField implements ActionListener
{
	private int number;
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
		setTrayAsStartNumber();
		
	}

	public void setTrayAsStartNumber()
	{
		this.number = Integer.parseInt(this.getText());;
		this.setBackground(Color.LIGHT_GRAY);
		isStartNumber = true;
		this.setText(this.getText());
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
