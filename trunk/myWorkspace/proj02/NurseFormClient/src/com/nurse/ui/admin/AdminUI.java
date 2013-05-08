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
	private JPanel accountPanel = null;	//�b����� Panel
	private JPanel passwordPanel = null;	//�K�X��� Panel
	private JPanel cardTypePanel = null;//Ū�d������ Panel
	private JPanel pinCodePanel = null;	//Pin Code Panel
	private JPanel btnPanel = null;		//���s Panel
	
	private JTextField accountTxtField = null;		//�b�����
	
	private Dimension baseHightWidth = new Dimension(500, 300); //�򥻪��e
	private Point baseLocation = new Point(0, 0);	//�򥻧��Ц�m
	
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
	 * �B�z�b�����Panel
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
				lp.setLocation(baseLocation.getX() + 10, baseLocation.getY() + 30); //x,y����
				//Hight Width
				Dimension ld = new Dimension();
				ld.setSize(baseHightWidth.getWidth()-40, baseHightWidth.getHeight()-270); //��/�e
				accountPanel.setBounds(new Rectangle(lp, ld));
				
				JLabel ljLab = new JLabel("�b��");
				ljLab.setToolTipText(ljLab.getText());
				ljLab.setFont(new Font("�s�ө���", Font.PLAIN, 16));
				
				accountTxtField = new JTextField();
				accountTxtField.setActionCommand("�b��");
				accountTxtField.addActionListener(this);
				accountTxtField.setToolTipText("�п�J�z���b��");
				
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
		// TODO �۰ʲ��ͪ���k Stub
		
	}
	
	//-----��l��-----
	/**
	 * ��l���e��
	 */
	private void initialize() {
		this.setSize(baseHightWidth);
		this.setLocation(baseLocation);
		this.setName("MainFrame");
		//this.setIconImage(IconsFactory.getImageIcon(LoginUIIconsName.ADMIN_FRAME_ICONS).getImage());
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setTitle("�q�l�@�z���n�J�e��");
		this.setContentPane(getJContentPane());
	}
	
	/**
	 * �B�z�e��
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
	 * �B�z�e��
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
					"���Title", 
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
	 * ���
	 */
	public void showUI() {
		if(!hisEmrAdminFrame.isVisible()) {
			hisEmrAdminFrame.setVisible(true);
		}
	}
	
	/**
	 * �إߵn�JUI
	 */
	public static void tobeCreateAdminFrameUI() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				if(hisEmrAdminFrame == null) {
					hisEmrAdminFrame = new AdminUI();
					//HIDE_ON_CLOSE�]�b WindowConstants ���w�q�^�G
					//�եΥ��N�w���U�� WindowListener �����۰����øӵ���C
					
					//DISPOSE_ON_CLOSE�]�b WindowConstants ���w�q�^�G
					//�����������w�]���������ާ@�C(�������A�̲׷|closed���ε{��
					hisEmrAdminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					hisEmrAdminFrame.showUI();
					
					hisEmrAdminFrame.addWindowStateListener(new WindowStateListener() {
						@Override
						public void windowStateChanged(WindowEvent e) {
							if(hisEmrAdminFrame.getState() == 1) {	//�̤p�ƪ��A
								hisEmrAdminFrame.setState(0);	//���������`���A
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
