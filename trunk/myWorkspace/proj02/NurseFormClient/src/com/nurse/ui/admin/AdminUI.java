package com.nurse.ui.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
public class AdminUI extends JFrame implements ActionListener {
	public static AdminUI hisEmrAdminFrame = null;
	
	private JPanel mainPanel = null;	//Base Panel
	private JPanel bordPane = null;		//Second Panel
	private JPanel accountPanel = null;	//帳號欄位 Panel
	private JPanel passwordPanel = null;	//密碼欄位 Panel
	private JPanel cardTypePanel = null;//讀卡機類型 Panel
	private JPanel pinCodePanel = null;	//Pin Code Panel
	private JPanel btnPanel = null;		//按鈕 Panel
	
	private JTextField accountTxtField = null;		//帳號欄位
	
	private Dimension baseHightWidth = new Dimension(500, 300); //基本長寬
	private Point baseLocation = new Point(0, 0);	//基本坐標位置
	
	/**
	 * @throws HeadlessException
	 */
	public AdminUI() {
		try {
			this.initialize();
			this.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 處理帳號欄位Panel
	 * @return
	 */
	private JPanel getAccountPanel() {
		if(accountPanel == null) {
			try {
				accountPanel = new JPanel();
				accountPanel.setLayout(null);
				accountPanel.setBackground(Color.YELLOW);
				//Location
				Point lp = new Point();
				lp.setLocation(baseLocation.getX() + 10, baseLocation.getY() + 30); //x,y坐標
				//Hight Width
				Dimension ld = new Dimension();
				ld.setSize(baseHightWidth.getWidth()-40, baseHightWidth.getHeight()-270); //長/寬
				accountPanel.setBounds(new Rectangle(lp, ld));
				
				JLabel ljLab = new JLabel("帳號");
				ljLab.setToolTipText(ljLab.getText());
				ljLab.setFont(new Font("新細明體", Font.PLAIN, 16));
				
				accountTxtField = new JTextField();
				accountTxtField.setActionCommand("帳號");
				accountTxtField.addActionListener(this);
				accountTxtField.setToolTipText("請輸入您的帳號");
				
				accountTxtField.requestFocus();
				//accountTxtField.setBounds(new Rectangle(lp, ld));
				
				accountPanel.add(ljLab, new java.awt.FlowLayout());
				accountPanel.add(accountTxtField, new java.awt.FlowLayout());
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return accountPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動產生的方法 Stub
		
	}
	
	//-----初始化-----
	/**
	 * 初始此畫面
	 */
	private void initialize() {
		this.setSize(baseHightWidth);
		this.setLocation(baseLocation);
		this.setName("MainFrame");
		//this.setIconImage(IconsFactory.getImageIcon(LoginUIIconsName.ADMIN_FRAME_ICONS).getImage());
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setTitle("電子護理表單登入畫面");
		this.setContentPane(getJContentPane());
	}
	
	/**
	 * 處理容器
	 * @return JPanel
	 */
	private JPanel getJContentPane() {
		if(mainPanel == null) {
			mainPanel = new JPanel();
			mainPanel.setLayout(null);
			mainPanel.add(getBordPane());
		}
		return mainPanel;
	}
	
	/**
	 * 處理容器
	 * @return JPanel
	 */
	private JPanel getBordPane() {
		if(bordPane == null) {
			bordPane = new JPanel();
			bordPane.setLayout(null);
			Dimension d = new Dimension();
			d.setSize(baseHightWidth.getWidth()-10, baseHightWidth.getHeight()-40);
			bordPane.setSize(d);
			bordPane.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createEtchedBorder(EtchedBorder.RAISED), 
					"表單Title", 
					TitledBorder.DEFAULT_JUSTIFICATION, 
					TitledBorder.DEFAULT_POSITION, 
					new Font("Dialog", Font.BOLD, 14), 
					new Color(51, 51, 51)));
			bordPane.add(getAccountPanel());
//			bordPane.add(getPassWordPanel());
//			bordPane.add(getCardTypePanel());
//			bordPane.add(getPinCodePanel());
//			bordPane.add(get2ButtonPanel());
		}
		return bordPane;
	}
	
	/**
	 * 顯示
	 */
	public void showUI() {
		if(!hisEmrAdminFrame.isVisible()) {
			hisEmrAdminFrame.setVisible(true);
		}
	}
	
	/**
	 * 建立登入UI
	 */
	public static void tobeCreateAdminFrameUI() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				if(hisEmrAdminFrame == null) {
					hisEmrAdminFrame = new AdminUI();
					//HIDE_ON_CLOSE（在 WindowConstants 中定義）：
					//調用任意已註冊的 WindowListener 物件後自動隱藏該窗體。
					
					//DISPOSE_ON_CLOSE（在 WindowConstants 中定義）：
					//移除視窗的預設視窗關閉操作。(單機執行，最終會closed應用程式
					hisEmrAdminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					hisEmrAdminFrame.showUI();
					
					hisEmrAdminFrame.addWindowStateListener(new WindowStateListener() {
						@Override
						public void windowStateChanged(WindowEvent e) {
							if(hisEmrAdminFrame.getState() == 1) {	//最小化狀態
								hisEmrAdminFrame.setState(0);	//切換成正常狀態
								//hisEmrAdminFrame.closedUI();
							}
						}
					});
				}
			}
		});
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		tobeCreateAdminFrameUI();
	}
}
