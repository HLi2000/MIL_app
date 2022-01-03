import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login_full {
    public JFrame jFrame = new JFrame("Login");
    public Container c = jFrame.getContentPane();
    public JLabel a1 = new JLabel("username");
    public JTextField username = new JTextField();
    public JLabel a2 = new JLabel("password");
    public JPasswordField password = new JPasswordField();
    public JButton confirmbtn = new JButton("confirm");
    public JButton cancelbtn = new JButton("clear");
    private ImageIcon logo = new ImageIcon("image/a.png");
    private JLabel logo_label = new JLabel(logo);
    public boolean login_status = false;
    Color text_color = new Color(181, 181, 181);
    Color panel_color = new Color(54, 54, 54);
    Color message_color = new Color(238, 130, 130);
    Font f_1 = new Font(Font.DIALOG, Font.PLAIN, 13);


    public login_full() {
        this.jFrame.setBounds(600, 200, 400, 400);
        c.setLayout(null);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        this.jFrame.setVisible(true);

    }

    public void init() {

        JPanel logopanel = new JPanel();
        logopanel.setBounds(0, 0, 400, 130);
        logopanel.setBackground(panel_color);
        logo_label.setBounds(0, 0, 400, 130);
        logopanel.add(logo_label);
        jFrame.add(logopanel);


        /*输入部分--Center*/
        JPanel fieldPanel = new JPanel();
        fieldPanel.setBounds(0, 130, 400, 270);
        fieldPanel.setBackground(panel_color);
        fieldPanel.setLayout(null);
        a1.setBounds(60, 30, 100, 20);
        a2.setBounds(60, 60, 100, 20);
        a1.setFont(f_1);
        a2.setFont(f_1);
        a1.setForeground(text_color);
        a2.setForeground(text_color);
        fieldPanel.add(a1);
        fieldPanel.add(a2);
        username.setBounds(150, 30, 150, 25);
        password.setBounds(150, 60, 150, 25);
        fieldPanel.add(username);
        fieldPanel.add(password);
        jFrame.add(fieldPanel);

        confirmbtn.setBounds(100, 190, 75, 25);
        cancelbtn.setBounds(210, 190, 75, 25);
        fieldPanel.add(confirmbtn);
        fieldPanel.add(cancelbtn);
        jFrame.add(fieldPanel);
        loop();
    }


    public void loop() {
        cancelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                username.setText("");
                password.setText("");
            }
        });

        confirmbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                char[] pa = password.getPassword();
                String pa_s = String.valueOf(pa);

                if (username.getText().equals("123") && pa_s.equals("123")) {
                    login_status = true;
                    jFrame.setVisible(false);
                    search s = new search();
                } else {
                    JPanel messagepanel = new JPanel();
                    messagepanel.setBounds(0, 250, 400, 50);
                    messagepanel.setBackground(panel_color);
                    JLabel error_message = new JLabel("wrong username or password, please try again!");
                    Font f = new Font(Font.DIALOG, Font.BOLD, 15);
                    error_message.setFont(f);
                    error_message.setForeground(message_color);
                    messagepanel.add(error_message);
                    jFrame.add(messagepanel);
                    jFrame.setVisible(true);
                }
            }
        });
    }

/*
    public void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        new login_full(jFrame);
    }
}
*/
}