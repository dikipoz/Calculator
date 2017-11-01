package ru.zaoemtika;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;

public class MakeClearButton extends JButton{

	private static final long serialVersionUID = 1L;
	
	JButton button = new JButton();

	public MakeClearButton(String btn, int x, int y, int width, int heigh) {
		setText(btn);
		setBounds(x, y, width, heigh);
		setOpaque(false);
		setContentAreaFilled(false);
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.WHITE);
		setBorderPainted(false);
		//setBackground(Color.RED);
		//setBorder(new LineBorder(Color.RED));
		setFont(new Font("Segoe UI", Font.PLAIN, 25));
		setFocusPainted(false);
		setFocusable(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

}
