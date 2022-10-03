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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import model.Model;

public class TablesDirector extends JFrame implements Views {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controller myController;
	private Model myModel;
	private JPanel header, contentPane;
	private JLabel lblTitle, lblUser, lblPractics;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JTable table;
	private JButton btnImport, btnExport, btnUpdate, btnDelete, btnAddCompany, btnbackArrow, btnUser;

	public TablesDirector() {

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
		header.setBackground(new Color(239, 240, 246));
		header.setBounds(0, 0, 1280, 80);
		contentPane.add(header);
		header.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(66, 156, 955, 328);
		contentPane.add(scrollPane);

		// TABLES
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				updateDelete();
				updateModify();

			}
		});
		scrollPane.setViewportView(table);

		// LABELS

		lblTitle = new JLabel("Tables Director");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(95, 46, 234));
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 40));
		lblTitle.setBounds(472, 3, 363, 73);
		header.add(lblTitle);

		lblUser = new JLabel(" ");
		lblUser.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblUser.setBounds(963, 30, 209, 25);
		lblUser.setForeground(new Color(95, 46, 234));
		header.add(lblUser);

		lblPractics = new JLabel("");
		lblPractics.setSize(241, 61);
		lblPractics.setLocation(10, 0);
		lblPractics.setIcon(new ImageIcon(TablesDirector.class.getResource("/img_tablesDirector/logo.png")));
		header.add(lblPractics);

		// BUTTONS

		btnbackArrow = new JButton("");
		btnbackArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnbackArrow.setIcon(
						new ImageIcon(TablesDirector.class.getResource("/img_tablesDirector/backArrow_noShadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnbackArrow.setIcon(
						new ImageIcon(TablesDirector.class.getResource("/img_tablesDirector/backArrow_Shadow.png")));
			}
		});
		btnbackArrow
				.setIcon(new ImageIcon(TablesDirector.class.getResource("/img_tablesDirector/backArrow_Shadow.png")));
		btnbackArrow.setBackground(Color.WHITE);
		btnbackArrow.setBounds(0, 87, 121, 47);
		btnbackArrow.setFocusPainted(false);
		btnbackArrow.setBorderPainted(false);
		btnbackArrow.setContentAreaFilled(false);
		btnbackArrow.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnbackArrow);

		btnUser = new JButton("");
		btnUser.setBounds(1195, 11, 52, 66);
		btnUser.setFocusPainted(false);
		btnUser.setBorderPainted(false);
		btnUser.setContentAreaFilled(false);
		btnUser.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnUser.setIcon(new ImageIcon(UpdateFromTutor.class.getResource("/IMGStudents/default_img_profile S.png")));
		btnUser.setBackground(Color.BLACK);
		btnUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnUser.setIcon(
						new ImageIcon(UpdateFromTutor.class.getResource("/IMGStudents/default_img_profile nS.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnUser.setIcon(
						new ImageIcon(UpdateFromTutor.class.getResource("/IMGStudents/default_img_profile S.png")));
			}
		});

		header.add(btnUser);

		btnAddCompany = new JButton("");
		btnAddCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myModel.lblErrorAdd();
			}
		});

		btnAddCompany.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAddCompany.setIcon(
						new ImageIcon(TablesDirector.class.getResource("/img_tablesDirector/add_noShadow.png")));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAddCompany
						.setIcon(new ImageIcon(TablesDirector.class.getResource("/img_tablesDirector/add_Shadow.png")));
			}
		});
		btnAddCompany.setIcon(new ImageIcon(TablesDirector.class.getResource("/img_tablesDirector/add_Shadow.png")));
		btnAddCompany.setForeground(Color.WHITE);
		btnAddCompany.setBackground(Color.WHITE);
		btnAddCompany.setFocusPainted(false);
		btnAddCompany.setBorderPainted(false);
		btnAddCompany.setContentAreaFilled(false);
		btnAddCompany.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		btnAddCompany.setBounds(1063, 187, 183, 57);
		contentPane.add(btnAddCompany);

		btnDelete = new JButton("");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDelete.setIcon(
						new ImageIcon(TablesDirector.class.getResource("/img_tablesDirector/remove_noShadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnDelete.setIcon(
						new ImageIcon(TablesDirector.class.getResource("/img_tablesDirector/remove_Shadow.png")));
			}
		});
		btnDelete.setIcon(new ImageIcon(TablesDirector.class.getResource("/img_tablesDirector/remove_Shadow.png")));
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setEnabled(false);
		btnDelete.setFocusPainted(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.removeRowDirector();

			}
		});
		btnDelete.setBounds(1063, 323, 183, 57);
		contentPane.add(btnDelete);

		btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnUpdate.setIcon(
						new ImageIcon(TablesDirector.class.getResource("/img_tablesDirector/edit_noShadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnUpdate.setIcon(
						new ImageIcon(TablesDirector.class.getResource("/img_tablesDirector/edit_Shadow.png")));
			}
		});
		btnUpdate.setIcon(new ImageIcon(TablesDirector.class.getResource("/img_tablesDirector/edit_Shadow.png")));

		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(1080, 255, 150, 57);
		btnUpdate.setFocusPainted(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnUpdate);

		btnImport = new JButton("");
		btnImport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnImport.setIcon(
						new ImageIcon(TablesDirector.class.getResource("/img_tablesDirector/import_noShadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnImport.setIcon(
						new ImageIcon(TablesDirector.class.getResource("/img_tablesDirector/import_Shadow.png")));
			}
		});
		btnImport.setIcon(new ImageIcon(TablesDirector.class.getResource("/img_tablesDirector/import_Shadow.png")));
		btnImport.setBounds(655, 495, 150, 48);
		btnImport.setFocusPainted(false);
		btnImport.setBorderPainted(false);
		btnImport.setContentAreaFilled(false);
		btnImport.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnImport);

		btnExport = new JButton("");
		btnExport.setIcon(new ImageIcon(TablesDirector.class.getResource("/img_tablesDirector/export_Shadow.png")));
		btnExport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExport.setIcon(
						new ImageIcon(TablesDirector.class.getResource("/img_tablesDirector/export_noShadow.png")));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnExport.setIcon(
						new ImageIcon(TablesDirector.class.getResource("/img_tablesDirector/export_Shadow.png")));
			}
		});
		btnExport.setBounds(830, 496, 150, 47);
		btnExport.setFocusPainted(false);
		btnExport.setBorderPainted(false);
		btnExport.setContentAreaFilled(false);
		btnExport.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		contentPane.add(btnExport);

		btnbackArrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myController.ChangeWindows(10, 7);
			}
		});

	}

	public void changeFrameBtnUpdateFromTutor() {
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.ChangeWindows(10, 13);
				myController.UpdateStudentsFieldsFromTutor();
			}
		});

	}

	public void changeFrameBtnUpdateFromDirector() {

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.ChangeWindows(10, 12);
				myController.loadFieldsToUpdate();
			}
		});

	}

	public void setBtnAddCompany() {
		btnAddCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.ChangeWindows(10, 11);
			}
		});
	}

	public void setBtnAddDirector() {
		btnAddCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.ChangeWindows(10, 9);
				myController.chooseAddDirector();
			}
		});
	}

	public void setBtnDelete() {

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.removeRowTutor();

			}
		});

	}

	private void updateDelete() {
		if (!(table.getSelectedRow() == -1)) {
			btnDelete.setEnabled(true);
		} else {
			btnDelete.setEnabled(false);
		}

	}

	private void updateModify() {
		if (!(table.getSelectedRow() == -1)) {
			btnUpdate.setEnabled(true);
		} else {
			btnUpdate.setEnabled(false);
		}

	}

	// SETTERS

	public void setController(Controller myController) {
		this.myController = myController;
	}

	public void setModel(Model myModel) {
		this.myModel = myModel;
	}

	public void setTable(DefaultTableModel model) {
		this.table.setModel(model);

	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public void setLblTitle(String lblTitle) {
		this.lblTitle.setText(lblTitle);
	}

	public void setLblUser(String lblUser) {
		this.lblUser.setText(lblUser);
	}

	// GETTER

	public JTable getTable() {
		return table;
	}

	public void hideBackButton() {
		btnbackArrow.setEnabled(false);
		btnbackArrow.setVisible(false);
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public String getLblTitle() {
		return lblTitle.getText();
	}

	public void goToSettingsDirector() {
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.ChangeWindows(10, 14);
			}
		});
	}

	public void goToSettingsTutor() {
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.ChangeWindows(10, 6);
			}
		});
	}
}