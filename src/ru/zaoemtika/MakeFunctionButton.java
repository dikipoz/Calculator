package ru.zaoemtika;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MakeFunctionButton extends JButton {

private static final long serialVersionUID = 1L;
	
	JButton button = new JButton();
	
	public MakeFunctionButton(String digit, int x, int y, int width, int heigh) {
			setText(digit);
		setBounds(x, y, width, heigh);
		setOpaque(false);
		setMargin(new Insets(0, 0, 0, 0));
		setHorizontalTextPosition(SwingConstants.CENTER);
		setContentAreaFilled(false);
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.WHITE);
		setBorderPainted(false);
		//setBackground(Color.RED);
		//setBorder(new LineBorder(Color.RED));
		setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		setFocusPainted(false);
		setFocusable(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

}
