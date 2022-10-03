
package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.Controller;
import model.Model;

public class SettingsDirector extends JFrame implements Views {

	private Controller myController;
	private Model myModel;
	private JPanel contentPane, header;
	private JLabel lblIconUser, lblRol, lblNameDesc, lblLogo, lblTitle, lblPasswordErrorMatch, lblConfNewPwd,
			lblUsername, lblOldPwd, lblNewPwd, lblPasswordErrorMatch_1, lblUserError, lblPasswordError_1, lblPhoto,
			lblDni, lblLastname, lblName, lblEmail;
	private JButton btnWatchOldPwd, btnBack, btnLog_outDir, btnWatchPwdNew, btnWatchConfPwd, btnWatchOldPwd_1,
			btnChoosePhoto, btnEdit, btnModify;
	private JPasswordField txtNewPass, txtOldPass, txtConfirmNewPass;
	private JTextField txtName, txtDni, txtLastname, txtUser, txtEmail;

	// BUILDER

	public SettingsDirector() {

		// PANELS

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		header = new JPanel();
		header.setBackground(new Color(239, 240, 246));
		header.setBounds(0, 0, 1283, 76);
		contentPane.add(header);
		header.setLayout(null);

		// LABELS

		lblLogo = new JLabel("PracTICS");
		lblLogo.setIcon(new ImageIcon(SettingsDirector.class.getResource("/img_tablesDirector/logo.png")));
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Segoe UI Light", Font.PLAIN, 34));
		lblLogo.setBounds(10, 0, 236, 76);
		header.add(lblLogo);

		lblTitle = new JLabel("Settings");
		lblTitle.setForeground(new Color(95, 46, 234));
		lblTitle.setFont(new Font("Arial Black", Font.BOLD, 28));
		lblTitle.setBounds(571, 3, 141, 76);
		header.add(lblTitle);

		// USER TAG

		lblIconUser = new JLabel("");
		lblIconUser.setIcon(new ImageIcon(SettingsDirector.class.getResource("/img_settings/Frame.png")));
		lblIconUser.setBounds(1111, 118, 107, 112);
		contentPane.add(lblIconUser);

		// USERNAME

		lblNameDesc = new JLabel("");
		lblNameDesc.setFont(new Font("Arial", Font.PLAIN, 29));
		lblNameDesc.setBounds(824, 126, 277, 104);
		contentPane.add(lblNameDesc);

		// ROLE

		lblRol = new JLabel("");
		lblRol.setForeground(new Color(95, 46, 234));
		lblRol.setFont(new Font("Arial", Font.BOLD, 15));
		lblRol.setBounds(1121, 241, 105, 14);
		contentPane.add(lblRol);

		// BACK BUTTON

		btnBack = new JButton("");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setIcon(new ImageIcon(
						SettingsDirector.class.getResource("/img_tablesDirector/backArrow_noShadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnBack.setIcon(
						new ImageIcon(SettingsDirector.class.getResource("/img_tablesDirector/backArrow_Shadow.png")));
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.ChangeWindows(14, 7);
			}
		});
		btnBack.setBackground(Color.WHITE);
		btnBack.setIcon(new ImageIcon(SettingsDirector.class.getResource("/img_tablesDirector/backArrow_Shadow.png")));
		btnBack.setBounds(10, 87, 99, 55);
		contentPane.add(btnBack);
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		// BUTTON SHOW OLD PASS

		btnWatchOldPwd = new JButton("");
		btnWatchOldPwd.setBackground(Color.WHITE);
		btnWatchOldPwd.setIcon(new ImageIcon(SettingsDirector.class.getResource("/img_settings/View.png")));
		btnWatchOldPwd.setBounds(0, 0, 46, 44);

