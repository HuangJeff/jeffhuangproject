package com.nurse.ui.admin;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AdminUI extends JFrame {
	
	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	
	/**
	 * Create the frame.
	 */
	public AdminUI() {
		setTitle("登入");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		//contentPane.setBackground(Color.BLUE);
		setContentPane(contentPane);
		
		//JLabel lblNewLabel = new JLabel("登入畫面");
		//水平置中
		//lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//lblNewLabel.setToolTipText(lblNewLabel.getText());
		contentPane.add(getTitlePanel(), BorderLayout.NORTH);
		
		//lblNewLabel_1 = new JLabel("New label");
		contentPane.add(getLeftLabelPanel(), BorderLayout.WEST);
	}
	
	private JPanel getTitlePanel() {
		JPanel titlePanel = new JPanel();
		titlePanel.setBorder(new LineBorder(Color.BLUE));
		JLabel lblNewLabel = new JLabel("登入畫面");
		//水平置中
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setToolTipText(lblNewLabel.getText());
		titlePanel.add(lblNewLabel);
		return titlePanel;
	}
	
	private JPanel getLeftLabelPanel() {
		JPanel leftLabelPanel = new JPanel();
		leftLabelPanel.setBorder(new LineBorder(Color.BLUE));
		JLabel lblNewLabel = new JLabel("帳號：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setToolTipText(lblNewLabel.getText());
		leftLabelPanel.add(lblNewLabel);
		return leftLabelPanel;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUI frame = new AdminUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
