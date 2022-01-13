package UI;

import Entities.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * The UI.search is used to provide user a panel to search and display the images filtered by the chosen conditions
 *
 * @author  Shiyu Wang, Yurong Chen
 * @since   2021-12-05
 */

public class Search extends JFrame {
    Boolean light = false;
    Boolean MRI = false;
    Boolean CT = false;
    Boolean US = false;
    Boolean XRay = false;
    Boolean ECG = false;

    public static int flag = 0;

    /* settings of basic components*/
    private Container search_c = getContentPane();
    JButton confirm = new JButton("confirm");
    JButton mode = new JButton("mode");


    // Region
    JLabel region = new JLabel("Region");
    String[] choice_r = new String[]{"All", "Heart", "Arm", "Body", "Head", "Leg"};
    JComboBox r_choice = new JComboBox(choice_r);
    String[] region_choice = new String[5];

    // Modality
    JLabel modality = new JLabel("Modality:");
    JCheckBox choice_MRI = new JCheckBox("MRI");
    JCheckBox choice_CT = new JCheckBox("CT");
    JCheckBox choice_US = new JCheckBox("Ultrasound");
    JCheckBox choice_XRay = new JCheckBox("XRay");
    JCheckBox choice_ECG = new JCheckBox("ECG");
    String[] modality_choice = new String[5];


    // Patient name
    JLabel patient = new JLabel("Patient Name:");
    private JTextField name = new JTextField();
    private String patient_name = new String();
    private String patient_name_cap = new String();

    JPanel line = new JPanel();
    private JPanel display = new JPanel();
    private JPanel display_2= new JPanel();
    private  JPanel display_3= new JPanel();
    private JPanel result_number = new JPanel();
    //JLabel hello_lbel = new JLabel();
    private JPanel cardlayout = new JPanel();
    private CardLayout card = new CardLayout();


    //cardlayout button
    private JButton btn_1 = new JButton("page 1");
    private JButton btn_2 = new JButton("page 2");
    private JButton btn_3 = new JButton("page 3");



    // Colors
    Color line_color = new Color(190, 190, 190);
    Color fieldpanel_color = new Color(54, 54, 54);
    Color text_color = new Color(181, 181, 181);
    Color displaypanel_color = new Color(130, 130, 130);
    Color lightmode = new Color(255, 255, 255);
    Color result_color = new Color(238, 238, 209);
    Color welcome_color = new Color(209, 238, 238);
    Color welcome_lightmode = new Color(180, 205, 205);
    Font f = new Font(Font.DIALOG, Font.BOLD, 16);
    Font welcome_f = new Font(Font.DIALOG, Font.BOLD, 20);


