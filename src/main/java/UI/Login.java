package UI;

import Entities.*;

import javax.swing.*;
import java.awt.*;



/**
 * The UI.Login is used to let user text their username and password and log in to the search engine
 *
 * @author  Shiyu Wang, Yurong Chen
 * @since   2021-12-05
 */


public class Login extends JFrame {

    private final JTextField username = new JTextField();
    private final JPasswordField password = new JPasswordField();
    JLabel a1 = new JLabel("Username");
    JLabel a2 = new JLabel("Password");

    JButton confirmbtn = new JButton("confirm");
    JButton cancelbtn = new JButton("clear");
    ImageIcon logo = new ImageIcon("img/whiteLogo.png");
    JLabel logo_label = new JLabel(logo);
    public boolean login_status = false;

    //basic properties
    Color text_color = new Color(181, 181, 181);
    Color panel_color = new Color(54, 54, 54);
    Color message_color = new Color(238, 130, 130);
    Font f_1 = new Font(Font.DIALOG, Font.PLAIN, 13);


    /**
     * The method Login () creates a frame without any component
     */
    public Login() {
        super("Login");
        Container c = getContentPane();
        setBounds(600, 200, 350, 400);
        setResizable(false);
        c.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        setVisible(true);
    }

    /**
     * The method init() is to put components on the login frame
     */
    public void init() {
        //logo panel
        JPanel logopanel = new JPanel();
        logopanel.setBounds(0, 0, 350, 130);
        logopanel.setBackground(panel_color);
        logo_label.setBounds(0, 0, 350, 130);
        logopanel.add(logo_label);
        add(logopanel);

        /* Type Center*/
        JPanel fieldPanel = new JPanel();
        fieldPanel.setBounds(0, 130, 350, 270);
        fieldPanel.setBackground(panel_color);
        fieldPanel.setLayout(null);
        a1.setBounds(40, 48, 100, 20);
        a2.setBounds(40, 78, 100, 20);
        a1.setFont(f_1);
        a2.setFont(f_1);
        a1.setForeground(text_color);
        a2.setForeground(text_color);
        fieldPanel.add(a1);
        fieldPanel.add(a2);
        username.setBounds(110, 45, 175, 25);
        password.setBounds(110, 75, 175, 25);
        fieldPanel.add(username);
        fieldPanel.add(password);
        add(fieldPanel);

        confirmbtn.setBounds(75, 190, 75, 25);
        cancelbtn.setBounds(190, 190, 75, 25);
        fieldPanel.add(confirmbtn);
        fieldPanel.add(cancelbtn);
        add(fieldPanel);
        loop();
    }

    /**
     * The loop() method allows users to see the feedback and make changes to their
     * user and password until they login successfully
     */
    public void loop() {
        cancelbtn.addActionListener(actionEvent -> {
            /*clear the textfield after pressing 'clear' button*/
            username.setText("");
            password.setText("");
        });

        final String[] result = {null};
        confirmbtn.addActionListener(ae -> {
            char[] pa = password.getPassword();
            String pa_s = String.valueOf(pa);
            String user_name = username.getText();
            User user_login = new User();
            user_login.setUsername(user_name);
            user_login.setPassword(pa_s);
            user_login.hashcode();
            Client c = new Client();

            try {
                result[0] = c.login(user_login);
            } catch (Exception E) {
                System.out.println("failed to login");
            }
            if (result[0].equals("Login Successful")) {
                login_status = true;
                setVisible(false);
                new Search();
            } else {
                JPanel messagepanel = new JPanel();
                messagepanel.setBounds(0, 250, 350, 50);
                messagepanel.setBackground(panel_color);
                JLabel error_message = new JLabel(result[0]);
                error_message.setBounds(0, 10, 400, 30);
                Font f = new Font(Font.DIALOG, Font.BOLD, 11);
                error_message.setFont(f);
                error_message.setForeground(message_color);
                messagepanel.add(error_message);
                add(messagepanel);
                setVisible(true);
            }

        });
    }
}
