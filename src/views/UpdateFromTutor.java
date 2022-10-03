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
import javax.swing.border.LineBorder;

import Controller.Controller;
import model.Model;

public class UpdateFromTutor extends JFrame implements Views {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, header;
	private JButton btnbackArrow, btnUpdate;
	private JTextField txtExp, txtName, txtDNI, txtLastname, txtCodePractics, txtCIFCompany, txtEndDate, txtStartDate,
			txtAcademyYear, txtSchedule, txtPracticsYear, txtAnex_2_1, txtAnex7, txtAnex8, txtAnex3, txtBornDate;
	private JLabel lblDNI, lblLastname, lblName, lblCodPractics, lblExp, lblStudents, lblPractics, lblCIFCompany,
			lblEndDate, lblStartDate, lblAcad, lblAnex, lblAnex2, lblAnex8, lblAnex7, lblSchedule, lblAcadPractics,
			lblBornDate, lblLogo, lblUpdateStudent;

	private Controller myController;
	private Model myModel;

	// IMPORTANT METHODS

	public void placeDatabaseValues(int txtExp, String name, String DNI, String lastName, String bornDate,
			int CodePractics, String CiFCompany, String EndDate, String StartDate, String AcademyYear, String Schedule,
			String PracticsYear, String Anex_2_1, String Anex7, String Anex8, String Anex3) {

		this.txtExp.setText(String.valueOf(txtExp));
		this.txtName.setText(name);
		this.txtDNI.setText(DNI);
		this.txtLastname.setText(lastName);
		this.txtBornDate.setText(bornDate);
		this.txtCodePractics.setText(String.valueOf(CodePractics));
		this.txtCIFCompany.setText(CiFCompany);
		this.txtEndDate.setText(EndDate);
		this.txtStartDate.setText(StartDate);
		this.txtAcademyYear.setText(AcademyYear);
		this.txtSchedule.setText(Schedule);
		this.txtPracticsYear.setText(PracticsYear);
		this.txtAnex_2_1.setText(Anex_2_1);
		this.txtAnex7.setText(Anex7);
		this.txtAnex8.setText(Anex8);
		this.txtAnex3.setText(Anex3);
	}

	// SETTERS
	public void setModel(Model myModel) {
		this.myModel = myModel;

	}

	public void setController(Controller myController) {
		this.myController = myController;

	}

	// GETTERS

	public String getTxtExp() {
		return txtExp.getText();
	}

	public String getTxtName() {
		return txtName.getText();
	}

	public String getTxtDNI() {
		return txtDNI.getText();
	}

	public String getTxtLastname() {
		return txtLastname.getText();
	}

	public String getTxtCodePractics() {
		return txtCodePractics.getText();
	}

	public String getTxtCIFCompany() {
		return txtCIFCompany.getText();
	}

	public String getTxtEndDate() {
		return txtEndDate.getText();
	}

	public String getTxtStartDate() {
		return txtStartDate.getText();
	}

	public String getTxtAcademyYear() {
		return txtAcademyYear.getText();
	}

	public String getTxtSchedule() {
		return txtSchedule.getText();
	}

	public String getTxtPracticsYear() {
		return txtPracticsYear.getText();
	}

	public String getTxtAnex_2_1() {
		return txtAnex_2_1.getText();
	}

	public String getTxtAnex7() {
		return txtAnex7.getText();
	}

	public String getTxtAnex8() {
		return txtAnex8.getText();
	}

	public String getTxtAnex3() {
		return txtAnex3.getText();
	}

	public String getTxtBornDate() {
		return txtBornDate.getText();
	}