    /**
     * The method Search() creates a frame without any component
     *
     * @param s
     */
    public Search(String s) {
        super("Search");
        setBounds(250, 110, 1000, 800);
        search_c.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        /**
         * The method init() is to put components(panel,button,combobox,textfield,label, checkbox)
         * on the frame created before
         *Then add listeners to the buttons and display images
         */

        JPanel fieldPanel = new JPanel();
        fieldPanel.setBackground(fieldpanel_color);
        fieldPanel.setBounds(0, 0, 295, 700);
        //search_frame.setResizable(false);
        fieldPanel.setLayout(null);
        JLabel welcome_label = new JLabel("Hello,user " +s);
        welcome_label.setBounds(20, 10, 300, 50);
        region.setBounds(20, 75, 70, 50);
        modality.setBounds(20, 125, 100, 20);
        patient.setBounds(20, 215, 130, 50);
        name.setBounds(20, 255, 200, 30);
        r_choice.setBounds(100, 85, 150, 40);
        choice_MRI.setBounds(20, 155, 55, 20);
        choice_CT.setBounds(90, 155, 50, 20);
        choice_US.setBounds(150, 155, 105, 20);
        choice_XRay.setBounds(20, 185, 68, 20);
        choice_ECG.setBounds(90, 185, 60, 20);

        // set font
        region.setFont(f);
        modality.setFont(f);
        patient.setFont(f);
        welcome_label.setFont(welcome_f);

        //set color of text
        region.setForeground(text_color);
        modality.setForeground(text_color);
        patient.setForeground(text_color);
        r_choice.setForeground(text_color);
        choice_MRI.setForeground(text_color);
        choice_CT.setForeground(text_color);
        choice_US.setForeground(text_color);
        choice_XRay.setForeground(text_color);
        choice_ECG.setForeground(text_color);
        welcome_label.setForeground(welcome_color);

        // add components to the panel
        fieldPanel.add(region);
        fieldPanel.add(modality);
        fieldPanel.add(patient);
        fieldPanel.add(r_choice);
        fieldPanel.add(choice_MRI);
        fieldPanel.add(choice_CT);
        fieldPanel.add(choice_US);
        fieldPanel.add(choice_XRay);
        fieldPanel.add(choice_ECG);
        fieldPanel.add(name);
        fieldPanel.add(welcome_label);
        add(fieldPanel);

        //display panel
        display.setBounds(305, 0, 695, 670);
        display_2.setBounds(305,0,695,670);
        display_3.setBounds(305,0,695,670);
        display.setBackground(displaypanel_color);
        display_2.setBackground(displaypanel_color);
        display_3.setBackground(displaypanel_color);
        display.setLayout(null);
        display_2.setLayout(null);
        display_3.setLayout(null);
        add(display);

        //result number panel
        result_number.setBounds(305, 730, 695, 50);
        result_number.setBackground(displaypanel_color);
        add(result_number);

        //cardlayout panel and button
        CardLayout card=new CardLayout();
        cardlayout.setBounds(305,670,695,60);
        cardlayout.setBackground(displaypanel_color);
        btn_1.setBounds(100,10,100,50);
        cardlayout.add(btn_1);
        cardlayout.add(btn_2);
        cardlayout.add(btn_3);
        //cardlayout.setLayout(card);
        add(cardlayout);
        cardlayout.setVisible(true);


        //line panel
        line.setBounds(301, 0, 5, 800);
        line.setBackground(line_color);
        add(line);

        //confirm button and panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(fieldpanel_color);
        buttonPanel.setBounds(0, 700, 295, 100);
        confirm.setBounds(100, 30, 100, 40);
        buttonPanel.add(confirm);
        buttonPanel.add(mode);
        add(buttonPanel);


        /* add listener to the 'mode' button and let user can choose background color of the search frame*/
        mode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!light) {
                    fieldPanel.setBackground(lightmode);
                    display.setBackground(text_color);
                    result_number.setBackground(text_color);
                    buttonPanel.setBackground(lightmode);
                    welcome_label.setForeground(welcome_lightmode);
                    region.setForeground(fieldpanel_color);
                    modality.setForeground(fieldpanel_color);
                    patient.setForeground(fieldpanel_color);
                    r_choice.setForeground(fieldpanel_color);
                    choice_MRI.setForeground(fieldpanel_color);
                    choice_CT.setForeground(fieldpanel_color);
                    choice_US.setForeground(fieldpanel_color);
                    choice_XRay.setForeground(fieldpanel_color);
                    choice_ECG.setForeground(fieldpanel_color);
                    line.setBackground(fieldpanel_color);

                    light = true;
                } else {
                    fieldPanel.setBackground(fieldpanel_color);
                    display.setBackground(displaypanel_color);
                    result_number.setBackground(displaypanel_color);
                    buttonPanel.setBackground(fieldpanel_color);
                    welcome_label.setForeground(welcome_color);
                    region.setForeground(text_color);
                    modality.setForeground(text_color);
                    patient.setForeground(text_color);
                    r_choice.setForeground(text_color);
                    choice_MRI.setForeground(text_color);
                    choice_CT.setForeground(text_color);
                    choice_US.setForeground(text_color);
                    choice_XRay.setForeground(text_color);
                    choice_ECG.setForeground(text_color);
                    line.setBackground(line_color);
                    light = false;
                }
            }
        });

        region_choice[0] = "Head";
        region_choice[1] = "Heart";
        region_choice[2] = "Arm";
        region_choice[3] = "Body";
        region_choice[4] = "Leg";

        r_choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (r_choice.getSelectedItem().toString() == "All") {
                        region_choice[0] = "Head";
                        region_choice[1] = "Heart";
                        region_choice[2] = "Arm";
                        region_choice[3] = "Body";
                        region_choice[4] = "Leg";
                        System.out.println("r_choice1 " + r_choice.getSelectedItem().toString());
                    } else if (r_choice.getSelectedItem().toString() == "Head") {
                        region_choice[0] = "Head";
                        region_choice[1] = null;
                        region_choice[2] = null;
                        region_choice[3] = null;
                        region_choice[4] = null;
                        System.out.println("r_choice2 " + region_choice[0]);
                    } else if (r_choice.getSelectedItem().toString() == "Heart") {
                        region_choice[0] = "Heart";
                        region_choice[1] = null;
                        region_choice[2] = null;
                        region_choice[3] = null;
                        region_choice[4] = null;
                        System.out.println("r_choice3 " + region_choice[0]);
                    } else if (r_choice.getSelectedItem().toString() == "Arm") {
                        region_choice[0] = "Arm";
                        region_choice[1] = null;
                        region_choice[2] = null;
                        region_choice[3] = null;
                        region_choice[4] = null;
                        System.out.println("r_choice4 " + region_choice[0]);
                    } else if (r_choice.getSelectedItem().toString() == "Body") {
                        region_choice[0] = "Body";
                        region_choice[1] = null;
                        region_choice[2] = null;
                        region_choice[3] = null;
                        region_choice[4] = null;
                        System.out.println("r_choice5 " + region_choice[0]);
                    } else if (r_choice.getSelectedItem().toString() == "Leg") {
                        region_choice[0] = "Leg";
                        region_choice[1] = null;
                        region_choice[2] = null;
                        region_choice[3] = null;
                        region_choice[4] = null;
                        System.out.println("r_choice6 " + region_choice[0]);
                    }
                }
            }
        });

        choice_MRI.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (!MRI) {
                    modality_choice[0] = "MRI";
                    System.out.println("modality " + modality_choice[0]);
                    MRI = true;
                } else {
                    modality_choice[0] = null;
                    MRI = false;
                }
            }
        });
        choice_CT.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (!CT) {
                    modality_choice[1] = "CT";
                    System.out.println("modality " + modality_choice[1]);
                    CT = true;
                } else {
                    modality_choice[1] = null;
                    CT = false;
                }
            }
        });
        choice_US.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (!US) {
                    modality_choice[2] = "Ultrasound";
                    System.out.println("modality " + modality_choice[2]);
                    US = true;
                } else {
                    modality_choice[2] = null;
                    US = false;
                }
            }
        });

        choice_XRay.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (!XRay) {
                    modality_choice[3] = "X Ray";
                    System.out.println("modality " + modality_choice[3]);
                    XRay = true;
                } else {
                    modality_choice[3] = null;
                    XRay = false;
                }
            }
        });

        choice_ECG.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (!ECG) {
                    modality_choice[4] = "ECG";
                    System.out.println("modality " + modality_choice[4]);
                    ECG = true;
                } else {
                    modality_choice[4] = null;
                    ECG = false;
                }
            }
        });


        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                display.removeAll();
                display.revalidate();
                display.repaint();

                patient_name = name.getText();
                try {
                    patient_name = patient_name.trim();
                    patient_name_cap = patient_name.substring(0, 1).toUpperCase() + patient_name.substring(1).toLowerCase();

                } catch (Exception e) {
                    patient_name_cap = "";
                }

                System.out.println("region_choice " + Arrays.toString(region_choice));
                System.out.println("modality_choice " + Arrays.toString(modality_choice));
                System.out.println("patient_name_cap " + patient_name_cap);
                SearchInfo searchInfo = new SearchInfo(modality_choice, region_choice, patient_name_cap);

                Client cl = new Client();

                Img[] img_a;

                try {
                    img_a = cl.search(searchInfo);
                } catch (Exception e) {
                    e.printStackTrace();
                    img_a = new Img[]{};
                }

                flag = 0;
                result_number.removeAll();

                for (Img img : img_a) {
                    flag++;
                    Image image = null;
                    try {
                        image = ImageIO.read(img.getThumbnail());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    ImageIcon imageIcon = new ImageIcon(image);
                    JLabel label = new JLabel(imageIcon);
                    String file_name = img.getFile_name();

                    if (flag<=16) {
                        if ((flag % 4) == 1) {
                            label.setBounds(40, 30 + (flag - 1) * 40, 100, 100);
                            JLabel filename_label = new JLabel(file_name);
                            filename_label.setBounds(40, 140 + (flag - 1) * 40, 100, 20);
                            display.add(label);
                            display.add(filename_label);
                        } else if ((flag % 4) == 2) {
                            label.setBounds(190, 30 + (flag - 2) * 40, 100, 100);
                            JLabel filename_label = new JLabel(file_name);
                            filename_label.setBounds(190, 140 + (flag - 2) * 40, 100, 20);
                            display.add(label);
                            display.add(filename_label);
                        } else if ((flag % 4) == 3) {
                            label.setBounds(340, 30 + (flag - 3) * 40, 100, 100);
                            JLabel filename_label = new JLabel(file_name);
                            filename_label.setBounds(340, 140 + (flag - 3) * 40, 100, 20);
                            display.add(label);
                            display.add(filename_label);
                        } else if ((flag % 4) == 0) {
                            label.setBounds(490, 30 + (flag - 4) * 40, 100, 100);
                            JLabel filename_label = new JLabel(file_name);
                            filename_label.setBounds(490, 140 + (flag - 4) * 40, 100, 20);
                            display.add(label);
                            display.add(filename_label);
                        }
                        display.repaint();
                    }

                    if (flag>16 && flag<=32){
                        if ((flag % 4) == 1) {
                            label.setBounds(40, 30 + (flag - 1) * 40, 100, 100);
                            JLabel filename_label = new JLabel(file_name);
                            filename_label.setBounds(40, 140 + (flag - 1) * 40, 100, 20);
                            display_2.add(label);
                            display_2.add(filename_label);
                        } else if ((flag % 4) == 2) {
                            label.setBounds(190, 30 + (flag - 2) * 40, 100, 100);
                            JLabel filename_label = new JLabel(file_name);
                            filename_label.setBounds(190, 140 + (flag - 2) * 40, 100, 20);
                            display_2.add(label);
                            display.add(filename_label);
                        } else if ((flag % 4) == 3) {
                            label.setBounds(340, 30 + (flag - 3) * 40, 100, 100);
                            JLabel filename_label = new JLabel(file_name);
                            filename_label.setBounds(340, 140 + (flag - 3) * 40, 100, 20);
                            display_2.add(label);
                            display.add(filename_label);
                        } else if ((flag % 4) == 0) {
                            label.setBounds(490, 30 + (flag - 4) * 40, 100, 100);
                            JLabel filename_label = new JLabel(file_name);
                            filename_label.setBounds(490, 140 + (flag - 4) * 40, 100, 20);
                            display_2.add(label);
                            display_2.add(filename_label);

                        }
                        add(display_2);
                        display_2.repaint();
                        btn_2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                display_2.setVisible(true);
                                display_2.repaint();
                                display_2.revalidate();

                            }
                        });

                    }
                    label.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            try {
                                InputStream img_stream = cl.getImg(img);
                                Image image = ImageIO.read(img_stream);
                                Zoom z = new Zoom(image, file_name);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                }
                //display.setVisible(true);
                JLabel result_text = new JLabel("found " + flag + " result(s)");
                result_text.setFont(f);
                result_text.setForeground(result_color);
                result_number.add(result_text);
                result_number.repaint();

            }
        });
    }
}

