package com.nurse.ui.admin;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class AdminUI extends JFrame implements ActionListener {
	/** 登入視窗 */
	private final String LOGIN_STR = "登入視窗";
	/** BTN_ACCOUNT */
	private final String BTN_ACC_CMD = "BTN_ACCOUNT";
	/** BTN_CLEAN */
	private final String BTN_CLN_CMD = "BTN_CLEAN";
	
	/**
	 * @throws HeadlessException
	 */
	public AdminUI() {
		try {
			setTitle(LOGIN_STR);
			setLayout(new FlowLayout());
			
			JPanel jpanel = new JPanel();
			jpanel.setLayout(new GridLayout(3, 1, 0, 10));
			jpanel.setBorder(BorderFactory.createTitledBorder(LOGIN_STR));
			
			JPanel p01 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
			JLabel labelAcc = new JLabel("帳號：");
			JTextField accTxtField = new JTextField(20);
			JPanel p02 = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
			JLabel labelPas = new JLabel("密碼：");
			JPasswordField pasTxtField = new JPasswordField(20);
			
			JPanel p03 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
			JButton btnAcc = new JButton("登入");
			JButton btnCln = new JButton("清除");
			btnAcc.setActionCommand(BTN_ACC_CMD);
			btnAcc.addActionListener(this);
			btnCln.setActionCommand(BTN_CLN_CMD);
			btnCln.addActionListener(this);
			
			p01.add(labelAcc);
			p01.add(accTxtField);
			p02.add(labelPas);
			p02.add(pasTxtField);
			p03.add(btnAcc);
			p03.add(btnCln);
			
			jpanel.add(p01);
			jpanel.add(p02);
			jpanel.add(p03);
			
			add(jpanel);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 建立登入UI
	 */
	public static void tobeCreateAdminFrameUI() {
		//setDefaultLookAndFeelDecorated(true);
		
		AdminUI ui = new AdminUI();
		ui.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ui.setLocationRelativeTo(null);
		ui.setResizable(false);
		//ui.setSize(200, 100);
		ui.pack();
		ui.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if(this.BTN_ACC_CMD.equals(e.getActionCommand())) {
			
		} else if(this.BTN_CLN_CMD.equals(e.getActionCommand())) {
			
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				tobeCreateAdminFrameUI();
			}
		});
	}
}
