package ru.zaoemtika;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import org.apache.commons.math.util.MathUtils;

import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class SwingFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_digit;

	private boolean flag_point = false;
	private boolean flag_reverse = false;
	private StringBuilder sb = new StringBuilder();
	private double memory;
	private JTextField textFieldMemory;

	public SwingFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SwingFrame.class.getResource("/ru/images/calculator.png")));

		// инициализация StringBuilder
		sb.append(0);

		MouseAdapter adapter = new MouseAdapter() {
			int x, y;

			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					x = e.getX();
					y = e.getY();
				}
			}

			public void mouseDragged(MouseEvent e) {
				if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0) {
					setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
				}
			}
		};
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setOpacity(0.96f);
		setBounds(100, 100, 427, 332);
		contentPane = new JPanel();

		contentPane.addMouseListener(adapter);
		contentPane.addMouseMotionListener(adapter);

		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldMemory = new JTextField();
		textFieldMemory.setFont(new Font("Tahoma", Font.BOLD, 11));
		textFieldMemory.setOpaque(false);
		textFieldMemory.setBorder(null);
		textFieldMemory.setFocusable(false);
		textFieldMemory.setBounds(13, 26, 20, 14);
		contentPane.add(textFieldMemory);
		textFieldMemory.setColumns(10);

		textField_digit = new JTextField("0");
		textField_digit.setBorder(new LineBorder(Color.RED));
		textField_digit.setDisabledTextColor(Color.BLACK);
		textField_digit.setEnabled(false);
		textField_digit.setBackground(Color.WHITE);
		textField_digit.setFont(new Font("Tahoma", Font.PLAIN, 35));
		textField_digit.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_digit.setBounds(12, 26, 403, 45);
		contentPane.add(textField_digit);
		textField_digit.setColumns(10);

		JButton button_point = new MakeDigitButton(".", 72, 282, 50, 35);
		button_point.addMouseListener(new DigitMouseListener(button_point, "."));
		contentPane.add(button_point);

		JButton button_0 = new MakeDigitButton("0", 12, 282, 50, 35);
		button_0.addMouseListener(new DigitMouseListener(button_0, "0"));
		contentPane.add(button_0);

		JButton button_1 = new MakeDigitButton("1", 12, 236, 50, 35);
		button_1.addMouseListener(new DigitMouseListener(button_1, "1"));
		contentPane.add(button_1);

		JButton button_2 = new MakeDigitButton("2", 72, 236, 50, 35);
		button_2.addMouseListener(new DigitMouseListener(button_2, "2"));
		contentPane.add(button_2);

		JButton button_3 = new MakeDigitButton("3", 132, 236, 50, 35);
		button_3.addMouseListener(new DigitMouseListener(button_3, "3"));
		contentPane.add(button_3);

		JButton button_4 = new MakeDigitButton("4", 12, 190, 50, 35);
		button_4.addMouseListener(new DigitMouseListener(button_4, "4"));
		contentPane.add(button_4);

		JButton button_5 = new MakeDigitButton("5", 72, 190, 50, 35);
		button_5.addMouseListener(new DigitMouseListener(button_5, "5"));
		contentPane.add(button_5);

		JButton button_6 = new MakeDigitButton("6", 132, 190, 50, 35);
		button_6.addMouseListener(new DigitMouseListener(button_6, "6"));
		contentPane.add(button_6);

		JButton button_7 = new MakeDigitButton("7", 12, 144, 50, 35);
		button_7.addMouseListener(new DigitMouseListener(button_7, "7"));
		contentPane.add(button_7);

		JButton button_8 = new MakeDigitButton("8", 72, 144, 50, 35);
		button_8.addMouseListener(new DigitMouseListener(button_8, "8"));
		contentPane.add(button_8);

		JButton button_9 = new MakeDigitButton("9", 132, 144, 50, 35);
		button_9.addMouseListener(new DigitMouseListener(button_9, "9"));
		contentPane.add(button_9);

		JButton button_equal = new MakeActionButton("=", 383, 282, 32, 35);
		button_equal.addMouseListener(new ActionMouseListener(button_equal, 20));
		contentPane.add(button_equal);

		JButton button_Sqr = new MakeFunctionButton("\u221A", 300, 282, 32, 35);
		button_Sqr.addMouseListener(new ActionMouseListener(button_Sqr, 12));
		contentPane.add(button_Sqr);

		JButton button_plus = new MakeActionButton("", 216, 144, 32, 35);
		button_plus.setIcon(new ImageIcon(SwingFrame.class.getResource("/ru/images/plus16px.png")));
		button_plus.addMouseListener(new ActionMouseListener(button_plus, 1));
		contentPane.add(button_plus);

		JButton button_minus = new MakeActionButton("", 216, 190, 32, 35);
		button_minus.setIcon(new ImageIcon(SwingFrame.class.getResource("/ru/images/minus16px.png")));
		button_minus.addMouseListener(new ActionMouseListener(button_minus, 2));
		contentPane.add(button_minus);

		JButton button_asterisk = new MakeActionButton("", 216, 236, 32, 35);
		button_asterisk.setIcon(new ImageIcon(SwingFrame.class.getResource("/ru/images/asterisk16px.png")));
		button_asterisk.addMouseListener(new ActionMouseListener(button_asterisk, 3));
		contentPane.add(button_asterisk);

		JButton button_divide = new MakeActionButton("", 262, 282, 32, 35);
		button_divide.setLocation(216, 282);
		button_divide.setIcon(new ImageIcon(SwingFrame.class.getResource("/ru/images/division18px.png")));
		button_divide.addMouseListener(new ActionMouseListener(button_divide, 4));
		contentPane.add(button_divide);

		JButton btnClear = new MakeClearButton("C", 12, 95, 62, 38);
		btnClear.setMargin(new Insets(0, 0, 0, 0));
		btnClear.setBounds(12, 95, 50, 38);
		btnClear.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				btnClear.setBackground(Color.LIGHT_GRAY);
			}

			public void mousePressed(MouseEvent e) {
				btnClear.setBackground(Color.RED);
				sb = new StringBuilder();
				sb.append(0);
				memory = 0;
				textField_digit.setText(sb.toString());
				flag_point = false;
				flag_reverse = false;
			}

			public void mouseExited(MouseEvent e) {
				btnClear.setOpaque(false);
			}

			public void mouseEntered(MouseEvent e) {
				btnClear.setBackground(Color.LIGHT_GRAY);
				btnClear.setOpaque(true);
			}

			public void mouseClicked(MouseEvent e) {
			}
		});
		contentPane.add(btnClear);

		JButton btnCe = new MakeClearButton("CE", 84, 95, 62, 38);
		btnCe.setMargin(new Insets(0, 0, 0, 0));
		btnCe.setBounds(72, 95, 50, 38);
		btnCe.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				btnCe.setOpaque(false);
			}

			public void mousePressed(MouseEvent e) {
				btnCe.setOpaque(true);
				if (sb.length() > 0) {
					if (sb.substring(sb.length() - 1).equals(".")) {
						flag_point = false;
					}
					sb.deleteCharAt(sb.length() - 1);
					textField_digit.setText(sb.toString());
					if (memory != 0) {
						textFieldMemory.setText("M");
					}
					if (sb.length() == 1 && sb.charAt(0) == '-') {
						sb = new StringBuilder();
						textField_digit.setText("0");
						flag_reverse = false;
					}
					if (sb.length() == 0) {
						textField_digit.setText("0");
						flag_reverse = false;
					}
				}
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}
		});
		contentPane.add(btnCe);

		JButton btnMemoryPlus = new MakeMemoryButton("M+", 170, 95, 45, 23);
		btnMemoryPlus.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {
				btnMemoryPlus.setOpaque(false);
			}

			public void mousePressed(MouseEvent arg0) {
				btnMemoryPlus.setOpaque(true);
				if (sb.length() > 0) {
					memory += Double.parseDouble(sb.toString());
					sb = new StringBuilder();
					textFieldMemory.setText("M");
				}
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent arg0) {
			}
		});
		contentPane.add(btnMemoryPlus);

		JButton btnMemoryMinus = new MakeMemoryButton("M-", 220, 95, 45, 23);
		btnMemoryMinus.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				btnMemoryMinus.setOpaque(false);
			}

			public void mousePressed(MouseEvent e) {
				btnMemoryMinus.setOpaque(true);
				if (sb.length() > 0) {
					memory -= Double.parseDouble(sb.toString());
					System.out.println(textFieldMemory.getText());
				}
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}
		});
		contentPane.add(btnMemoryMinus);

		JButton btnMemoryRead = new MakeMemoryButton("MR", 270, 95, 45, 23);
		btnMemoryRead.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {
				btnMemoryRead.setOpaque(false);
			}

			public void mousePressed(MouseEvent arg0) {
				btnMemoryRead.setOpaque(true);
				if (memory != 0) {
					textField_digit.setText(memory + "");
					textFieldMemory.setText("M");
				}
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent arg0) {
			}
		});
		contentPane.add(btnMemoryRead);

		JButton btnMemoruClear = new MakeMemoryButton("MC", 347, 95, 49, 23);
		btnMemoruClear.setSize(45, 23);
		btnMemoruClear.setLocation(320, 95);
		btnMemoruClear.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
				btnMemoruClear.setOpaque(true);
				memory = 0;
				textFieldMemory.setText("");
			}

			public void mouseReleased(MouseEvent e) {
				btnMemoruClear.setOpaque(false);

			}
		});
		contentPane.add(btnMemoruClear);

		JButton btnExit = new JButton("");
		btnExit.setBackground(Color.RED);
		btnExit.setIcon(new ImageIcon(SwingFrame.class.getResource("/ru/images/exit_new_17.png")));
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnExit.setFocusPainted(false);
		btnExit.setFocusable(false);
		btnExit.setBorderPainted(false);
		btnExit.setMargin(new Insets(0, 0, 0, 0));
		btnExit.setBounds(406, 1, 20, 20);
		btnExit.setOpaque(false);
		btnExit.setContentAreaFilled(false);
		btnExit.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}

			public void mouseExited(MouseEvent e) {
				btnExit.setOpaque(false);
				btnExit.setContentAreaFilled(false);
			}

			public void mouseEntered(MouseEvent e) {
				btnExit.setOpaque(true);
				btnExit.setContentAreaFilled(true);
			}

			public void mouseClicked(MouseEvent e) {
			}
		});

		MakeMemoryButton makeMemoryButton = new MakeMemoryButton("MS", 370, 95, 45, 23);
		contentPane.add(makeMemoryButton);
		contentPane.add(btnExit);

		JButton button_sin = new MakeFunctionButton("Sin", 258, 190, 32, 35);
		button_sin.addMouseListener(new ActionMouseListener(button_sin, 6));
		contentPane.add(button_sin);

		JButton button_cos = new MakeFunctionButton("Cos", 258, 236, 32, 35);
		button_cos.addMouseListener(new ActionMouseListener(button_cos, 7));
		contentPane.add(button_cos);

		JButton button_tan = new MakeFunctionButton("Tan", 258, 282, 32, 35);
		button_tan.addMouseListener(new ActionMouseListener(button_tan, 8));
		contentPane.add(button_tan);

		JButton button_log = new MakeFunctionButton("log ", 341, 144, 32, 35);
		button_log.addMouseListener(new ActionMouseListener(button_log, 13));
		contentPane.add(button_log);

		JButton button_10 = new MakeFunctionButton("10 ", 300, 236, 32, 35);
		button_10.addMouseListener(new ActionMouseListener(button_10, 11));
		contentPane.add(button_10);

		JButton button_pi = new MakeFunctionButton("\u03c0", 383, 144, 32, 35);
		button_pi.addMouseListener(new ActionMouseListener(button_pi, 17));
		contentPane.add(button_pi);

		JButton button_square = new MakeFunctionButton("x\u00B2", 300, 144, 32, 35);
		button_square.addMouseListener(new ActionMouseListener(button_square, 9));
		contentPane.add(button_square);

		JButton button_x_inSquare = new MakeFunctionButton("x", 300, 190, 32, 35);
		button_x_inSquare.addMouseListener(new ActionMouseListener(button_x_inSquare, 10));
		contentPane.add(button_x_inSquare);

		JButton button_reverse = new MakeDigitButton("\u00b1", 132, 282, 50, 35);
		button_reverse.addMouseListener(new ActionMouseListener(button_reverse, 0));
		contentPane.add(button_reverse);

		JButton button_1divide = new MakeFunctionButton("\u00B9/x", 258, 144, 32, 35);
		button_1divide.addMouseListener(new ActionMouseListener(button_1divide, 5));
		contentPane.add(button_1divide);

		JButton button_ln = new MakeFunctionButton("ln", 341, 190, 32, 35);
		button_ln.addMouseListener(new ActionMouseListener(button_ln, 14));
		contentPane.add(button_ln);

		JButton button_factorial = new MakeFunctionButton("n!", 341, 236, 32, 35);
		button_factorial.addMouseListener(new ActionMouseListener(button_factorial, 15));
		contentPane.add(button_factorial);

		JButton button_percent = new MakeFunctionButton("%", 342, 282, 32, 35);
		button_percent.addMouseListener(new ActionMouseListener(button_percent, 16));
		contentPane.add(button_percent);

		JButton button_EinX = new MakeFunctionButton("\u212E", 383, 190, 32, 35);
		button_EinX.addMouseListener(new ActionMouseListener(button_EinX, 18));
		contentPane.add(button_EinX);

		JButton button_Exponenta = new MakeFunctionButton("Exp", 383, 236, 32, 35);
		button_Exponenta.addMouseListener(new ActionMouseListener(button_Exponenta, 19));
		contentPane.add(button_Exponenta);

		JLabel lblNewLabel_2 = new JLabel("\u041A\u0430\u043B\u044C\u043A\u0443\u043B\u044F\u0442\u043E\u0440");
		lblNewLabel_2.setFont(new Font("Calibri", Font.ITALIC, 11));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(12, 6, 90, 14);
		contentPane.add(lblNewLabel_2);

		JButton btn_minimize = new JButton("_");
		btn_minimize.setForeground(Color.WHITE);
		btn_minimize.setContentAreaFilled(false);
		btn_minimize.setBackground(Color.DARK_GRAY);
		btn_minimize.setOpaque(false);
		btn_minimize.setFocusPainted(false);
		btn_minimize.setFocusable(false);
		btn_minimize.setBorder(null);
		btn_minimize.setMargin(new Insets(0, 0, 0, 0));
		btn_minimize.setBounds(384, 1, 20, 20);
		btn_minimize.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				btn_minimize.setOpaque(false);
			}

			public void mousePressed(MouseEvent e) {
				// btn_minimize.setOpaque(false);
				setState(ICONIFIED);
			}

			public void mouseExited(MouseEvent e) {
				btn_minimize.setOpaque(false);
			}

			public void mouseEntered(MouseEvent e) {

				btn_minimize.setOpaque(true);
			}

			public void mouseClicked(MouseEvent e) {
				btn_minimize.setOpaque(true);
			}
		});
				
						JLabel label_1 = new JLabel("x");
						label_1.setForeground(Color.WHITE);
						label_1.setFont(new Font("Segoe UI", Font.PLAIN, 10));
						label_1.setBounds(401, 191, 6, 14);
						contentPane.add(label_1);
		
				JLabel label = new JLabel("y");
				label.setForeground(Color.WHITE);
				label.setFont(new Font("Segoe UI", Font.PLAIN, 10));
				label.setBounds(320, 191, 6, 14);
				contentPane.add(label);
		
				JLabel lblNewLabel_1 = new JLabel("x");
				lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 10));
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setBounds(320, 238, 6, 14);
				contentPane.add(lblNewLabel_1);
		contentPane.add(btn_minimize);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new LineBorder(Color.RED));
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(0, 0, 427, 332);
		contentPane.add(lblNewLabel);
	}

	class DigitMouseListener implements MouseListener {

		private String digit;
		private JButton button;

		public DigitMouseListener(JButton button, String digit) {

			this.button = button;
			this.digit = digit;
		}

		public void mouseClicked(MouseEvent e) {

		}

		public void mouseEntered(MouseEvent e) {
			this.button.setOpaque(true);
		}

		public void mouseExited(MouseEvent e) {
			this.button.setOpaque(false);
		}

		public void mousePressed(MouseEvent e) {
			this.button.setBackground(Color.RED);

			switch (digit) {
			case ".": {
				if (sb.length() < 15 & !flag_point) {
					sb.append(".");
					flag_point = true;
				}
				textField_digit.setText(sb.toString());
				break;
			}

			case "0": {
				if (sb.length() < 18)
					if (!sb.toString().equals("0")) {
						sb.append(0);
						textField_digit.setText(sb.toString());
					}
				break;
			}
			default: {
				if (sb.length() < 18) {
					if (sb.toString().equals("0")) {
						sb = new StringBuilder();
						sb.append(digit);
						textField_digit.setText(sb.toString());
					} else {
						sb.append(digit);
						textField_digit.setText(sb.toString());
					}
					if (memory != 0) {
						textFieldMemory.setText("M");
					}
				}
			}

			}
		}

		public void mouseReleased(MouseEvent e) {
			this.button.setBackground(Color.LIGHT_GRAY);
		}

	}

	class ActionMouseListener implements MouseListener {

		private JButton button;
		private int i;

		public ActionMouseListener(JButton button, int i) {
			this.button = button;
			this.i = i;
		}

		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
			this.button.setOpaque(true);
		}

		public void mouseExited(MouseEvent e) {
			this.button.setOpaque(false);
		}

		public void mousePressed(MouseEvent e) {
			this.button.setBackground(Color.RED);

			switch (i) {
			case 0: {
				if (!flag_reverse) {
					if (!sb.toString().equals("0")) {
						sb.insert(0, "-");
						flag_reverse = true;
					}
				} else {
					sb.delete(0, 1);
					flag_reverse = false;
				}
				textField_digit.setText(sb.toString());
			}
			case 1: {

				break;
			}
			case 5: {
				double tmp = 1 / Double.parseDouble(sb.toString());
				sb = new StringBuilder();
				sb.append(MathUtils.round(tmp, 18));
				if (sb.length() > 2 && sb.substring(sb.length() - 2, sb.length()).equals(".0")) {
					sb.delete(sb.length() - 2, sb.length());
				}
				textField_digit.setText(sb.toString());
				break;
			}
			case 6: {
				double tmp = Math.sin(Math.toRadians(Double.parseDouble(sb.toString())));
				if (MathUtils.round(tmp, 14) == 0) {
					sb = new StringBuilder();
					sb.append(MathUtils.round(tmp, 1));
				} else {
					sb = new StringBuilder();
					sb.append(MathUtils.round(tmp, 16));
				}
				if (sb.length() > 2 && sb.substring(sb.length() - 2, sb.length()).equals(".0")) {
					sb.delete(sb.length() - 2, sb.length());
				}
				if (Double.parseDouble(sb.toString()) < 0)
					flag_reverse = true;
				textField_digit.setText(sb.toString());
				break;
			}

			case 7: {
				double tmp = Math.cos(Math.toRadians(Double.parseDouble(sb.toString())));

				if (MathUtils.round(tmp, 16) == 0) {
					sb = new StringBuilder();
					sb.append(MathUtils.round(tmp, 1));
				} else {
					sb = new StringBuilder();
					sb.append(MathUtils.round(tmp, 14));
				}
				if (sb.length() > 2 && sb.substring(sb.length() - 2, sb.length()).equals(".0")) {
					sb.delete(sb.length() - 2, sb.length());
				}
				if (Double.parseDouble(sb.toString()) < 0)
					flag_reverse = true;
				textField_digit.setText(sb.toString());
				break;
			}
			case 8: {
				double tmp = Math.cos(Math.toRadians(Double.parseDouble(sb.toString())));

				if (MathUtils.round(tmp, 14) == 0) {
					sb = new StringBuilder();
					sb.append("Ошибка");
				} else {
					tmp = Math.tan(Math.toRadians(Double.parseDouble(sb.toString())));
					sb = new StringBuilder();
					sb.append(MathUtils.round(tmp, 18));
				}
				if (sb.length() > 2 && sb.substring(sb.length() - 2, sb.length()).equals(".0")) {
					sb.delete(sb.length() - 2, sb.length());
				}
				try {
					if (Double.parseDouble(sb.toString()) < 0)
						flag_reverse = true;
				} catch (NumberFormatException ex) {
					flag_reverse = true;
					textField_digit.setText(sb.toString());
				}
				textField_digit.setText(sb.toString());
				break;
			}
			case 9: {
				double tmp = Double.parseDouble(sb.toString()) * Double.parseDouble(sb.toString());
				sb = new StringBuilder();
				sb.append(tmp);
				if (sb.length() > 2 && sb.substring(sb.length() - 2, sb.length()).equals(".0")) {
					sb.delete(sb.length() - 2, sb.length());
				}
				textField_digit.setText(sb.toString());

				break;
			}
			case 12: {
				double tmp = Math.sqrt(Double.parseDouble(sb.toString()));
				sb = new StringBuilder();
				sb.append(tmp);
				if (sb.length() > 2 && sb.substring(sb.length() - 2, sb.length()).equals(".0")) {
					sb.delete(sb.length() - 2, sb.length());
				}
				textField_digit.setText(sb.toString());
				break;
			}

			case 13:{
				double tmp = Math.log10(Double.parseDouble(sb.toString()));
				sb = new StringBuilder();
				sb.append(tmp);
				if (sb.length() > 2 && sb.substring(sb.length() - 2, sb.length()).equals(".0")) {
					sb.delete(sb.length() - 2, sb.length());
				}
				textField_digit.setText(sb.toString());
				break;
				
			}
			
			case 14:{
				double tmp = Math.log(Double.parseDouble(sb.toString()));
				sb = new StringBuilder();
				sb.append(tmp);
				if (sb.length() > 2 && sb.substring(sb.length() - 2, sb.length()).equals(".0")) {
					sb.delete(sb.length() - 2, sb.length());
				}
				textField_digit.setText(sb.toString());
				break;
				
			}
			case 17: {
				sb = new StringBuilder();
				sb.append(Math.PI);
				flag_point = true;
				textField_digit.setText(sb.toString());
				break;
			}
			case 18: {
				double tmp = Math.pow(Math.E, Double.parseDouble(sb.toString()));
				sb = new StringBuilder();
				sb.append(MathUtils.round(tmp, 14));
				textField_digit.setText(sb.toString());
			}
			}
		}

		public void mouseReleased(MouseEvent e) {
			this.button.setBackground(Color.LIGHT_GRAY);
		}

	}
}
