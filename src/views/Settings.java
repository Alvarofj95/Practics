
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

public class Settings extends JFrame implements Views {

	private Controller myController;
	private Model myModel;
	private JPanel contentPane, header;
	private JTextField txtUsername, txtName, txtLastName, txtDNI, txtEmail;
	private JPasswordField textNewPwd, textConfNewPwd, textOldPwd;
	private JLabel lblIconUser, lblRol, lblConfNewPwd, lblNewPwd, lblOldPwd, lblUsername, lblUser2, lblLogo, lblTitle,
			lblPasswordError, lblUserError, lblPasswordErrorMatch, lblDNI, lblName, lblLastName, lblDniError, lblImage;
	private JButton btnWatchOldPwd_1, btnWatchOldPwd, btnWatchConfPwd, btnWatchPwd, btnBack, btnModify, btnLog_outDir;
	private JButton btnChoosePhoto;
	private JLabel lblPhoto;
	private JButton btnEdit;

	// BUILDER

	public Settings() {

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

		lblPasswordError = new JLabel("");
		lblPasswordError.setForeground(new Color(237, 46, 126));
		lblPasswordError.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPasswordError.setBounds(189, 503, 192, 14);
		contentPane.add(lblPasswordError);

		lblUserError = new JLabel("");
		lblUserError.setForeground(new Color(237, 46, 126));
		lblUserError.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserError.setBounds(189, 398, 156, 14);
		contentPane.add(lblUserError);

		lblPasswordErrorMatch = new JLabel("");
		lblPasswordErrorMatch.setForeground(new Color(237, 46, 126));
		lblPasswordErrorMatch.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPasswordErrorMatch.setBounds(769, 528, 189, 14);
		contentPane.add(lblPasswordErrorMatch);

		lblUser2 = new JLabel("");
		lblUser2.setFont(new Font("Arial", Font.PLAIN, 29));
		lblUser2.setBounds(824, 126, 277, 104);
		contentPane.add(lblUser2);

		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 15));
		lblUsername.setBounds(189, 338, 83, 14);
		contentPane.add(lblUsername);

		lblOldPwd = new JLabel("Old Password");
		lblOldPwd.setFont(new Font("Arial", Font.BOLD, 15));
		lblOldPwd.setBounds(189, 448, 122, 14);
		contentPane.add(lblOldPwd);

		lblNewPwd = new JLabel("New Password");
		lblNewPwd.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewPwd.setBounds(479, 448, 150, 14);
		contentPane.add(lblNewPwd);

		lblConfNewPwd = new JLabel("Confirm New Password");
		lblConfNewPwd.setFont(new Font("Arial", Font.BOLD, 15));
		lblConfNewPwd.setBounds(768, 448, 190, 14);
		contentPane.add(lblConfNewPwd);

		lblRol = new JLabel("");
		lblRol.setForeground(new Color(95, 46, 234));
		lblRol.setFont(new Font("Arial", Font.BOLD, 15));
		lblRol.setBounds(167, 197, 49, 14);
		contentPane.add(lblRol);

		lblIconUser = new JLabel("");
		lblIconUser.setIcon(new ImageIcon(SettingsDirector.class.getResource("/img_settings/Frame.png")));
		lblIconUser.setBounds(1111, 118, 107, 112);
		contentPane.add(lblIconUser);

		lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDNI.setBounds(763, 241, 84, 14);
		contentPane.add(lblDNI);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial", Font.BOLD, 15));
		lblName.setBounds(190, 241, 56, 25);
		contentPane.add(lblName);

		lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Arial", Font.BOLD, 15));
		lblLastName.setBounds(479, 245, 107, 14);
		contentPane.add(lblLastName);

		lblDniError = new JLabel("");
		lblDniError.setForeground(new Color(237, 46, 126));
		lblDniError.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDniError.setBounds(767, 297, 210, 14);
		contentPane.add(lblDniError);

		btnModify = new JButton("");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!btnEdit.isEnabled()) {
					myController.setNoEnableSettings();

				} else {
					myController.setEnableSettings();
				}
				myController.updateSettings();
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
		btnModify.setBounds(1030, 571, 226, 90);
		btnModify.setBorderPainted(false);
		btnModify.setContentAreaFilled(false);
		btnModify.setFocusPainted(false);
		btnModify.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnModify);

		btnBack = new JButton("");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myController.ChangeWindows(6, 10);
				;
			}
		});

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
		btnBack.setBounds(61, 101, 95, 54);
		contentPane.add(btnBack);
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		btnWatchOldPwd = new JButton("");
		btnWatchOldPwd.setBackground(Color.WHITE);
		btnWatchOldPwd.setIcon(new ImageIcon(Settings.class.getResource("/img_settings/View.png")));
		btnWatchOldPwd.setBounds(0, 0, 46, 44);

		btnWatchPwd = new JButton("");
		btnWatchPwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnWatchPwd.setEnabled(false);
		btnWatchPwd.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		btnWatchPwd.setFocusPainted(false);
		btnWatchPwd.setContentAreaFilled(false);
		btnWatchPwd.setBackground(Color.WHITE);
		btnWatchPwd.setIcon(new ImageIcon(Settings.class.getResource("/img_settings/View.png")));
		btnWatchPwd.setBounds(479, 473, 49, 44);
		contentPane.add(btnWatchPwd);

		btnWatchConfPwd = new JButton("");
		btnWatchConfPwd.setEnabled(false);
		btnWatchConfPwd.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		btnWatchConfPwd.setFocusPainted(false);
		btnWatchConfPwd.setContentAreaFilled(false);
		btnWatchConfPwd.setBackground(Color.WHITE);
		btnWatchConfPwd.setIcon(new ImageIcon(Settings.class.getResource("/img_settings/View.png")));
		btnWatchConfPwd.setBounds(765, 473, 46, 44);
		contentPane.add(btnWatchConfPwd);

		btnWatchOldPwd_1 = new JButton("");
		btnWatchOldPwd_1.setEnabled(false);
		btnWatchOldPwd_1.setFocusPainted(false);
		btnWatchOldPwd_1.setContentAreaFilled(false);
		btnWatchOldPwd_1.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		btnWatchOldPwd_1.setIcon(new ImageIcon(Settings.class.getResource("/img_settings/View.png")));
		btnWatchOldPwd_1.setBackground(Color.WHITE);
		btnWatchOldPwd_1.setBounds(189, 473, 46, 44);
		contentPane.add(btnWatchOldPwd_1);

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
		// TEXTFIELDS

		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		txtName.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtName.setBounds(189, 271, 221, 32);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtLastName = new JTextField();
		txtLastName.setEditable(false);
		txtLastName.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		txtLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtLastName.setColumns(10);
		txtLastName.setBounds(479, 270, 221, 33);
		contentPane.add(txtLastName);

		txtDNI = new JTextField();
		txtDNI.setEditable(false);
		txtDNI.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtDNI.setBorder(new LineBorder(new Color(102, 51, 255), 2, true));
		txtDNI.setColumns(10);
		txtDNI.setBounds(763, 268, 221, 30);
		contentPane.add(txtDNI);

		txtUsername = new JTextField();
		txtUsername.setEditable(false);
		txtUsername.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		txtUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtUsername.setColumns(10);
		txtUsername.setBounds(188, 363, 221, 33);
		contentPane.add(txtUsername);

		textNewPwd = new JPasswordField();
		textNewPwd.setEditable(false);
		textNewPwd.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		textNewPwd.setFont(new Font("Tahoma", Font.BOLD, 11));
		textNewPwd.setEchoChar('*');
		textNewPwd.setBounds(525, 473, 175, 44);
		contentPane.add(textNewPwd);

		textConfNewPwd = new JPasswordField();
		textConfNewPwd.setEditable(false);
		textConfNewPwd.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		textConfNewPwd.setFont(new Font("Tahoma", Font.BOLD, 11));
		textConfNewPwd.setEchoChar('*');
		textConfNewPwd.setBounds(809, 473, 175, 44);
		contentPane.add(textConfNewPwd);

		textOldPwd = new JPasswordField();
		textOldPwd.setEditable(false);
		textOldPwd.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		textOldPwd.setFont(new Font("Tahoma", Font.BOLD, 11));
		textOldPwd.setEchoChar('*');
		textOldPwd.setBounds(234, 473, 175, 44);
		contentPane.add(textOldPwd);

		lblPhoto = new JLabel("Photo");
		lblPhoto.setFont(new Font("Arial", Font.BOLD, 15));
		lblPhoto.setBounds(479, 338, 83, 14);
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
		btnChoosePhoto.setBounds(463, 363, 243, 49);
		btnChoosePhoto.setFocusPainted(false);
		btnChoosePhoto.setBorderPainted(false);
		btnChoosePhoto.setContentAreaFilled(false);
		btnChoosePhoto.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnChoosePhoto);

		btnEdit = new JButton("");
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
		btnEdit.setFocusPainted(false);
		btnEdit.setContentAreaFilled(false);
		btnEdit.setBorderPainted(false);
		btnEdit.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!btnModify.isEnabled()) {

					myController.setEnableSettings();
				} else {
					myController.setNoEnableSettings();
				}
			}
		});

		btnEdit.setBounds(1077, 527, 143, 52);
		contentPane.add(btnEdit);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(765, 337, 84, 14);
		contentPane.add(lblEmail);

		JLabel lblDniError_1 = new JLabel("");
		lblDniError_1.setForeground(new Color(237, 46, 126));
		lblDniError_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDniError_1.setBounds(851, 387, 210, 14);
		contentPane.add(lblDniError_1);

		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtEmail.setColumns(10);
		txtEmail.setBorder(new LineBorder(new Color(102, 51, 255), 2, true));
		txtEmail.setBounds(763, 364, 221, 30);
		contentPane.add(txtEmail);

		lblImage = new JLabel("");
		lblImage.setBounds(46, 544, 200, 83);
		contentPane.add(lblImage);
	}

	// GETTERS

	public int getLblIconUserHeight() {
		return lblIconUser.getHeight();
	}

	public int getLblIconUserWidth() {
		return lblIconUser.getWidth();
	}

	public String getLblIconUserToDB() {
		return lblIconUser.getText();
	}

	public String getTxtEmail() {
		return txtEmail.getText();
	}

	public String getTxtUsername() {
		return txtUsername.getText();
	}

	public String getTxtName() {
		return txtName.getText();
	}

	public String getTxtLastName() {
		return txtLastName.getText();
	}

	public String getTxtDNI() {
		return txtDNI.getText();
	}

	public String getTextNewPwd() {
		return textNewPwd.getText();
	}

	public String getTextConfNewPwd() {
		return textConfNewPwd.getText();
	}

	public String getTextOldPwd() {
		return textOldPwd.getText();
	}

	// SETTERS

	public void setLblIconUser(Icon icon) {
		this.lblIconUser.setIcon(icon);
	}

	public void setTxtEmail(String txtEmail) {
		this.txtEmail.setText(txtEmail);
	}

	public void setLblPasswordError(String lblPasswordError) {
		this.lblPasswordError.setText(lblPasswordError);
	}

	public void setLblPasswordErrorMatch(String lblPasswordErrorMatch) {
		this.lblPasswordErrorMatch.setText(lblPasswordErrorMatch);
	}

	public void setLblUser2(String lblUser2) {
		this.lblUser2.setText(lblUser2);
		;
	}

	public void setTxtName(String txtName) {
		this.txtName.setText(txtName);
	}

	public void setTxtLastName(String txtLastName) {
		this.txtLastName.setText(txtLastName);
	}

	public void setTxtDNI(String txtDNI) {
		this.txtDNI.setText(txtDNI);
	}

	public void setLblRol(String lblRol) {
		this.lblRol.setText(lblRol);

	}

	public void setBtnModify() {
		this.btnModify.setEnabled(true);

	}

	public void setTxtUsername(String txtUsername) {
		this.txtUsername.setText(txtUsername);
	}

	public void setController(Controller myController) {
		this.myController = myController;
	}

	public void setModel(Model myModel) {
		this.myModel = myModel;
	}

	// METHODS

	public void setEnableSettings() {
		btnEdit.setEnabled(false);
		btnModify.setEnabled(true);
		textConfNewPwd.setEditable(true);
		btnWatchConfPwd.setEnabled(true);
		textNewPwd.setEditable(true);
		btnWatchPwd.setEnabled(true);
		textOldPwd.setEditable(true);
		btnWatchOldPwd_1.setEnabled(true);
		txtName.setEditable(true);
		txtLastName.setEditable(true);
		txtDNI.setEditable(true);
		txtUsername.setEditable(true);
		btnChoosePhoto.setEnabled(true);
		txtEmail.setEditable(true);
	}

	public void setNoEnableSettings() {
		btnEdit.setEnabled(true);
		btnModify.setEnabled(false);
		textConfNewPwd.setEditable(false);
		btnWatchConfPwd.setEnabled(false);
		textNewPwd.setEditable(false);
		btnWatchPwd.setEnabled(false);
		textOldPwd.setEditable(false);
		btnWatchOldPwd_1.setEnabled(false);
		btnModify.setEnabled(false);
		txtName.setEditable(false);
		txtLastName.setEditable(false);
		txtDNI.setEditable(false);
		txtUsername.setEditable(false);
		btnChoosePhoto.setEnabled(false);
		txtEmail.setEditable(false);

	}

	public void eyeVisibleOld() {
		if (textOldPwd.getEchoChar() == '*') {
			textOldPwd.setEchoChar((char) 0);
		} else {
			textOldPwd.setEchoChar('*');
		}

	}

	public void eyeVisbleNew() {
		if (textNewPwd.getEchoChar() == '*') {
			textNewPwd.setEchoChar((char) 0);
		} else {
			textNewPwd.setEchoChar('*');
		}

	}

	public void eyeVisbleConfirm() {
		if (textConfNewPwd.getEchoChar() == '*') {
			textConfNewPwd.setEchoChar((char) 0);
		} else {
			textConfNewPwd.setEchoChar('*');
		}

	}

	public void updateFields() {
		txtName.getText();
		txtLastName.getText();
		txtUsername.getText();
		myController.ChangeWindows(12, 3);
		textOldPwd.setText(null);
		textConfNewPwd.setText(null);
		textNewPwd.setText(null);

	}

}