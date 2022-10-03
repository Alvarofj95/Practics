package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import model.Model;

public class UpdateFromDirector extends JFrame implements Views {

	private Controller myController;
	private Model myModel;
	private JPanel contentPane, header;
	private JLabel lblLogo, lblTitle;
	private DefaultTableModel modelDir;
	private JButton btnbackArrow;
	private JTextField txt8;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt9;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt10;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt7;
	private JButton btnConfirm;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private JLabel lbl10;
	private JLabel lbl9;

	public UpdateFromDirector() {

		// PANELS

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// HEADER
		header = new JPanel();
		header.setBackground(new Color(239, 240, 246));
		header.setBounds(0, 0, 1280, 80);
		contentPane.add(header);
		header.setLayout(null);
		// LABELS

		lblLogo = new JLabel("PracTICS");
		lblLogo.setIcon(new ImageIcon(UpdateFromTutor.class.getResource("/IMGStudents/logoPractics.png")));
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Segoe UI Light", Font.PLAIN, 34));
		lblLogo.setBounds(38, -3, 233, 80);
		header.add(lblLogo);

		lblTitle = new JLabel("Modify Data");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(95, 46, 234));
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 40));
		lblTitle.setBounds(472, 3, 363, 76);
		header.add(lblTitle);

		// BUTTONS

		btnbackArrow = new JButton("");
		btnbackArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnbackArrow.setIcon(new ImageIcon(
						UpdateFromDirector.class.getResource("/img_tablesDirector/backArrow_noShadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnbackArrow.setIcon(new ImageIcon(
						UpdateFromDirector.class.getResource("/img_tablesDirector/backArrow_Shadow.png")));
			}
		});
		btnbackArrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.ChangeWindows(12, 7);
				myController.showFieldsFromUpdateFromDirector();
				refreshlBls();
			}

		});
		btnbackArrow.setIcon(
				new ImageIcon(UpdateFromDirector.class.getResource("/img_tablesDirector/backArrow_Shadow.png")));
		btnbackArrow.setBackground(Color.WHITE);
		btnbackArrow.setBounds(10, 87, 83, 40);
		btnbackArrow.setFocusPainted(false);
		btnbackArrow.setBorderPainted(false);
		btnbackArrow.setContentAreaFilled(false);
		btnbackArrow.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnbackArrow);

		txt8 = new JTextField();
		txt8.setBounds(662, 425, 166, 20);
		contentPane.add(txt8);
		txt8.setColumns(10);

		txt1 = new JTextField();
		txt1.setColumns(10);
		txt1.setBounds(456, 197, 166, 20);
		contentPane.add(txt1);

		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(660, 197, 166, 20);
		contentPane.add(txt2);

		txt9 = new JTextField();
		txt9.setColumns(10);
		txt9.setBounds(456, 495, 166, 20);
		contentPane.add(txt9);

		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(456, 275, 166, 20);
		contentPane.add(txt3);

		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(660, 275, 166, 20);
		contentPane.add(txt4);

		txt10 = new JTextField();
		txt10.setColumns(10);
		txt10.setBounds(662, 495, 166, 20);
		contentPane.add(txt10);

		txt5 = new JTextField();
		txt5.setColumns(10);
		txt5.setBounds(456, 346, 166, 20);
		contentPane.add(txt5);

		txt6 = new JTextField();
		txt6.setColumns(10);
		txt6.setBounds(662, 346, 166, 20);
		contentPane.add(txt6);

		txt7 = new JTextField();
		txt7.setColumns(10);
		txt7.setBounds(458, 425, 166, 20);
		contentPane.add(txt7);

		btnConfirm = new JButton("");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConfirm.setIcon(new ImageIcon(
						UpdateFromDirector.class.getResource("/img_tablesDirector/Confirm_noShadow.png")));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnConfirm.setIcon(
						new ImageIcon(UpdateFromDirector.class.getResource("/img_tablesDirector/Confir_Shadow.png")));

			}
		});
		btnConfirm
				.setIcon(new ImageIcon(UpdateFromDirector.class.getResource("/img_tablesDirector/Confir_Shadow.png")));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.updateFieldsDirector();
			}
		});
		btnConfirm.setBounds(525, 541, 227, 76);
		btnConfirm.setFocusPainted(false);
		btnConfirm.setBorderPainted(false);
		btnConfirm.setContentAreaFilled(false);
		btnConfirm.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnConfirm);

		lbl1 = new JLabel("");
		lbl1.setBounds(455, 172, 167, 14);
		contentPane.add(lbl1);

		lbl2 = new JLabel("");
		lbl2.setBounds(662, 172, 164, 14);
		contentPane.add(lbl2);

		lbl3 = new JLabel("");
		lbl3.setBounds(456, 250, 166, 14);
		contentPane.add(lbl3);

		lbl4 = new JLabel("");
		lbl4.setBounds(662, 250, 164, 14);
		contentPane.add(lbl4);

		lbl5 = new JLabel("");
		lbl5.setBounds(456, 321, 166, 14);
		contentPane.add(lbl5);

		lbl6 = new JLabel("");
		lbl6.setBounds(662, 321, 160, 14);
		contentPane.add(lbl6);

		lbl7 = new JLabel("");
		lbl7.setBounds(456, 401, 146, 14);
		contentPane.add(lbl7);

		lbl8 = new JLabel("");
		lbl8.setBounds(662, 400, 160, 14);
		contentPane.add(lbl8);

		lbl9 = new JLabel("");
		lbl9.setBounds(456, 470, 166, 14);
		contentPane.add(lbl9);

		lbl10 = new JLabel("");
		lbl10.setBounds(662, 470, 166, 14);
		contentPane.add(lbl10);

		JButton btnDesencriptar = new JButton("Desencriptar");
		btnDesencriptar.addActionListener(new ActionListener() {
			boolean encriptado = true;
			String dniEncriptado;

			public void actionPerformed(ActionEvent e) {
				if (encriptado) {
					dniEncriptado = txt2.getText();
					txt2.setText(desencriptar(dniEncriptado));
					btnDesencriptar.setText("Encriptar");
					encriptado = false;
				} else {
					encriptado = true;
					btnDesencriptar.setText("Desencriptar");
					txt2.setText(dniEncriptado);
				}
			}
		});
		btnDesencriptar.setBounds(866, 196, 123, 23);
		contentPane.add(btnDesencriptar);

	}

	//Desencriptado simetrico
	private String desencriptar(String mensaje) {
		String clave = "b5dsi329v9snsdls";
		String mensajeDescifrado = "";
		try {
			Key keygen = new SecretKeySpec(clave.getBytes(), "AES");
			Cipher aesCipher = Cipher.getInstance("AES");
			aesCipher.init(Cipher.DECRYPT_MODE, keygen);
			mensajeDescifrado = new String(aesCipher.doFinal(mensaje.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mensajeDescifrado;
	}

	// GETTERS

	private void refreshlBls() {
		setLbl1(null);
		setLbl2(null);
		setLbl3(null);
		setLbl4(null);
		setLbl5(null);
		setLbl6(null);
		setLbl7(null);
		setLbl8(null);
		setLbl9(null);
		setLbl10(null);

	}

	public String getTxt1() {
		return txt1.getText();
	}

	public JTextField getTxt1_2() {
		return txt1;
	}

	public String getTxt2() {
		return txt2.getText();
	}

	public JTextField getTxt2_2() {
		return txt2;
	}

	public String getTxt3() {
		return txt3.getText();
	}

	public JTextField getTxt3_2() {
		return txt3;
	}

	public String getTxt4() {

		return txt4.getText();
	}

	public JTextField getTxt4_2() {

		return txt4;
	}

	public String getTxt5() {

		return txt5.getText();
	}

	public JTextField getTxt5_2() {

		return txt5;
	}

	public String getTxt6() {
		return txt6.getText();
	}

	public JTextField getTxt6_2() {
		return txt6;
	}

	public String getTxt7() {
		return txt7.getText();
	}

	public JTextField getTxt7_2() {
		return txt7;
	}

	public String getTxt8() {
		return txt8.getText();
	}

	public JTextField getTxt8_2() {
		return txt8;
	}

	public String getTxt9() {
		return txt9.getText();
	}

	public JTextField getTxt9_2() {
		return txt9;
	}

	public String getTxt10() {
		return txt10.getText();
	}

	public JTextField getTxt10_2() {
		return txt10;
	}

	public Controller getController() {
		return myController;
	}

	public Model getModel() {
		return myModel;
	}

	// SETTERS
	public void setLbl9(String lbl) {
		this.lbl9.setText(lbl);
	}

	public void setLbl1(String lbl) {
		this.lbl1.setText(lbl);
	}

	public void setLbl2(String lbl) {
		this.lbl2.setText(lbl);
	}

	public void setLbl3(String lbl) {
		this.lbl3.setText(lbl);
	}

	public void setLbl4(String lbl) {
		this.lbl4.setText(lbl);
	}

	public void setLbl5(String lbl) {
		this.lbl5.setText(lbl);
	}

	public void setLbl6(String lbl) {
		this.lbl6.setText(lbl);
	}

	public void setLbl7(String lbl) {
		this.lbl7.setText(lbl);
	}

	public void setLbl8(String lbl) {
		this.lbl8.setText(lbl);
	}

	public void setLbl10(String lbl) {
		this.lbl10.setText(lbl);
	}

	public void setTxt3(String txt) {
		this.txt3.setText(txt);
	}

	public void setTxt1(String txt) {
		this.txt1.setText(txt);
	}

	public void setTxt2(String txt) {
		this.txt2.setText(txt);
	}

	public void setTxt9(String txt) {
		this.txt9.setText(txt);
	}

	public void setTxt10(String txt) {
		this.txt10.setText(txt);
	}

	public void setTxt4(String txt) {
		this.txt4.setText(txt);
	}

	public void setTxt5(String txt) {
		this.txt5.setText(txt);
	}

	public void setTxt6(String text) {
		this.txt6.setText(text);
	}

	public void setTxt7(String txt) {
		this.txt7.setText(txt);
	}

	public void setTxt8(String txt) {
		this.txt8.setText(txt);
	}

	public void setController(Controller myController) {
		this.myController = myController;

	}

	public void setModel(Model myModel) {
		this.myModel = myModel;

	}
}
