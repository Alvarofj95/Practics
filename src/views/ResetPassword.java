package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.Controller;
import model.Model;

import java.awt.*;
import java.awt.event.*;

public class ResetPassword extends JFrame implements Views {

    private Controller myController;
    private Model myModel;
    private JPanel contentPane;
    private JTextField txtEmail;
    private JLabel lblConfirmSend, lblEmail, lblResetPassword;
    private JButton btnSend;

    
    //BUILDER
    
    public ResetPassword() {
    	
        //PANELS
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 499, 327);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //BUTTONS
        
        btnSend = new JButton("");
        btnSend.setFocusPainted(false);
        btnSend.setBorderPainted(false);
        btnSend.setContentAreaFilled(false);
        btnSend.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnSend.setEnabled(false);
        btnSend.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSend.setBackground(Color.WHITE);
        btnSend.setForeground(new Color(255, 255, 255));
        btnSend.setBounds(169, 228, 150, 57);
        contentPane.add(btnSend);

        //LABELS
        
        lblResetPassword = new JLabel("Send a email to reset the password");
        lblResetPassword.setBackground(new Color(95,46,234));
        lblResetPassword.setBounds(71, 39, 428, 21);
        contentPane.add(lblResetPassword);
        lblResetPassword.setFont(new Font("SansSerif", Font.BOLD, 19));

        lblConfirmSend = new JLabel("");
        lblConfirmSend.setFont(new Font("SansSerif", Font.PLAIN, 11));
        lblConfirmSend.setForeground(new Color(148, 0, 211));
        lblConfirmSend.setBounds(51, 201, 392, 16);
        contentPane.add(lblConfirmSend);

        lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblEmail.setBounds(51, 124, 79, 19);
        contentPane.add(lblEmail);

        //LISTENERS
        
        btnSend.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnSend.setIcon(new ImageIcon(ResetPassword.class.getResource("/img/img_login/Button (3).png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSend.setIcon(new ImageIcon(ResetPassword.class.getResource("/img/img_login/Button (4).png")));
            }
        });
        btnSend.setIcon(new ImageIcon(ResetPassword.class.getResource("/img/img_login/Button (4).png")));
        
        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(51, 154, 373, 43);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(ResetPassword.class.getResource("/img_tablesDirector/Search.png")));
        lblNewLabel.setBounds(10, 11, 37, 25);
        panel.add(lblNewLabel);
        
                //TEXTFIELDS
                
                txtEmail = new JTextField();
                txtEmail.setBackground(new Color(243,245,255));
                txtEmail.setBounds(40, 11, 323, 25);
                panel.add(txtEmail);
                txtEmail.setBorder(new LineBorder(new Color(102, 0, 204), 2, true));
                txtEmail.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        myController.sendReset();

                    }
                });
                txtEmail.setColumns(10);
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                myController.sendEmail();

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
    
    public void disableSend() {

        if (txtEmail.getText().length() > 0) {
            btnSend.setEnabled(true);
        } else if (txtEmail.getText().length() == 0) {
            btnSend.setEnabled(false);
        } else {
            btnSend.setEnabled(false);
        }

    }

    public void sendEmail() {
        String email = txtEmail.getText();

        if (email.equals("pedro@gmail.com")) {
            txtEmail.setText(null);
            myController.ChangeWindows(2, 0);

        } else {
            lblConfirmSend.setText("The email does not exists");
        }

    }
}
