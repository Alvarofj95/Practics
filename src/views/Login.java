package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.Controller;
import model.Model;
import javax.swing.SwingConstants;

public class Login extends JFrame implements Views {

	private JPanel contentPane, PanelEyeAndPwd;
	private JTextField txtUser;
	private JPasswordField pwdPassword;
	private JButton btnSignUp, btnLogin, btnSupport, btnEye, btnDBConnection;
	private JLabel lblRememberPassword, lblDonthaveAccount, lblPassword, lblUser, lblLogin, lblPractics, lblSupport,
			lblErrorUsrAndPwd, lblErrorConnectDB;
	private Controller myController;
	private Model myModel; 

	// BUILDER

	public Login() {
		myModel = new Model();
		myController = new Controller();

		// PANELS

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 0, 51));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		PanelEyeAndPwd = new JPanel();
		PanelEyeAndPwd.setBorder(new LineBorder(new Color(102, 0, 204), 1, true));
		PanelEyeAndPwd.setBackground(Color.WHITE);
		PanelEyeAndPwd.setBounds(739, 305, 303, 56);
		contentPane.add(PanelEyeAndPwd);
		PanelEyeAndPwd.setLayout(null);

		// LABELS

		lblPractics = new JLabel("");
		lblPractics.setBounds(160, 310, 410, 109);
		lblPractics.setIcon(new ImageIcon(Login.class.getResource("/img/img_login/Login.png")));
		contentPane.add(lblPractics);

		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Arial Black", Font.PLAIN, 32));
		lblLogin.setBounds(741, 77, 129, 57);
		contentPane.add(lblLogin);

		lblUser = new JLabel("User");
		lblUser.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblUser.setBounds(739, 144, 79, 19);
		contentPane.add(lblUser);

		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPassword.setBounds(741, 255, 99, 19);
		contentPane.add(lblPassword);

		lblDonthaveAccount = new JLabel("Don't have an account?");
		lblDonthaveAccount.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblDonthaveAccount.setBounds(739, 589, 257, 23);
		contentPane.add(lblDonthaveAccount);

		lblRememberPassword = new JLabel("Don't remember your password?");
		lblRememberPassword.setForeground(new Color(95, 46, 234));
		lblRememberPassword.setFont(new Font("SansSerif", Font.BOLD, 16));

		lblRememberPassword.setBounds(739, 555, 353, 23);
		contentPane.add(lblRememberPassword);

		lblSupport = new JLabel("");
		lblSupport.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblSupport.setForeground(new Color(237, 46, 126));
		lblSupport.setBounds(752, 46, 308, 47);
		contentPane.add(lblSupport);

		lblErrorUsrAndPwd = new JLabel("");
		lblErrorUsrAndPwd.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblErrorUsrAndPwd.setBounds(739, 374, 258, 14);
		lblErrorUsrAndPwd.setForeground(new Color(237, 46, 126));
		contentPane.add(lblErrorUsrAndPwd);

		lblErrorConnectDB = new JLabel("");
		lblErrorConnectDB.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblErrorConnectDB.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorConnectDB.setBounds(739, 431, 303, 14);
		lblErrorConnectDB.setForeground(new Color(237, 46, 126));
		contentPane.add(lblErrorConnectDB);

		// TEXTFIELDS

		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtUser.setBorder(new LineBorder(new Color(102, 0, 204), 1, true));
		txtUser.setBounds(739, 179, 303, 56);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(10, 11, 153, 36);
		PanelEyeAndPwd.add(pwdPassword);
		pwdPassword.setEchoChar('*');
		pwdPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		pwdPassword.setBorder(new LineBorder(new Color(102, 0, 204), 0));

		// BUTTONS

		btnLogin = new JButton("");
		btnLogin.setFocusPainted(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/img/img_login/Button_Login_Shadow.png")));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setBackground(new Color(138, 43, 226));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBounds(739, 419, 308, 101);
		contentPane.add(btnLogin);

		btnSignUp = new JButton("");
		btnSignUp.setIcon(new ImageIcon(Login.class.getResource("/img/img_login/Sign Up shadow .png")));
		btnSignUp.setBackground(new Color(138, 43, 226));
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSignUp.setBounds(935, 585, 115, 47);
		btnSignUp.setFocusPainted(false);
		btnSignUp.setBorderPainted(false);
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnSignUp);

		btnSupport = new JButton("");
		btnSupport.setVisible(false);
		btnSupport.setEnabled(false);
		btnSupport.setSize(new Dimension(9, 5));
		btnSupport.setContentAreaFilled(false);
		btnSupport.setIcon(new ImageIcon(Login.class.getResource("/img/img_login/support s.png")));
		btnSupport.setFocusPainted(false);
		btnSupport.setBorderPainted(false);
		btnSupport.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnSupport.setBounds(1072, 46, 129, 47);
		contentPane.add(btnSupport);

		btnDBConnection = new JButton("");
		btnDBConnection.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDBConnection
						.setIcon(new ImageIcon(Login.class.getResource("/img/img_login/Connect DB no shadow .png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnDBConnection
						.setIcon(new ImageIcon(Login.class.getResource("/img/img_login/Connect DB shadow .png")));
			}
		});
		btnDBConnection.setIcon(new ImageIcon(Login.class.getResource("/img/img_login/Connect DB shadow .png")));
		btnDBConnection.setFocusPainted(false);
		btnDBConnection.setBorderPainted(false);
		btnDBConnection.setContentAreaFilled(false);
		btnDBConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.ChangeWindows(0, 15);
				myController.loadFile();
			}
		});
		btnDBConnection.setBounds(817, 390, 153, 47);
		contentPane.add(btnDBConnection);

		btnEye = new JButton("");
		btnEye.setBounds(1035, 305, 40, 47);
		contentPane.add(btnEye);
		btnEye.setIcon(new ImageIcon(Login.class.getResource("/img/img_login/eye.png")));
		btnEye.setFocusPainted(false);
		btnEye.setBorderPainted(false);
		btnEye.setContentAreaFilled(false);
		btnEye.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		// LISTENERS
		btnEye.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEye.setIcon(new ImageIcon(Login.class.getResource("/img/img_login/eye.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnEye.setIcon(new ImageIcon(Login.class.getResource("/img/img_login/eye.png")));
			}
		});

		btnEye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eyeVisibleLogin();
			}
		});

		btnSupport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSupport.setIcon(new ImageIcon(Login.class.getResource("/img/img_login/support ns.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSupport.setIcon(new ImageIcon(Login.class.getResource("/img/img_login/support s.png")));
			}

		});
		btnSupport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.ChangeWindows(0, 5);
			}

		});

		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSignUp.setIcon(new ImageIcon(Login.class.getResource("/img/img_login/Sign Up no shadow .png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSignUp.setIcon(new ImageIcon(Login.class.getResource("/img/img_login/Sign Up shadow .png")));
			}
		});

		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.ChangeWindows(0, 1);
			}

		});

		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setIcon(new ImageIcon(Login.class.getResource("/img/img_login/Button_Login_No_Shadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setIcon(new ImageIcon(Login.class.getResource("/img/img_login/Button_Login_Shadow.png")));
			}
		});

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					myController.accessDB();
					
				} catch (Exception e) {
					setLblErrorConnectDB("You need to connect to the DB");
					btnLogin.setBounds(739, 443, 308, 101);

				}
			}
		});

		lblRememberPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRememberPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblRememberPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				myController.ChangeWindows(0, 2);
			}
		});
	}

	// SETTERS

	public void setLblErrorConnectDB(String lblErrorConnectDB) {
		this.lblErrorConnectDB.setText(lblErrorConnectDB);
	}

	public void setController(Controller myController) {
		this.myController = myController;
	}

	public void setModel(Model myModel) {
		this.myModel = myModel;
	}

	public void setLblSupport(String error) {
		this.lblSupport.setText(error);
	}

	public void setBtnSupport() {
		this.btnSupport.setEnabled(true);
		this.btnSupport.setVisible(true);
	}

	public void setLblErrorUsrAndPwd(String error) {
		this.lblErrorUsrAndPwd.setText(error);
	}

	public void setPanelEyeAndPwd() {
		this.PanelEyeAndPwd.setBorder(new LineBorder(new Color(237, 46, 126), 2, true));
	}

	public void setTxtUser() {
		this.txtUser.setBorder(new LineBorder(new Color(237, 46, 126), 2, true));
	}

	public void setBtnLogin() {
		this.btnLogin.setBounds(739, 419, 308, 101);
	}
	// GETTERS

	public String getUser() {
		return txtUser.getText();
	}

	public String getPassw() {
		return String.valueOf(pwdPassword.getPassword());
	}

	// METHODS

	public void eyeVisibleLogin() {
		if (pwdPassword.getEchoChar() == '*') {
			pwdPassword.setEchoChar((char) 0);
		} else {
			pwdPassword.setEchoChar('*');
		}
	}

	public void grantedAccessDirector() {
		myController.ChangeWindows(0, 7);
	}

	public void grantedAccessTutor() {

		myController.ChangeWindows(0, 10);

	}
}
