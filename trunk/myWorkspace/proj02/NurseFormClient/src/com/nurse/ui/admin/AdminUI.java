package com.nurse.ui.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AdminUI extends JFrame {
	private final String loginStr = "登入視窗";
	
	/**
	 * @throws HeadlessException
	 */
	public AdminUI() {
		try {
			JPanel jpanel = new JPanel();
			setTitle(loginStr);
			jpanel.setBorder(BorderFactory.createTitledBorder(loginStr));
			
			JLabel label = new JLabel("ABC");
			JTextField txtField = new JTextField(20);
			
			setLayout(new FlowLayout());
			
			jpanel.add(label);
			jpanel.add(txtField);
			
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
		//ui.setSize(200, 100);
		ui.pack();
		ui.setVisible(true);
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
