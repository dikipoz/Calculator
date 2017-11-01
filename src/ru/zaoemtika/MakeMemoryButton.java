package ru.zaoemtika;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;

public class MakeMemoryButton extends JButton{

	private static final long serialVersionUID = 1L;

	JButton button = new JButton();
	
	public MakeMemoryButton(String typeButton, int x, int y, int widht, int heihg) {
		setText(typeButton);
		setBounds(x, y, widht, heihg);
		setOpaque(false);
		setContentAreaFilled(false);
		setForeground(Color.WHITE);
		setBorderPainted(false);
		//setBackground(Color.RED);
		//setBorder(new LineBorder(Color.RED));
		setMargin(new Insets(0, 0, 0, 0));
		setFont(new Font("Segoe UI", Font.PLAIN, 15));
		setFocusPainted(false);
		setFocusable(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

}