		btnLog_outDir = new JButton("");
		btnLog_outDir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLog_outDir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLog_outDir.setIcon(
						new ImageIcon(SettingsDirector.class.getResource("/img_settings/Log out sin sombra.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLog_outDir.setIcon(
						new ImageIcon(SettingsDirector.class.getResource("/img_settings/log out con sombre.png")));
			}
		});
		btnLog_outDir
				.setIcon(new ImageIcon(SettingsDirector.class.getResource("/img_settings/log out con sombre.png")));
		btnLog_outDir.setFocusPainted(false);
		btnLog_outDir.setContentAreaFilled(false);
		btnLog_outDir.setBorderPainted(false);
		btnLog_outDir.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnLog_outDir.setBounds(1096, 260, 122, 55);
		contentPane.add(btnLog_outDir);

		btnModify = new JButton("");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!btnEdit.isEnabled()) {
					myController.setNoEnableSettingsDirector();

				} else {
					myController.setEnableSettingsDirector();
				}
				myController.updateSettingsDirector();

			}
		});
		btnModify.setEnabled(false);
		btnModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnModify.setIcon(new ImageIcon(
						SettingsDirector.class.getResource("/img_tablesDirector/SettingsConfirm_noShadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnModify.setIcon(new ImageIcon(
						SettingsDirector.class.getResource("/img_tablesDirector/SettingsConfirm_Shadow.png")));
			}
		});

		btnModify.setIcon(
				new ImageIcon(SettingsDirector.class.getResource("/img_tablesDirector/SettingsConfirm_Shadow.png")));
		btnModify.setFocusPainted(false);
		btnModify.setContentAreaFilled(false);
		btnModify.setBorderPainted(false);
		btnModify.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnModify.setBounds(944, 580, 405, 90);
		contentPane.add(btnModify);

		lblPasswordError_1 = new JLabel("");
		lblPasswordError_1.setForeground(new Color(237, 46, 126));
		lblPasswordError_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPasswordError_1.setBounds(183, 547, 221, 14);
		contentPane.add(lblPasswordError_1);

		lblUserError = new JLabel("");
		lblUserError.setForeground(new Color(237, 46, 126));
		lblUserError.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserError.setBounds(183, 328, 156, 14);
		contentPane.add(lblUserError);

		lblPasswordErrorMatch_1 = new JLabel("");
		lblPasswordErrorMatch_1.setForeground(new Color(237, 46, 126));
		lblPasswordErrorMatch_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPasswordErrorMatch_1.setBounds(797, 547, 270, 14);
		contentPane.add(lblPasswordErrorMatch_1);

		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 15));
		lblUsername.setBounds(183, 268, 83, 14);
		contentPane.add(lblUsername);

		lblOldPwd = new JLabel("Old Password");
		lblOldPwd.setFont(new Font("Arial", Font.BOLD, 15));
		lblOldPwd.setBounds(184, 467, 122, 14);
		contentPane.add(lblOldPwd);

		lblNewPwd = new JLabel("New Password");
		lblNewPwd.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewPwd.setBounds(492, 467, 150, 14);
		contentPane.add(lblNewPwd);

		lblConfNewPwd = new JLabel("Confirm New Password");
		lblConfNewPwd.setFont(new Font("Arial", Font.BOLD, 15));
		lblConfNewPwd.setBounds(826, 467, 190, 14);
		contentPane.add(lblConfNewPwd);

		btnWatchPwdNew = new JButton("");
		btnWatchPwdNew.setIcon(new ImageIcon(SettingsDirector.class.getResource("/img_settings/View.png")));
		btnWatchPwdNew.setFocusPainted(false);
		btnWatchPwdNew.setContentAreaFilled(false);
		btnWatchPwdNew.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		btnWatchPwdNew.setBackground(Color.WHITE);
		btnWatchPwdNew.setBounds(492, 492, 49, 44);
		contentPane.add(btnWatchPwdNew);

		btnWatchConfPwd = new JButton("");
		btnWatchConfPwd.setIcon(new ImageIcon(SettingsDirector.class.getResource("/img_settings/View.png")));
		btnWatchConfPwd.setFocusPainted(false);
		btnWatchConfPwd.setContentAreaFilled(false);
		btnWatchConfPwd.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		btnWatchConfPwd.setBackground(Color.WHITE);
		btnWatchConfPwd.setBounds(816, 492, 46, 44);
		contentPane.add(btnWatchConfPwd);

		btnWatchOldPwd_1 = new JButton("");
		btnWatchOldPwd_1.setIcon(new ImageIcon(SettingsDirector.class.getResource("/img_settings/View.png")));
		btnWatchOldPwd_1.setFocusPainted(false);
		btnWatchOldPwd_1.setContentAreaFilled(false);
		btnWatchOldPwd_1.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		btnWatchOldPwd_1.setBackground(Color.WHITE);
		btnWatchOldPwd_1.setBounds(184, 492, 46, 44);
		contentPane.add(btnWatchOldPwd_1);

		txtUser = new JTextField();
		txtUser.setEditable(false);
		txtUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtUser.setColumns(10);
		txtUser.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		txtUser.setBounds(183, 293, 221, 33);
		contentPane.add(txtUser);

		txtNewPass = new JPasswordField();
		txtNewPass.setEditable(false);
		txtNewPass.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNewPass.setEchoChar('*');
		txtNewPass.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		txtNewPass.setBounds(538, 492, 175, 44);
		contentPane.add(txtNewPass);

		txtOldPass = new JPasswordField();
		txtOldPass.setEditable(false);
		txtOldPass.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtOldPass.setEchoChar('*');
		txtOldPass.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		txtOldPass.setBounds(229, 492, 175, 44);
		contentPane.add(txtOldPass);

		lblPhoto = new JLabel("Photo");
		lblPhoto.setFont(new Font("Arial", Font.BOLD, 15));
		lblPhoto.setBounds(492, 373, 83, 14);
		contentPane.add(lblPhoto);

		btnChoosePhoto = new JButton("");
		btnChoosePhoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnChoosePhoto.setIcon(new ImageIcon(
						SettingsDirector.class.getResource("/img_tablesDirector/choosePhoto_noShadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnChoosePhoto.setIcon(new ImageIcon(
						SettingsDirector.class.getResource("/img_tablesDirector/choosePhoto_Shadow.png")));
			}
		});
		btnChoosePhoto.setIcon(
				new ImageIcon(SettingsDirector.class.getResource("/img_tablesDirector/choosePhoto_Shadow.png")));
		btnChoosePhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.loadPhotoSettingsDir();
			}
		});
		btnChoosePhoto.setEnabled(false);
		btnChoosePhoto.setBounds(483, 398, 243, 58);
		btnChoosePhoto.setFocusPainted(false);
		btnChoosePhoto.setBorderPainted(false);
		btnChoosePhoto.setContentAreaFilled(false);
		btnChoosePhoto.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnChoosePhoto);

		txtConfirmNewPass = new JPasswordField();
		txtConfirmNewPass.setEditable(false);
		txtConfirmNewPass.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtConfirmNewPass.setEchoChar('*');
		txtConfirmNewPass.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		txtConfirmNewPass.setBounds(862, 492, 175, 44);
		contentPane.add(txtConfirmNewPass);

		btnEdit = new JButton("");
		btnEdit.setFocusPainted(false);
		btnEdit.setBorderPainted(false);
		btnEdit.setContentAreaFilled(false);
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEdit.setIcon(new ImageIcon(
						SettingsDirector.class.getResource("/img_tablesDirector/editSettings_noShadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnEdit.setIcon(new ImageIcon(
						SettingsDirector.class.getResource("/img_tablesDirector/editSettings_Shadow.png")));
			}
		});
		btnEdit.setIcon(
				new ImageIcon(SettingsDirector.class.getResource("/img_tablesDirector/editSettings_Shadow.png")));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (!btnModify.isEnabled()) {

					myController.setEnableSettingsDirector();
				} else {
					myController.setNoEnableSettingsDirector();
				}
			}
		});
		btnEdit.setBounds(1077, 527, 143, 52);
		contentPane.add(btnEdit);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial", Font.BOLD, 15));
		lblName.setBounds(492, 268, 83, 14);
		contentPane.add(lblName);

		lblLastname = new JLabel("Lastname");
		lblLastname.setFont(new Font("Arial", Font.BOLD, 15));
		lblLastname.setBounds(816, 268, 83, 14);
		contentPane.add(lblLastname);

		JLabel lblUserError_1 = new JLabel("");
		lblUserError_1.setForeground(new Color(237, 46, 126));
		lblUserError_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserError_1.setBounds(183, 433, 156, 14);
		contentPane.add(lblUserError_1);

		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Arial", Font.BOLD, 15));
		lblDni.setBounds(183, 373, 83, 14);
		contentPane.add(lblDni);

		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtName.setColumns(10);
		txtName.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		txtName.setBounds(490, 293, 221, 33);
		contentPane.add(txtName);

		txtLastname = new JTextField();
		txtLastname.setEditable(false);
		txtLastname.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtLastname.setColumns(10);
		txtLastname.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		txtLastname.setBounds(816, 293, 221, 33);
		contentPane.add(txtLastname);

		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtDni.setColumns(10);
		txtDni.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		txtDni.setBounds(183, 398, 221, 33);
		contentPane.add(txtDni);

		JLabel lblUserError_1_1 = new JLabel("");
		lblUserError_1_1.setForeground(new Color(237, 46, 126));
		lblUserError_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserError_1_1.setBounds(183, 527, 156, 14);
		contentPane.add(lblUserError_1_1);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmail.setBounds(816, 373, 83, 14);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		txtEmail.setBounds(816, 398, 221, 33);
		contentPane.add(txtEmail);

		JButton btnDNI = new JButton("Desencriptar");
		btnDNI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDNI.setBounds(1096, 403, 122, 28);
		contentPane.add(btnDNI);
	}

	// SETTERS

	public void setController(Controller myController) {
		this.myController = myController;
	}

	public void setModel(Model myModel) {
		this.myModel = myModel;
	}

	public void setLblPasswordErrorMatch_1(String lblPasswordErrorMatch_1) {
		this.lblPasswordErrorMatch_1.setText(lblPasswordErrorMatch_1);
	}

	public void setLblPasswordError_1(String lblPasswordError_1) {
		this.lblPasswordError_1.setText(lblPasswordError_1);
	}

	public void setTxtUser2(String usr) {
		this.txtUser.setText(usr);
	}

	public void setLblRol(String rol) {
		this.lblRol.setText(rol);
	}

	public void setTxtName(String name) {
		this.txtName.setText(name);
	}

	public void setTxtDni(String dni) {
		this.txtDni.setText(dni);
	}

	public void setTxtLastname(String lastname) {
		this.txtLastname.setText(lastname);
	}

	public void setLblNameDesc(String lbl) {
		this.lblNameDesc.setText(lbl);
	}

	public void setTxtEmail(String email) {
		this.txtEmail.setText(email);
	}

	public void setLblIconUser(Icon icon) {
		this.lblIconUser.setIcon(icon);
	}

	public void setLblIconUser2(String icon) {
		this.lblIconUser.setText(icon);
	}

	// GETTERS

	public String getTxtUser() {
		return txtUser.getText();
	}

	public String getLblRol() {
		return lblRol.getText();
	}

	public String getTxtName() {
		return txtName.getText();
	}

	public String getTxtDni() {
		return txtDni.getText();
	}

	public String getTxtLastname() {
		return txtLastname.getText();
	}

	public String getTxtNewPass() {
		return txtNewPass.getText();
	}

	public String getTxtOldPass() {
		return txtOldPass.getText();
	}

	public String getTxtConfirmNewPass() {
		return txtConfirmNewPass.getText();
	}

	public String getTxtEmail() {
		return txtEmail.getText();
	}

	public int getLblIconUserHeight() {
		return lblIconUser.getHeight();
	}

	public int getLblIconUserWidth() {
		return lblIconUser.getWidth();
	}

	// METHODS

	public void backManageStudent() {
		myController.ChangeWindows(6, 4);

	}

	public void setEnableSettings() {
		btnEdit.setEnabled(false);
		btnModify.setEnabled(true);
		txtConfirmNewPass.setEditable(true);
		btnWatchConfPwd.setEnabled(true);
		txtNewPass.setEditable(true);
		txtOldPass.setEditable(true);
		txtName.setEditable(true);
		txtLastname.setEditable(true);
		txtDni.setEditable(true);
		txtUser.setEditable(true);
		btnChoosePhoto.setEnabled(true);
		txtEmail.setEditable(true);

	}

	public void setNoEnableSettings() {
		btnEdit.setEnabled(true);
		btnModify.setEnabled(false);
		txtConfirmNewPass.setEditable(false);
		btnWatchConfPwd.setEnabled(false);
		txtNewPass.setEditable(false);
		txtOldPass.setEditable(false);
		btnModify.setEnabled(false);
		txtName.setEditable(false);
		txtLastname.setEditable(false);
		txtDni.setEditable(false);
		txtUser.setEditable(false);
		btnChoosePhoto.setEnabled(false);
		txtEmail.setEditable(false);

	}
}
