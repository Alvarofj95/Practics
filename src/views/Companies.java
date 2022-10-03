package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import model.Model;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Companies extends JFrame implements Views {

	private Controller myController;
	private Model myModel;
	private JPanel header, contentPane;
	private JButton btnbackArrow, btnUser, btnExport;
	private JLabel lblTitle, lblUser, lblPractics;
	private JScrollPane scrollPane;
	private DefaultTableModel ModelCompany;
	private JTable tabla;
	private JButton btnImport;

	public Companies() {

		// COMPONENTS

		// PANELS
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		header = new JPanel();
		header.setBackground(new Color(95, 46, 234));
		header.setBounds(0, 0, 1600, 76);
		contentPane.add(header);
		header.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(165, 145, 955, 328);
		contentPane.add(scrollPane);

		// TABLES
		tabla = new JTable();
		scrollPane.setViewportView(tabla);

		// LABELS
		lblTitle = new JLabel("Companies");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Arial Black", Font.BOLD, 28));
		lblTitle.setBounds(472, 3, 363, 76);
		header.add(lblTitle);

		lblUser = new JLabel("Joaquin Cassinello");
		lblUser.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblUser.setBounds(963, 30, 209, 25);
		lblUser.setForeground(new Color(255, 255, 255));
		header.add(lblUser);

		lblPractics = new JLabel("");
		lblPractics.setSize(176, 61);
		lblPractics.setLocation(10, 0);
		lblPractics.setIcon(new ImageIcon(ManageStudent.class.getResource("/IMGStudents/PracTICS.png")));
		header.add(lblPractics);

		// BUTTONS

		btnbackArrow = new JButton("");
		btnbackArrow.setIcon(new ImageIcon(Companies.class.getResource("/IMGStudents/Vector.png")));
		btnbackArrow.setBackground(Color.WHITE);
		btnbackArrow.setBounds(10, 87, 45, 33);
		btnbackArrow.setFocusPainted(false);
		btnbackArrow.setBorderPainted(false);
		btnbackArrow.setContentAreaFilled(false);
		btnbackArrow.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnbackArrow);

		btnUser = new JButton("");
		btnUser.setBounds(1195, 11, 52, 56);
		header.add(btnUser);
		btnUser.setIcon(new ImageIcon(HelpCenter.class.getResource("/img/img_help/Group 238 (1).png")));
		btnUser.setBackground(Color.BLACK);
		btnUser.setFocusPainted(false);
		btnUser.setBorderPainted(false);
		btnUser.setContentAreaFilled(false);
		btnUser.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		btnExport = new JButton("");
		btnExport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExport.setIcon(
						new ImageIcon(Companies.class.getResource("/img_settings/Export_table_no_Shadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnExport.setIcon(new ImageIcon(Companies.class.getResource("/img_settings/export_table_shadow.png")));
			}
		});
		btnExport.setIcon(new ImageIcon(Companies.class.getResource("/img_settings/export_table_shadow.png")));
		btnExport.setFocusPainted(false);
		btnExport.setBorderPainted(false);
		btnExport.setContentAreaFilled(false);
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.ExportTableCompanies();
				myController.cleanTableCompanies();
			}
		});
		btnExport.setBounds(556, 501, 153, 41);
		contentPane.add(btnExport);

		btnImport = new JButton("");
		btnImport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnImport.setIcon(new ImageIcon(Companies.class.getResource("/img_settings/Load_Table_No_shadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnImport.setIcon(new ImageIcon(Companies.class.getResource("/img_settings/load_table_shadow.png")));
			}
		});

		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.loadCompanies();
			}
		});
		btnImport.setIcon(new ImageIcon(Companies.class.getResource("/img_settings/Load_Table_No_shadow.png")));
		btnImport.setFocusPainted(false);
		btnImport.setContentAreaFilled(false);
		btnImport.setBorderPainted(false);
		btnImport.setBounds(719, 501, 153, 41);
		contentPane.add(btnImport);

		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.ChangeWindows(8, 14);
			}
		});

		btnbackArrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.ChangeWindows(8, 7);
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				tabla.setModel(myModel.getModeloA());

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

	public void setTable(DefaultTableModel model) {
		this.tabla.setModel(model);

	}
}