package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.Controller;
import model.Model;

public class SignUp extends JFrame implements Views {

	private Controller myController;
	private Model myModel;

	private JPanel contentPane;
	private JTextField txtName, txtLastName, txtUsername, txtEmail, txtDNI, txtPass;
	private JButton btnConfirm, btnBack;
	private JRadioButton rdbtnTermsOfService;
	private JCheckBox chckbxNotRobot;
	private JLabel lblEmailError, lblUserError, lblDniError, lblErrorGeneral, lblPasswordErrorMatch, lblDNI,
			lblEmail, lblUsername, lblName, lblLastName_1, lblSignUp, lblLogo;
	
	//BUILDER

	public SignUp() {

		// GENERAL
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//LOGO TITLE 
		
		lblLogo = new JLabel("PracTICS");
		lblLogo.setIcon(new ImageIcon(SettingsDirector.class.getResource("/img_tablesDirector/logo.png")));
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Segoe UI Light", Font.PLAIN, 34));
		lblLogo.setBounds(999, 68, 236, 76);
		contentPane.add(lblLogo);

		// TITLE
		
		lblSignUp = new JLabel("Sign up");
		lblSignUp.setFont(new Font("Arial Black", Font.PLAIN, 27));
		lblSignUp.setBounds(201, 92, 123, 52);
		contentPane.add(lblSignUp);

		// LASTNAME TAG
		
		lblLastName_1 = new JLabel("Last name");
		lblLastName_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastName_1.setBounds(850, 200, 72, 14);
		contentPane.add(lblLastName_1);

		// NAME TAG
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblName.setBounds(524, 199, 84, 14);
		contentPane.add(lblName);

		// USER TAG
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(201, 200, 84, 14);
		contentPane.add(lblUsername);
		
		
		// EMAIL TAG
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(850, 317, 218, 14);
		contentPane.add(lblEmail);

		// TAG ERROR PASS
		
		lblEmailError = new JLabel("");
		lblEmailError.setForeground(new Color(237, 46, 126));
		lblEmailError.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmailError.setBounds(850, 384, 258, 14);
		contentPane.add(lblEmailError);

		// TAG EXISTS USER
		lblUserError = new JLabel("");
		lblUserError.setForeground(new Color(237, 46, 126));
		lblUserError.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserError.setBounds(202, 266, 257, 14);
		contentPane.add(lblUserError);

		// TAG DNI ERROR
		
		lblDniError = new JLabel("");
		lblDniError.setForeground(new Color(237, 46, 126));
		lblDniError.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDniError.setBounds(201, 384, 258, 14);
		contentPane.add(lblDniError);

		// TAG GENERAL ERROR
		
		lblErrorGeneral = new JLabel("");
		lblErrorGeneral.setForeground(new Color(237, 46, 126));
		lblErrorGeneral.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblErrorGeneral.setBounds(561, 512, 221, 14);
		contentPane.add(lblErrorGeneral);

		//TAG FIELDS ERROR MATCH
		
		lblPasswordErrorMatch = new JLabel("");
		lblPasswordErrorMatch.setForeground(new Color(237, 46, 126));
		lblPasswordErrorMatch.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPasswordErrorMatch.setBounds(523, 390, 258, 14);
		contentPane.add(lblPasswordErrorMatch);

		// USERS FIELDS
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtUsername.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		txtUsername.setColumns(10);
		txtUsername.setBounds(201, 225, 258, 30);
		contentPane.add(txtUsername);
		
		// NAME FIELDS
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtName.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		txtName.setBounds(524, 225, 258, 30);
		contentPane.add(txtName);
		txtName.setColumns(10);

		// FIELD LASTNAME 1
		
		txtLastName = new JTextField();
		txtLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtLastName.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		txtLastName.setColumns(10);
		txtLastName.setBounds(851, 225, 257, 30);
		contentPane.add(txtLastName);

		// FIELD EMAIL
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtEmail.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		txtEmail.setColumns(10);
		txtEmail.setBounds(850, 343, 258, 30);
		contentPane.add(txtEmail);

		// BUTTON SERVICES
		
		rdbtnTermsOfService = new JRadioButton(
				"I agree that I have read and accepted the Terms of Use and Privacy Policy.");
		rdbtnTermsOfService.setBackground(Color.WHITE);
		rdbtnTermsOfService.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnTermsOfService.setBounds(178, 439, 613, 36);
		rdbtnTermsOfService.setFocusPainted(false);
		rdbtnTermsOfService.setIcon(null);
		contentPane.add(rdbtnTermsOfService);

		// BUTTON CONFIRM
		
		btnConfirm = new JButton("");

		btnConfirm.setEnabled(false);
		btnConfirm.setFocusPainted(false);
		btnConfirm.setBorderPainted(false);
		btnConfirm.setContentAreaFilled(false);
		btnConfirm.setForeground(new Color(255, 255, 255));
		btnConfirm.setBackground(new Color(138, 43, 226));
		btnConfirm.setBounds(811, 533, 297, 89);
		btnConfirm.setIcon(
				new ImageIcon(SignUp.class.getResource("/img_tablesDirector/Confir_Shadow.png")));
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConfirm.setIcon(
						new ImageIcon(SignUp.class.getResource("/img_tablesDirector/Confirm_noShadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnConfirm.setIcon(
						new ImageIcon(SignUp.class.getResource("/img_tablesDirector/Confir_Shadow.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				myController.signedUp();
			}
		});

		contentPane.add(btnConfirm);

		// BACK ARROW
		
		btnBack = new JButton("");
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setIcon(new ImageIcon(SignUp.class.getResource("/img_tablesDirector/backArrow_Shadow.png")));
		btnBack.setBounds(41, 59, 93, 48);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myController.back();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setIcon(new ImageIcon(SignUp.class.getResource("/img_tablesDirector/backArrow_noShadow.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBack.setIcon(new ImageIcon(SignUp.class.getResource("/img_tablesDirector/backArrow_Shadow.png")));
			}
		});

		contentPane.add(btnBack);

		// DNI FIELD
		
		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtDNI.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		txtDNI.setColumns(10);
		txtDNI.setBounds(201, 343, 258, 30);
		contentPane.add(txtDNI);

		// DNI TAG
		
		lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDNI.setBounds(201, 317, 84, 14);
		contentPane.add(lblDNI);

		// BUTTON NO ROBOT
		
		chckbxNotRobot = new JCheckBox("I'm not a robot");
		chckbxNotRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				captureFields();
			}

		});
		chckbxNotRobot.setIcon(null);
		chckbxNotRobot.setContentAreaFilled(false);
		chckbxNotRobot.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		chckbxNotRobot.setFocusPainted(false);
		chckbxNotRobot.setBounds(178, 491, 156, 35);
		chckbxNotRobot.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(chckbxNotRobot);

		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPass.setBounds(524, 316, 84, 14);
		contentPane.add(lblPass);

		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtPass.setColumns(10);
		txtPass.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		txtPass.setBounds(524, 342, 257, 30);
		contentPane.add(txtPass);

	}

	public void captureFields() {
		if (txtName.getText().length() > 0 && txtLastName.getText().length() > 0 && txtUsername.getText().length() > 0
				&& txtEmail.getText().length() > 0 && txtDNI.getText().length() > 0 && rdbtnTermsOfService.isSelected()
				&& chckbxNotRobot.isSelected()) {
			btnConfirm.setEnabled(true);

		} else {
			btnConfirm.setEnabled(false);
		}

	}

	public void back() {
		myController.backLoginFromSignUp();

	}

	public void backLoginFromSignUp() {
		txtName.setText(null);
		txtLastName.setText(null);
		txtUsername.setText(null);
		txtUsername.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		txtEmail.setText(null);
		txtEmail.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		txtDNI.setText(null);
		txtDNI.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		txtPass.setText(null);
		lblUserError.setText(null);
		lblEmailError.setText(null);
		lblDniError.setText(null);
		btnConfirm.setEnabled(false);
		chckbxNotRobot.setSelected(false);
		rdbtnTermsOfService.setSelected(false);
		myController.ChangeWindows(1, 0);

	}

	// GETTERS
	
	public String getTxtName() {
		return txtName.getText();
	}

	public String getTxtLastName() {
		return txtLastName.getText();
	}

	public String getTxtUsername() {
		return txtUsername.getText();
	}

	public String getTxtEmail() {
		return txtEmail.getText();
	}

	public String getTxtDNI() {
		return txtDNI.getText();
	}

	public String getTxtPass() {
		return txtPass.getText();
	}

	// SETTERS
	
	public void setLblErrorGeneral(String lblErrorGeneral) {
		this.lblErrorGeneral.setText(lblErrorGeneral);
	}
	
	public void setLblEmailError(String lblEmailError) {
		this.lblEmailError.setText(lblEmailError);
		txtEmail.setBorder(new LineBorder(new Color(237, 46, 126), 2, true));
	}

	public void setLblUserError(String lblUserError) {
		this.lblUserError.setText(lblUserError);
		txtUsername.setBorder(new LineBorder(new Color(237, 46, 126), 2, true));
	}

	public void setLblDniError(String lblDniError) {
		this.lblDniError.setText(lblDniError);
		txtDNI.setBorder(new LineBorder(new Color(237, 46, 126), 2, true));
	}

	public void setController(Controller myController) {
		this.myController = myController;
	}

	public void setModel(Model myModel) {
		this.myModel = myModel;
	}

	public void setTxtName(String name) {
		this.txtName.setText(name);
	}

	public void setTxtLastName(String lastName) {
		this.txtLastName.setText(lastName);
	}

	public void setTxtUsername(String username) {
		this.txtUsername.setText(username);
	}

	public void setTxtEmail(String email) {
		this.txtEmail.setText(email);
	}

	public void setTxtDNI(String DNI) {
		this.txtDNI.setText(DNI);
	}

	public void setTxtPass(String pass) {
		this.txtPass.setText(pass);
	}
}
