import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Search {
    Boolean light = false;
    Boolean MRI = false;
    Boolean CT = false;
    Boolean US = false;
    Boolean XRay = false;
    Boolean ECG = false;

    public static int flag = 0;

    public JFrame search_frame = new JFrame("Search");
    private Container search_c = search_frame.getContentPane();
    private JButton confirm = new JButton("confirm");
    public JButton mode = new JButton("mode");

    //region panel components
    private JLabel region = new JLabel("Region");
    String[] choice_r = new String[]{"All", "Heart", "Arm", "Body", "Head", "Leg"};
    private JComboBox r_choice = new JComboBox(choice_r);
    private String[] region_choice = new String[5];


    //modality panel components
    private JLabel modality = new JLabel("Modality:");
    JCheckBox choice_MRI = new JCheckBox("MRI");
    JCheckBox choice_CT = new JCheckBox("CT");
    JCheckBox choice_US = new JCheckBox("Ultrasound");
    JCheckBox choice_XRay = new JCheckBox("XRay");
    JCheckBox choice_ECG = new JCheckBox("ECG");
    private String[] modality_choice = new String[5];

    //patient name panel components
    private JLabel patient = new JLabel("Patient Name:");
    private JTextField name = new JTextField();
    private String patient_name =new String();
    private String patient_name_cap = new String();

    //hello panel
    private JPanel hello_panel = new JPanel();
    private  JLabel hello = new JLabel("Hello,");
    //private JLabel hello_user = new JLabel();

    private JPanel line = new JPanel();

    private JPanel display = new JPanel();

    //colors and fronts
    Color line_color = new Color(190, 190, 190);
    Color fieldpanel_color = new Color(54, 54, 54);
    Color text_color = new Color(181, 181, 181);
    Color displaypanel_color = new Color(130, 130, 130);
    Color hello_color = new Color(179,196,222);
    Color lightmode = new Color(255, 255, 255);
    Font f = new Font(Font.DIALOG, Font.BOLD, 16);
    Font hello_f  = new Font(Font.DIALOG, Font.BOLD, 23);



    public Search() {

        search_frame.setBounds(250, 110, 1000, 800);
        search_c.setLayout(null);
        search_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        search_frame.setResizable(false);
        search_frame.setVisible(true);
        init();

    }


    public void init() {

        //search panel with components
        JPanel fieldPanel = new JPanel();
        fieldPanel.setBackground(fieldpanel_color);
        fieldPanel.setBounds(0, 0, 295, 700);
        fieldPanel.setLayout(null);
        hello.setBounds(20,0,200,50);
        region.setBounds(20, 75, 70, 50);
        modality.setBounds(20, 150, 100, 20);
        patient.setBounds(20, 240, 130, 50);
        name.setBounds(20, 280, 200, 30);
        region.setFont(f);
        modality.setFont(f);
        patient.setFont(f);
        hello.setFont(hello_f);
        region.setForeground(text_color);
        modality.setForeground(text_color);
        patient.setForeground(text_color);
        hello.setForeground(hello_color);
        r_choice.setForeground(text_color);
        r_choice.setBounds(100, 80, 150, 40);
        choice_MRI.setBounds(20, 180, 55, 20);
        choice_CT.setBounds(90, 180, 50, 20);
        choice_US.setBounds(150, 180, 105, 20);
        choice_XRay.setBounds(20, 210, 68, 20);
        choice_ECG.setBounds(90, 210, 60, 20);
        choice_MRI.setForeground(text_color);
        choice_CT.setForeground(text_color);
        choice_US.setForeground(text_color);
        choice_XRay.setForeground(text_color);
        choice_ECG.setForeground(text_color);
        fieldPanel.add(region);
        fieldPanel.add(modality);
        fieldPanel.add(patient);
        fieldPanel.add(hello);
        fieldPanel.add(r_choice);
        fieldPanel.add(choice_MRI);
        fieldPanel.add(choice_CT);
        fieldPanel.add(choice_US);
        fieldPanel.add(choice_XRay);
        fieldPanel.add(choice_ECG);
        fieldPanel.add(name);
        search_frame.add(fieldPanel);


        //display panel
        display.setBounds(305, 0, 695, 800);
        display.setBackground(displaypanel_color);
        search_frame.add(display);


        //line panel
        line.setBounds(301, 0, 5, 800);
        line.setBackground(line_color);
        search_frame.add(line);

        //confirm button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(fieldpanel_color);
        buttonPanel.setBounds(0, 700, 295, 100);
        confirm.setBounds(100, 30, 100, 40);
        buttonPanel.add(confirm);
        buttonPanel.add(mode);
        search_frame.add(buttonPanel);

        mode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!light) {
                    fieldPanel.setBackground(lightmode);
                    display.setBackground(text_color);
                    buttonPanel.setBackground(lightmode);
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
                    buttonPanel.setBackground(fieldpanel_color);
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
        //System.out.println("region choice " + region_choice);
        region_choice[0]="Head";
        region_choice[1]="Heart";
        region_choice[2]="Arm";
        region_choice[3]="Body";
        region_choice[4]="Leg";

        r_choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (r_choice.getSelectedItem().toString() == "All") {
                        region_choice[0]="Head";
                        region_choice[1]="Heart";
                        region_choice[2]="Arm";
                        region_choice[3]="Body";
                        region_choice[4]="Leg";
                        System.out.println("r_choice1 " + r_choice.getSelectedItem().toString());
                    } else if (r_choice.getSelectedItem().toString() == "Head") {
                        region_choice[0] = "Head";
                        region_choice[1]= null;
                        region_choice[2]= null;
                        region_choice[3]= null;
                        region_choice[4]= null;
                        System.out.println("r_choice2 " + region_choice[0]);
                    } else if (r_choice.getSelectedItem().toString() == "Heart") {
                        region_choice[0] = "Heart";
                        region_choice[1]= null;
                        region_choice[2]= null;
                        region_choice[3]= null;
                        region_choice[4]= null;
                        System.out.println("r_choice3 " + region_choice[0]);
                    } else if (r_choice.getSelectedItem().toString() == "Arm") {
                        region_choice[0] = "Arm";
                        region_choice[1]= null;
                        region_choice[2]= null;
                        region_choice[3]= null;
                        region_choice[4]= null;
                        System.out.println("r_choice4 " + region_choice[0]);
                    } else if (r_choice.getSelectedItem().toString() == "Body") {
                        region_choice[0] = "Body";
                        region_choice[1]= null;
                        region_choice[2]= null;
                        region_choice[3]= null;
                        region_choice[4]= null;
                        System.out.println("r_choice5 " + region_choice[0]);
                    } else if (r_choice.getSelectedItem().toString() == "Leg") {
                        region_choice[0] = "Leg";
                        region_choice[1]= null;
                        region_choice[2]= null;
                        region_choice[3]= null;
                        region_choice[4]= null;
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



        int confirm_flag = 0;
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                display.removeAll();
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
                for (Img img : img_a) {
                    System.out.println("img.getFile_name() " + img.getFile_name());
                    flag++;
                    System.out.println("flag " + flag);
                    //break;

                    Image image = null;
                    try {
                        image = ImageIO.read(img.getThumbnail());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    ImageIcon imageIcon = new ImageIcon(image);
                    JLabel label = new JLabel(imageIcon);
                    String file_name = img.getFile_name();
                    label.setText(file_name);
                    display.add(label);
                    display.revalidate();

                    label.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);

                            try {
                                InputStream img_stream=cl.getImg(img);
                                Image image = ImageIO.read(img_stream);
                                zoom z = new zoom(image, file_name);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }

                        }
                    });
                }


            }
        });

    }
}
