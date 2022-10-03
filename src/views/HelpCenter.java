package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.Controller;
import model.Model;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HelpCenter extends JFrame implements Views {

    private Controller myController;
    private Model myModel;
    private JPanel contentPane, header, panel;
    private JTextField textSearch;
    private JLabel lblWelcome, q1, q2, q3, q4, q5, lblTitle, lblLogo;
    private JButton btnSearch, btnBack;

    public HelpCenter() {
    	
		// PANELS
    	
        setTitle("PracTICS");
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

		panel = new JPanel();
		panel.setBounds(1074, 95, 172, 41);
		contentPane.add(panel);
		panel.setLayout(null);

        //LABELS
		
        lblTitle = new JLabel("Help Center");
        lblTitle.setForeground(new Color(95, 46, 234));
        lblTitle.setFont(new Font("Arial Black", Font.BOLD, 28));
        lblTitle.setBounds(567, 0, 202, 76);
        header.add(lblTitle);

        lblWelcome = new JLabel("Welcome to the Help Center");
        lblWelcome.setForeground(new Color(0, 0, 0));
        lblWelcome.setFont(new Font("Poppins Light", Font.PLAIN, 31));
        lblWelcome.setBounds(322, 120, 446, 32);
        contentPane.add(lblWelcome);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(HelpCenter.class.getResource("/img_tablesDirector/logo.png")));
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Segoe UI Light", Font.PLAIN, 34));
		lblLogo.setBounds(10, 0, 211, 76);
		header.add(lblLogo);

        q1 = new JLabel("Login Error");
        q1.setFont(new Font("Poppins Light", Font.PLAIN, 19));
        q1.setForeground(new Color(95, 46, 234));
        q1.setBounds(514, 221, 235, 28);
        contentPane.add(q1);

        q2 = new JLabel("I can't remember my password");
        q2.setFont(new Font("Poppins Light", Font.PLAIN, 19));
        q2.setForeground(new Color(95, 46, 234));
        q2.setBounds(514, 260, 326, 28);
        contentPane.add(q2);

        // QUESTION 3
        
        q3 = new JLabel("I can't sing up");
        q3.setFont(new Font("Poppins Light", Font.PLAIN, 19));
        q3.setForeground(new Color(95, 46, 234));
        q3.setBounds(514, 300, 235, 28);
        contentPane.add(q3);

        // QUESTION 4
        
        q4 = new JLabel("How to use this aplication");
        q4.setFont(new Font("Poppins Light", Font.PLAIN, 19));
        q4.setForeground(new Color(95, 46, 234));
        q4.setBounds(514, 339, 296, 28);
        contentPane.add(q4);

        q5 = new JLabel("Change language");
        q5.setFont(new Font("Poppins Light", Font.PLAIN, 19));
        q5.setForeground(new Color(95, 46, 234));
        q5.setBounds(514, 378, 235, 28);
        contentPane.add(q5);

        //TEXTFIELDS
        
        textSearch = new JTextField();
        textSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
        textSearch.setHorizontalAlignment(SwingConstants.CENTER);
        textSearch.setBounds(41, 0, 131, 41);
        panel.add(textSearch);
        textSearch.setColumns(10);
        textSearch.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));

        //BUTTONS
        
		btnSearch = new JButton("");
		btnSearch.setContentAreaFilled(false);
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setIcon(new ImageIcon(HelpCenter.class.getResource("/img_settings/Search (1).png")));
		btnSearch.setBounds(0, 0, 43, 41);
		btnSearch.setFocusPainted(false);
		btnSearch.setBorder(new LineBorder(new Color(95, 46, 234), 2, true));
		panel.add(btnSearch);

        btnBack = new JButton("");
        btnBack.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnBack.setIcon(new ImageIcon(HelpCenter.class.getResource("/img_tablesDirector/backArrow_noShadow.png")));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btnBack.setIcon(new ImageIcon(HelpCenter.class.getResource("/img_tablesDirector/backArrow_Shadow.png")));
        	}
        });
        btnBack.setBackground(Color.WHITE);
        btnBack.setIcon(new ImageIcon(HelpCenter.class.getResource("/img_tablesDirector/backArrow_Shadow.png")));
        btnBack.setBounds(10, 87, 105, 41);
        contentPane.add(btnBack);
        btnBack.setFocusPainted(false);
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        //LISTENERS
        
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myController.backLogin();
			}
		});

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		q1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				q1.setFont(new Font("Poppins Light", Font.BOLD, 19));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				q1.setFont(new Font("Poppins Light", Font.PLAIN, 19));
			}
		});

		q2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				q2.setFont(new Font("Poppins Light", Font.PLAIN, 19));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				q2.setFont(new Font("Poppins Light", Font.BOLD, 19));
			}
		});

		q3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				q3.setFont(new Font("Poppins Light", Font.PLAIN, 19));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				q3.setFont(new Font("Poppins Light", Font.BOLD, 19));
			}
		});

		q4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				q4.setFont(new Font("Poppins Light", Font.PLAIN, 19));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				q4.setFont(new Font("Poppins Light", Font.BOLD, 19));
			}
		});
		q5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				q5.setFont(new Font("Poppins Light", Font.PLAIN, 19));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				q5.setFont(new Font("Poppins Light", Font.BOLD, 19));
			}
		});

    }

	//SETTERS
    
	public void setController(Controller myController) {
        this.myController = myController;
    }

    public void setModel(Model myModel) {
        this.myModel = myModel;
    }

    //METHODS
    
    public void backLogin() {
        myController.ChangeWindows(5, 0);

    }

}
