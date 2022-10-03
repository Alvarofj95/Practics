package views;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.Controller;
import model.Model;

public class DBConnection extends JFrame implements Views {

	private JPanel contentPane;
	private Model myModel;
	private Controller myController;
	private JTextField txtChooseFile, txtUsr, txtPwd, txtUrl;
	private JButton btnRead, btnWrite, btnBack,btnSave;
	private JLabel lblUser, lblPwd, lblUrl,lblFile;
	private JLabel lblFile2;
	private JLabel lblUser2;
	private JLabel lblKey2;
	private JLabel lblurl2;

	public DBConnection() {
		
		//GENERAL
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 267);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtChooseFile = new JTextField();
		txtChooseFile.setBounds(146, 48, 148, 20);
		txtChooseFile.setBorder(new LineBorder(new Color(102, 0, 204), 2, true));
		contentPane.add(txtChooseFile);
		txtChooseFile.setColumns(10);

		btnRead = new JButton("");
		btnRead.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRead.setIcon(new ImageIcon(DBConnection.class.getResource("/img_tablesDirector/readFile_noShadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnRead.setIcon(new ImageIcon(DBConnection.class.getResource("/img_tablesDirector/readFile_Shadow.png")));
			}
		});
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myModel.readFile();
			}
		});
		btnRead.setIcon(new ImageIcon(DBConnection.class.getResource("/img_tablesDirector/readFile_Shadow.png")));
		btnRead.setBounds(325, 79, 99, 53);
		btnRead.setFocusPainted(false);
		btnRead.setBorderPainted(false);
		btnRead.setContentAreaFilled(false);
		btnRead.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnRead);

		btnWrite = new JButton("");
		btnWrite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnWrite.setIcon(new ImageIcon(DBConnection.class.getResource("/img_tablesDirector/writeFile_noShadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnWrite.setIcon(new ImageIcon(DBConnection.class.getResource("/img_tablesDirector/writeFile_Shadow.png")));
			}
		});
		btnWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myModel.writeFIle();
			}
		});
		btnWrite.setIcon(new ImageIcon(DBConnection.class.getResource("/img_tablesDirector/writeFile_Shadow.png")));
		btnWrite.setBounds(322, 129, 112, 34);
		btnWrite.setFocusPainted(false);
		btnWrite.setBorderPainted(false);
		btnWrite.setContentAreaFilled(false);
		btnWrite.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnWrite);

		btnBack = new JButton("");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setIcon(new ImageIcon(DBConnection.class.getResource("/IMGStudents/Back2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnBack.setIcon(new ImageIcon(DBConnection.class.getResource("/IMGStudents/Back1.png")));
			}
		});
		btnBack.setIcon(new ImageIcon(DBConnection.class.getResource("/IMGStudents/Back1.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.ChangeWindows(15, 0);
			}
		});
		btnBack.setBounds(108, 185, 99, 34);
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnBack);

		txtUsr = new JTextField();
		txtUsr.setColumns(10);
		txtUsr.setBorder(new LineBorder(new Color(102, 0, 204), 2, true));
		txtUsr.setBounds(146, 79, 148, 20);
		contentPane.add(txtUsr);

		txtPwd = new JTextField();
		txtPwd.setColumns(10);
		txtPwd.setBorder(new LineBorder(new Color(102, 0, 204), 2, true));
		txtPwd.setBounds(146, 112, 148, 20);
		contentPane.add(txtPwd);

		txtUrl = new JTextField();
		txtUrl.setColumns(10);
		txtUrl.setBorder(new LineBorder(new Color(102, 0, 204), 2, true));
		txtUrl.setBounds(146, 143, 148, 20);
		contentPane.add(txtUrl);

		lblUser = new JLabel("User");
		lblUser.setBounds(22, 82, 34, 14);
		contentPane.add(lblUser);

		lblPwd = new JLabel("Password");
		lblPwd.setBounds(22, 118, 52, 14);
		contentPane.add(lblPwd);

		lblUrl = new JLabel("URL");
		lblUrl.setBounds(22, 146, 24, 14);
		contentPane.add(lblUrl);

		lblFile = new JLabel("File");
		lblFile.setBounds(22, 51, 24, 14);
		contentPane.add(lblFile);

		btnSave = new JButton("");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.saveDBConnection();

			}
		});
		btnSave.setFocusPainted(false);
		btnSave.setBorderPainted(false);
		btnSave.setContentAreaFilled(false);
		btnSave.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSave.setIcon(new ImageIcon(DBConnection.class.getResource("/img_settings/save_no_shadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSave.setIcon(new ImageIcon(DBConnection.class.getResource("/img_settings/save_shadoe.png")));
			}
		});
		btnSave.setIcon(new ImageIcon(DBConnection.class.getResource("/img_settings/save_shadoe.png")));
		btnSave.setBounds(220, 185, 112, 34);
		contentPane.add(btnSave);
		
		lblFile2 = new JLabel("");
		lblFile2.setIcon(new ImageIcon(DBConnection.class.getResource("/img_tablesDirector/document-ui.png")));
		lblFile2.setBounds(90, 41, 34, 24);
		contentPane.add(lblFile2);
		
		lblUser2 = new JLabel("");
		lblUser2.setIcon(new ImageIcon(DBConnection.class.getResource("/img_tablesDirector/profile.png")));
		lblUser2.setBounds(90, 72, 52, 24);
		contentPane.add(lblUser2);
		
		lblKey2 = new JLabel("");
		lblKey2.setIcon(new ImageIcon(DBConnection.class.getResource("/img_tablesDirector/vpn_key.png")));
		lblKey2.setBounds(90, 115, 46, 14);
		contentPane.add(lblKey2);
		
		lblurl2 = new JLabel("");
		lblurl2.setIcon(new ImageIcon(DBConnection.class.getResource("/img_tablesDirector/attachment.png")));
		lblurl2.setBounds(90, 141, 46, 33);
		contentPane.add(lblurl2);
	}

	
	
	
	// SETTERS

	public void setTxtUsr(String txtUsr) {
		this.txtUsr.setText(txtUsr);
	}

	public void setTxtPwd(String txtPwd) {
		this.txtPwd.setText(txtPwd);
	}

	public void setTxtUrl(String txtUrl) {
		this.txtUrl.setText(txtUrl);
	}

	public void setModel(Model myModel) {
		this.myModel = myModel;
	}

	public void setController(Controller myController) {
		this.myController = myController;

	}

	public void setTxtChooseFile(String msg) {
		this.txtChooseFile.setText(msg);
	}

	// GETTERS
	
	public JPanel getContentPaneDBConnection() {
		return contentPane;
	}

	public JTextField getTxtChooseFile() {
		return txtChooseFile;
	}

	public String getTxtUsr() {
		return txtUsr.getText();
	}

	public String getTxtPwd() {
		return txtPwd.getText();
	}

	public String getTxtUrl() {
		return txtUrl.getText();
	}
}