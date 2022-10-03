package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import model.Model;

public class ManageStudent extends JFrame implements Views, Serializable {

	private static final long serialVersionUID = 1L;
	private Controller myController;
	private Model myModel;

	private JPanel contentPane, header;
	private JLabel lblLogo, lblTitle, lblUser;

	private JButton btnUser;
	private JScrollPane scrollPane;
	private JTable tableManageStudent;
	private JButton btnAddStudent;
	private JButton btnDelete;
	private DefaultTableModel modelStudent;

	// BUILDER

	public DefaultTableModel getModelStudent() {
		return modelStudent;
	}

	public ManageStudent() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tableManageStudent.setModel(myModel.getModeloT());

			} 
		});

		// PANELS

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(51, 0, 153));
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(98, 136, 827, 380);
		contentPane.add(scrollPane);

		header = new JPanel();
		header.setBackground(new Color(239, 240, 246));
		header.setBounds(0, 0, 1600, 76);
		contentPane.add(header);
		header.setLayout(null);

		// LABELS

		lblLogo = new JLabel("PracTICS");
		lblLogo.setIcon(new ImageIcon(ManageStudent.class.getResource("/IMGStudents/logoPractics.png")));
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Segoe UI Light", Font.PLAIN, 34));
		lblLogo.setBounds(10, 0, 251, 76);
		header.add(lblLogo);

		lblTitle = new JLabel("");
		lblTitle.setIcon(new ImageIcon(ManageStudent.class.getResource("/IMGStudents/Students.png")));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Arial Black", Font.BOLD, 28));
		lblTitle.setBounds(472, 3, 363, 76);
		header.add(lblTitle);

		// Name of person connected

		lblUser = new JLabel("Pedro Camacho");
		lblUser.setVisible(true);
		lblUser.setFont(new Font("Poppins Light", Font.PLAIN, 23));
		lblUser.setForeground(Color.WHITE);
		lblUser.setBounds(985, 30, 187, 25);
		header.add(lblUser);

		// TABLES

		tableManageStudent = new JTable();
		tableManageStudent.setBackground(Color.WHITE);
		scrollPane.setViewportView(tableManageStudent);

		btnUser = new JButton("");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.ChangeWindows(4, 6);
			}
		});
		btnUser.setBounds(1195, 11, 52, 56);
		header.add(btnUser);
		btnUser.setIcon(new ImageIcon(HelpCenter.class.getResource("/img/img_help/Group 238 (1).png")));
		btnUser.setBackground(Color.BLACK);
		btnUser.setFocusPainted(false);
		btnUser.setBorderPainted(false);
		btnUser.setContentAreaFilled(false);
		btnUser.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				myController.ChangeWindows(4, 11);
			}
		});
		btnAddStudent.setBounds(163, 569, 109, 23);

		btnAddStudent.setForeground(Color.WHITE);
		btnAddStudent.setIcon(new ImageIcon(ManageStudent.class.getResource("/IMGStudents/Button.png")));
		btnAddStudent.setBounds(1035, 265, 145, 68);

		contentPane.add(btnAddStudent);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon(ManageStudent.class.getResource("/IMGStudents/ButtonEdit.png")));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(1035, 347, 145, 47);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setIcon(new ImageIcon(ManageStudent.class.getResource("/IMGStudents/ButtonRemove.png")));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(1035, 416, 145, 47);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setIcon(new ImageIcon(ManageStudent.class.getResource("/IMGStudents/ButtonImport.png")));
		btnNewButton_2.setBounds(274, 585, 155, 54);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setIcon(new ImageIcon(ManageStudent.class.getResource("/IMGStudents/ButtonExport.png")));
		btnNewButton_3.setBounds(477, 585, 161, 54);
		contentPane.add(btnNewButton_3);

		btnDelete = new JButton("Delete Row");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnDelete.setBounds(490, 569, 120, 23);
		contentPane.add(btnDelete);

		// LISTENERS

		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tableManageStudent.getSelectionModel().clearSelection();

			}
		});
	}

	// SETTERS

	public void setController(Controller myController) {

		this.myController = myController;
	}

	public void setModel(Model myModel) {
		this.myModel = myModel;
	}

	// GETTERS

	public JTable getTableManageStudent() {
		return tableManageStudent;
	}

	// METHODS

	public void goSettingsMS() {
		myController.ChangeWindows(4, 6);

	}

	public void setTabla(DefaultTableModel model) {

		this.tableManageStudent.setModel(model);

	}

	public int selection() {
		System.out.println(tableManageStudent.getRowCount());
		return tableManageStudent.getSelectedRow();
	}
}