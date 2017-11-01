package ru.zaoemtika;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;

public class MakeActionButton extends JButton{

	private static final long serialVersionUID = 1L;
	JButton button = new JButton();

	public MakeActionButton(String btn, int x, int y, int width, int heigh) {
		setText(btn);
		setOpaque(false);
		setContentAreaFilled(false);
		setBounds(x, y, width, heigh);
		setMargin(new Insets(0,0,0,0));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.WHITE);
		setBorderPainted(false);
		//setBackground(Color.RED);
		//setBorder(new LineBorder(Color.RED));
		setFocusPainted(false);
		setFocusable(false);
		setFont(new Font("Segoe UI", Font.PLAIN, 25));
		setBounds(x, y, width, heigh);
	}

}