	// DESIGN
	public UpdateFromTutor() {

		// FRAME
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

		// BUTTONS

		btnbackArrow = new JButton("");
		btnbackArrow.setIcon(new ImageIcon(UpdateFromTutor.class.getResource("/IMGStudents/btn back s.png")));
		btnbackArrow.setBackground(Color.WHITE);
		btnbackArrow.setBounds(28, 104, 83, 49);
		btnbackArrow.setFocusPainted(false);
		btnbackArrow.setBorderPainted(false);
		btnbackArrow.setContentAreaFilled(false);
		btnbackArrow.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnbackArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnbackArrow.setIcon(new ImageIcon(UpdateFromTutor.class.getResource("/IMGStudents/btn back ns.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnbackArrow.setIcon(new ImageIcon(UpdateFromTutor.class.getResource("/IMGStudents/btn back s.png")));
			}
		});
		btnbackArrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.ChangeWindows(13, 10);
			}
		});
		contentPane.add(btnbackArrow);

		btnUpdate = new JButton("");
		btnUpdate.setFocusPainted(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnUpdate.setBounds(581, 575, 155, 49);
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setIcon(new ImageIcon(UpdateFromTutor.class.getResource("/IMGStudents/Update btn S.png")));
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnUpdate.setIcon(new ImageIcon(UpdateFromTutor.class.getResource("/IMGStudents/Update btn nS.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnUpdate.setIcon(new ImageIcon(UpdateFromTutor.class.getResource("/IMGStudents/Update btn S.png")));
			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.UpdateStudentsFromTutor();
			}
		});

		contentPane.add(btnUpdate);

		// TEXTFIELDS

		txtExp = new JTextField();
		txtExp.setBorder(new LineBorder(new Color(102, 51, 255), 1, true));
		txtExp.setBounds(182, 226, 146, 26);
		contentPane.add(txtExp);
		txtExp.setColumns(10);

		txtName = new JTextField();
		txtName.setBorder(new LineBorder(new Color(102, 51, 255), 1, true));
		txtName.setColumns(10);
		txtName.setBounds(574, 226, 146, 26);
		contentPane.add(txtName);

		txtDNI = new JTextField();
		txtDNI.setBorder(new LineBorder(new Color(102, 51, 255), 1, true));
		txtDNI.setColumns(10);
		txtDNI.setBounds(369, 226, 146, 26);
		contentPane.add(txtDNI);

		txtLastname = new JTextField();
		txtLastname.setBorder(new LineBorder(new Color(102, 51, 255), 1, true));
		txtLastname.setColumns(10);
		txtLastname.setBounds(778, 226, 146, 26);
		contentPane.add(txtLastname);
		txtCodePractics = new JTextField();
		txtCodePractics.setBorder(new LineBorder(new Color(102, 51, 255), 1, true));
		txtCodePractics.setColumns(10);
		txtCodePractics.setBounds(182, 379, 146, 26);
		contentPane.add(txtCodePractics);

		txtCIFCompany = new JTextField();
		txtCIFCompany.setBorder(new LineBorder(new Color(102, 51, 255), 1, true));
		txtCIFCompany.setColumns(10);
		txtCIFCompany.setBounds(369, 379, 146, 26);
		contentPane.add(txtCIFCompany);

		txtEndDate = new JTextField();
		txtEndDate.setBorder(new LineBorder(new Color(102, 51, 255), 1, true));
		txtEndDate.setColumns(10);
		txtEndDate.setBounds(778, 379, 146, 26);
		contentPane.add(txtEndDate);

		txtStartDate = new JTextField();
		txtStartDate.setBorder(new LineBorder(new Color(102, 51, 255), 1, true));
		txtStartDate.setColumns(10);
		txtStartDate.setBounds(574, 379, 146, 26);
		contentPane.add(txtStartDate);

		txtAcademyYear = new JTextField();
		txtAcademyYear.setBorder(new LineBorder(new Color(102, 51, 255), 1, true));
		txtAcademyYear.setColumns(10);
		txtAcademyYear.setBounds(969, 379, 146, 26);
		contentPane.add(txtAcademyYear);

		txtSchedule = new JTextField();
		txtSchedule.setBorder(new LineBorder(new Color(102, 51, 255), 1, true));
		txtSchedule.setColumns(10);
		txtSchedule.setBounds(182, 473, 146, 26);
		contentPane.add(txtSchedule);

		txtPracticsYear = new JTextField();
		txtPracticsYear.setBorder(new LineBorder(new Color(102, 51, 255), 1, true));
		txtPracticsYear.setColumns(10);
		txtPracticsYear.setBounds(369, 473, 146, 26);
		contentPane.add(txtPracticsYear);

		txtAnex_2_1 = new JTextField();
		txtAnex_2_1.setBorder(new LineBorder(new Color(102, 51, 255), 1, true));
		txtAnex_2_1.setColumns(10);
		txtAnex_2_1.setBounds(574, 473, 146, 26);
		contentPane.add(txtAnex_2_1);

		txtAnex7 = new JTextField();
		txtAnex7.setBorder(new LineBorder(new Color(102, 51, 255), 1, true));
		txtAnex7.setColumns(10);
		txtAnex7.setBounds(969, 473, 146, 26);
		contentPane.add(txtAnex7);

		txtAnex8 = new JTextField();
		txtAnex8.setBorder(new LineBorder(new Color(102, 51, 255), 1, true));
		txtAnex8.setColumns(10);
		txtAnex8.setBounds(182, 575, 146, 26);
		contentPane.add(txtAnex8);

		txtAnex3 = new JTextField();
		txtAnex3.setBorder(new LineBorder(new Color(102, 51, 255), 1, true));
		txtAnex3.setColumns(10);
		txtAnex3.setBounds(778, 473, 146, 26);
		contentPane.add(txtAnex3);

		txtBornDate = new JTextField();
		txtBornDate.setBorder(new LineBorder(new Color(102, 51, 255), 1, true));
		txtBornDate.setColumns(10);
		txtBornDate.setBounds(969, 226, 146, 26);
		contentPane.add(txtBornDate);

		// LABELS
		lblLogo = new JLabel("PracTICS");
		lblLogo.setIcon(new ImageIcon(UpdateFromTutor.class.getResource("/IMGStudents/logoPractics.png")));
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Segoe UI Light", Font.PLAIN, 34));
		lblLogo.setBounds(38, -3, 233, 80);
		header.add(lblLogo);

		lblUpdateStudent = new JLabel("Modify Student");
		lblUpdateStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateStudent.setForeground(new Color(95, 46, 234));
		lblUpdateStudent.setFont(new Font("SansSerif", Font.BOLD, 40));
		lblUpdateStudent.setBounds(472, 3, 363, 73);
		header.add(lblUpdateStudent);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblName.setBounds(574, 182, 136, 33);
		contentPane.add(lblName);

		lblExp = new JLabel("Exp");
		lblExp.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblExp.setBounds(182, 182, 136, 33);
		contentPane.add(lblExp);

		lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblDNI.setBounds(369, 179, 136, 33);
		contentPane.add(lblDNI);

		lblLastname = new JLabel("Lastname");
		lblLastname.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblLastname.setBounds(778, 182, 136, 33);
		contentPane.add(lblLastname);

		lblCodPractics = new JLabel("Code Practics");
		lblCodPractics.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblCodPractics.setBounds(182, 335, 136, 33);
		contentPane.add(lblCodPractics);

		lblCIFCompany = new JLabel("CIF Company");
		lblCIFCompany.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblCIFCompany.setBounds(369, 332, 136, 33);
		contentPane.add(lblCIFCompany);

		lblEndDate = new JLabel("End Date");
		lblEndDate.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblEndDate.setBounds(778, 335, 136, 33);
		contentPane.add(lblEndDate);

		lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblStartDate.setBounds(574, 335, 136, 33);
		contentPane.add(lblStartDate);

		lblSchedule = new JLabel("Schedule");
		lblSchedule.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblSchedule.setBounds(182, 429, 136, 33);
		contentPane.add(lblSchedule);

		lblAcad = new JLabel("Academic Year");
		lblAcad.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblAcad.setBounds(969, 335, 136, 33);
		contentPane.add(lblAcad);

		lblAcadPractics = new JLabel("Practics Year");
		lblAcadPractics.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblAcadPractics.setBounds(574, 429, 136, 33);
		contentPane.add(lblAcadPractics);

		lblAnex2 = new JLabel("Anex 2.1");
		lblAnex2.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblAnex2.setBounds(369, 426, 136, 33);
		contentPane.add(lblAnex2);

		lblAnex7 = new JLabel("Anex 7");
		lblAnex7.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblAnex7.setBounds(969, 429, 136, 33);
		contentPane.add(lblAnex7);

		lblAnex8 = new JLabel("Anex 8");
		lblAnex8.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblAnex8.setBounds(182, 531, 136, 33);
		contentPane.add(lblAnex8);

		lblAnex = new JLabel("Anex 3");
		lblAnex.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblAnex.setBounds(778, 429, 136, 33);
		contentPane.add(lblAnex);

		lblPractics = new JLabel("Practics");
		lblPractics.setForeground(new Color(102, 0, 255));
		lblPractics.setFont(new Font("SansSerif", Font.BOLD, 26));
		lblPractics.setBounds(182, 292, 182, 32);
		contentPane.add(lblPractics);

		lblBornDate = new JLabel("Born Date");
		lblBornDate.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblBornDate.setBounds(969, 182, 136, 33);
		contentPane.add(lblBornDate);

		lblStudents = new JLabel("Students");
		lblStudents.setForeground(new Color(102, 0, 255));
		lblStudents.setFont(new Font("SansSerif", Font.BOLD, 26));
		lblStudents.setBounds(182, 139, 182, 29);
		contentPane.add(lblStudents);

	}

}
