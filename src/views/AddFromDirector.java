package views;

import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import model.Model;

public class AddFromDirector extends JFrame implements Views {

	private Controller myController;
	private Model myModel;
	private JPanel contentPane, header;
	private JLabel lblLogo, lblTitle;
	private DefaultTableModel modelDir;
	private JButton btnbackArrow;
	private JTextField txt10;
	private JLabel lbl8;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt7;
	private JTextField txt8;
	private JTextField txt9;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl9;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl10;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JButton btnConfirm;
	private JLabel lblInformation;

	public AddFromDirector() {

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
		header.setBounds(0, 0, 1600, 76);
		contentPane.add(header);
		header.setLayout(null);

		// LABELS

		lblLogo = new JLabel("PracTICS");
		lblLogo.setIcon(new ImageIcon(AddFromDirector.class.getResource("/img_tablesDirector/logo.png")));
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Segoe UI Light", Font.PLAIN, 34));
		lblLogo.setBounds(10, 0, 236, 76);
		header.add(lblLogo);

		lblTitle = new JLabel("Add data");
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
				btnbackArrow.setIcon(
						new ImageIcon(AddFromDirector.class.getResource("/img_tablesDirector/backArrow_noShadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnbackArrow.setIcon(
						new ImageIcon(AddFromDirector.class.getResource("/img_tablesDirector/backArrow_Shadow.png")));
			}
		});
		btnbackArrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.ChangeWindows(9, 7);
				setFieldsTrue();
				setLablesFalse();
			}

		});
		btnbackArrow
				.setIcon(new ImageIcon(AddFromDirector.class.getResource("/img_tablesDirector/backArrow_Shadow.png")));
		btnbackArrow.setBackground(Color.WHITE);
		btnbackArrow.setBounds(0, 81, 142, 48);
		btnbackArrow.setFocusPainted(false);
		btnbackArrow.setBorderPainted(false);
		btnbackArrow.setContentAreaFilled(false);
		btnbackArrow.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnbackArrow);

		txt10 = new JTextField();
		txt10.setBounds(660, 463, 166, 20);
		contentPane.add(txt10);
		txt10.setColumns(10);

		lbl8 = new JLabel("");
		lbl8.setBounds(660, 379, 166, 14);
		contentPane.add(lbl8);

		txt1 = new JTextField();
		txt1.setColumns(10);
		txt1.setBounds(456, 197, 166, 20);
		contentPane.add(txt1);

		lbl1 = new JLabel("");
		lbl1.setBounds(454, 172, 157, 14);
		contentPane.add(lbl1);

		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(660, 197, 166, 20);
		contentPane.add(txt2);

		lbl2 = new JLabel("");
		lbl2.setBounds(658, 172, 168, 14);
		contentPane.add(lbl2);

		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(456, 275, 166, 20);
		contentPane.add(txt3);

		lbl9 = new JLabel("");
		lbl9.setBounds(456, 435, 166, 14);
		contentPane.add(lbl9);

		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(660, 275, 166, 20);
		contentPane.add(txt4);

		lbl3 = new JLabel("");
		lbl3.setBounds(454, 250, 157, 14);
		contentPane.add(lbl3);

		txt5 = new JTextField();
		txt5.setColumns(10);
		txt5.setBounds(456, 333, 166, 20);
		contentPane.add(txt5);

		lbl4 = new JLabel("");
		lbl4.setBounds(660, 250, 142, 14);
		contentPane.add(lbl4);

		txt6 = new JTextField();
		txt6.setColumns(10);
		txt6.setBounds(660, 333, 166, 20);
		contentPane.add(txt6);

		lbl10 = new JLabel("");
		lbl10.setBounds(660, 438, 166, 14);
		contentPane.add(lbl10);

		txt7 = new JTextField();
		txt7.setColumns(10);
		txt7.setBounds(456, 404, 166, 20);
		contentPane.add(txt7);

		lbl5 = new JLabel("");
		lbl5.setBounds(456, 308, 142, 14);
		contentPane.add(lbl5);

		txt8 = new JTextField();
		txt8.setColumns(10);
		txt8.setBounds(660, 404, 166, 20);
		contentPane.add(txt8);

		lbl6 = new JLabel("");
		lbl6.setBounds(660, 308, 166, 14);
		contentPane.add(lbl6);

		txt9 = new JTextField();
		txt9.setColumns(10);
		txt9.setBounds(456, 463, 166, 20);
		contentPane.add(txt9);

		lbl7 = new JLabel("");
		lbl7.setBounds(456, 379, 191, 14);
		contentPane.add(lbl7);

		btnConfirm = new JButton("");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConfirm.setIcon(
						new ImageIcon(AddFromDirector.class.getResource("/img_tablesDirector/Confirm_noShadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnConfirm.setIcon(
						new ImageIcon(AddFromDirector.class.getResource("/img_tablesDirector/Confir_Shadow.png")));
			}
		});
		btnConfirm.setIcon(new ImageIcon(AddFromDirector.class.getResource("/img_tablesDirector/Confir_Shadow.png")));

		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.insertCompanyDirector();
			}
		});
		btnConfirm.setBounds(530, 552, 229, 81);
		btnConfirm.setFocusPainted(false);
		btnConfirm.setBorderPainted(false);
		btnConfirm.setContentAreaFilled(false);
		btnConfirm.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnConfirm);
		
		lblInformation = new JLabel("");
		lblInformation.setBounds(435, 524, 571, 14);
		contentPane.add(lblInformation);

	}

	

	

	public void setFieldsTrue() {

		txt5.setVisible(true);
		txt6.setVisible(true);
		txt7.setVisible(true);
		txt8.setVisible(true);
		txt9.setVisible(true);
		txt10.setVisible(true);

	}

	public void setLablesFalse() {
		lbl1.setText(null);
		lbl2.setText(null);
		lbl3.setText(null);
		lbl4.setText(null);
		lbl5.setText(null);
		lbl6.setText(null);
		lbl7.setText(null);
		lbl8.setText(null);
		lbl9.setText(null);
		lbl10.setText(null);

	}

	// GETTERS

	public Controller getController() {
		return myController;
	}

	public Model getModel() {
		return myModel;
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

	// SETTERS

	public void setTxt10(JTextField txt10) {
		this.txt10 = txt10;
	}

	public void setTxt1(JTextField txt1) {
		this.txt1 = txt1;
	}

	public void setTxt2(JTextField txt2) {
		this.txt2 = txt2;
	}

	public void setTxt3(JTextField txt3) {
		this.txt3 = txt3;
	}

	public void setTxt4(JTextField txt4) {
		this.txt4 = txt4;
	}

	public void setTxt5(JTextField txt5) {
		this.txt5 = txt5;
	}

	public void setTxt6(JTextField txt6) {
		this.txt6 = txt6;
	}

	public void setTxt7(JTextField txt7) {
		this.txt7 = txt7;
	}

	public void setTxt8(JTextField txt8) {
		this.txt8 = txt8;
	}

	public void setTxt9(JTextField txt9) {
		this.txt9 = txt9;
	}

	public void setLbl8(String lbl8) {
		this.lbl8.setText(lbl8);
	}

	public void setLbl1(String lbl1) {
		this.lbl1.setText(lbl1);
	}

	public void setLbl2(String lbl2) {
		this.lbl2.setText(lbl2);
	}

	public void setLbl9(String lbl9) {
		this.lbl9.setText(lbl9);
	}

	public void setLbl3(String lbl3) {
		this.lbl3.setText(lbl3);
	}

	public void setLbl4(String lbl4) {
		this.lbl4.setText(lbl4);
	}

	public void setLbl10(String lbl10) {
		this.lbl10.setText(lbl10);
	}

	public void setLbl5(String lbl5) {
		this.lbl5.setText(lbl5);
	}

	public void setLbl6(String lbl6) {
		this.lbl6.setText(lbl6);
	}

	public void setLbl7(String lbl7) {
		this.lbl7.setText(lbl7);
	}
	public void setLblInformation(String lblInformation) {
		this.lblInformation.setText(lblInformation);
	}

	public void setController(Controller myController) {
		this.myController = myController;

	}

	public void setModel(Model myModel) {
		this.myModel = myModel;

	}
}
