package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;
import model.Model;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DirectorPanel extends JFrame implements Views {

	private Controller myController;
	private Model myModel;
	private JPanel contentPane, header;
	private JLabel lblLogo, lblTitle, lblUser;
	private DefaultTableModel modelDir;
	private JButton btnUser;
	private JButton btnGroups;
	private JButton btnTutors;
	private JButton btnStudents;
	private JButton btnCompanies;
	private String tableName = "";

	public DirectorPanel() {

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


		lblLogo.setIcon(new ImageIcon(DirectorPanel.class.getResource("/img_tablesDirector/logo.png")));
		lblLogo.setForeground(new Color(239, 240, 246));
		lblLogo.setFont(new Font("Segoe UI Light", Font.PLAIN, 34));
		lblLogo.setBounds(10, 0, 225, 76);
		header.add(lblLogo);

		lblTitle = new JLabel("Director Panel");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(95, 46, 234));
		lblTitle.setFont(new Font("Arial Black", Font.BOLD, 28));
		lblTitle.setBounds(472, 3, 363, 76);
		header.add(lblTitle);

		lblUser = new JLabel("");
		lblUser.setForeground(new Color(95, 46, 234));
		lblUser.setVisible(true);
		lblUser.setFont(new Font("Poppins Light", Font.PLAIN, 23));
		lblTitle.setForeground(new Color(95, 46, 234));
		lblUser.setBounds(1064, 30, 108, 25);
		header.add(lblUser);

		// BUTTONS

		btnUser = new JButton("");
		btnUser.setBounds(1195, 11, 52, 56);
		header.add(btnUser);
		btnUser.setIcon(new ImageIcon(HelpCenter.class.getResource("/img/img_help/Group 238 (1).png")));
		btnUser.setBackground(Color.BLACK);
		btnUser.setFocusPainted(false);
		btnUser.setBorderPainted(false);
		btnUser.setContentAreaFilled(false);
		btnUser.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		btnGroups = new JButton("");
		btnGroups.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGroups.setIcon(
						new ImageIcon(DirectorPanel.class.getResource("/img/img_DirectorPanel/Groups_noShadow.png")));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnGroups.setIcon(
						new ImageIcon(DirectorPanel.class.getResource("/img/img_DirectorPanel/Groups_shadow.png")));

			}
		});
		btnGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.ChangeWindows(7, 10);
				myController.loadTableGroups();
				tableName = "Groups";

			}
		});
		btnGroups.setFocusPainted(false);
		btnGroups.setBorderPainted(false);
		btnGroups.setContentAreaFilled(false);
		btnGroups.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnGroups.setIcon(new ImageIcon(DirectorPanel.class.getResource("/img/img_DirectorPanel/Groups_shadow.png")));
		btnGroups.setBounds(383, 207, 219, 112);
		contentPane.add(btnGroups);

		btnStudents = new JButton("");
		btnStudents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnStudents.setIcon(new ImageIcon(DirectorPanel.class.getResource("/img/img_DirectorPanel/Students_noShadow.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnStudents.setIcon(new ImageIcon(DirectorPanel.class.getResource("/img/img_DirectorPanel/Students_shadow.png")));
			}
		});
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.ChangeWindows(7, 10);
				myController.loadTableStudent();
				tableName = "Student";

			}
		});
		btnStudents.setFocusPainted(false);
		btnStudents.setBorderPainted(false);
		btnStudents.setContentAreaFilled(false);
		btnStudents.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnStudents.setIcon(new ImageIcon(DirectorPanel.class.getResource("/img/img_DirectorPanel/Students_shadow.png")));

		btnStudents.setBounds(649, 207, 299, 122);

		contentPane.add(btnStudents);

		btnCompanies = new JButton("");
		btnCompanies.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCompanies.setIcon(new ImageIcon(DirectorPanel.class.getResource("/img/img_DirectorPanel/Companies_noShadow.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCompanies.setIcon(new ImageIcon(DirectorPanel.class.getResource("/img/img_DirectorPanel/Companies_shadow.png")));
			}
		});
		btnCompanies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.ChangeWindows(7, 10);
				myController.loadTableCompanies();
				tableName = "Companies";

			}
		});
		btnCompanies.setFocusPainted(false);
		btnCompanies.setBorderPainted(false);
		btnCompanies.setContentAreaFilled(false);
		btnCompanies.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnCompanies
				.setIcon(new ImageIcon(DirectorPanel.class.getResource("/img/img_DirectorPanel/Companies_shadow.png")));

		btnCompanies.setBounds(659, 349, 283, 128);

		contentPane.add(btnCompanies);

		btnTutors = new JButton("");
		btnTutors.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnTutors.setIcon(new ImageIcon(DirectorPanel.class.getResource("/img/img_DirectorPanel/Tutors_no_shadow.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnTutors.setIcon(new ImageIcon(DirectorPanel.class.getResource("/img/img_DirectorPanel/Tutors_shadow.png")));
			}
		});
		btnTutors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.ChangeWindows(7, 10);
				myController.loadTableTutor();
				tableName = "Tutors";

			}
		});
		btnTutors.setFocusPainted(false);
		btnTutors.setBorderPainted(false);
		btnTutors.setContentAreaFilled(false);
		btnTutors.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		btnTutors.setIcon(new ImageIcon(DirectorPanel.class.getResource("/img/img_DirectorPanel/Tutors_shadow.png")));
		btnTutors.setBounds(383, 355, 219, 112);
		contentPane.add(btnTutors);

		// LISTENERS
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.ChangeWindows(7, 14);
			}
		});

	}

	// GETTERS

	public Controller getController() {
		return myController;
	}

	public void setController(Controller myController) {
		this.myController = myController;

	}

	public Model getModel() {
		return myModel;
	}

	public String getTableName() {
		return tableName;
	}

	// SETTERS

	public void setModel(Model myModel) {
		this.myModel = myModel;

	}

	public void setLblUser(String lbl) {
		this.lblUser.setText(lbl);
	}

	
	
}