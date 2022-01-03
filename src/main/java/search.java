import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.*;




public class search {

    Boolean status = false;
    Boolean light = false;
    Boolean MRI = false;
    Boolean CT = false;
    Boolean US = false;
    Boolean XRay = false;
    //Boolean ECG = false;

    public static int flag = 0;

    public JFrame search_frame = new JFrame("Search");
    private Container search_c = search_frame.getContentPane();
    private JButton confirm = new JButton("confirm");
    public JButton mode = new JButton("mode");


    private JLabel region = new JLabel("Region");
    String[] choice_r = new String[]{"All", "Heart", "Arm", "Body", "Head", "Leg"};
    private JComboBox r_choice = new JComboBox(choice_r);
    private String[] region_choice = new String[5];



    private JLabel modality = new JLabel("Modality:");
    JCheckBox choice_MRI = new JCheckBox("MRI");
    JCheckBox choice_CT = new JCheckBox("CT");
    JCheckBox choice_US = new JCheckBox("Ultrasound");
    JCheckBox choice_XRay = new JCheckBox("XRay");
    //JCheckBox choice_ECG = new JCheckBox("ECG");
    private String[] modality_choice = new String[4];

    private JLabel patient = new JLabel("Patient Name:");
    private JTextField name = new JTextField();
    private String patient_name =new String();
    private String patient_name_cap = new String();



    private JPanel line = new JPanel();
    private JPanel display = new JPanel();
    Color line_color = new Color(190, 190, 190);
    Color fieldpanel_color = new Color(54, 54, 54);
    Color text_color = new Color(181, 181, 181);
    Color displaypanel_color = new Color(130, 130, 130);
    Font f = new Font(Font.DIALOG, Font.BOLD, 16);
    Color lightmode = new Color(255, 255, 255);


    public search() {

        search_frame.setBounds(250, 110, 1000, 800);
        search_c.setLayout(null);
        search_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        search_frame.setVisible(true);
        init();

    }


    public void init() {
        /*
        patient_name = name.getText();
        patient_name = patient_name.trim();
        String patient_name_cap = patient_name.substring(0, 1).toUpperCase() + patient_name.substring(1).toLowerCase();
        System.out.println("patientname:"+patient_name_cap);
*/
        JPanel fieldPanel = new JPanel();
        fieldPanel.setBackground(fieldpanel_color);
        fieldPanel.setBounds(0, 0, 295, 700);
        fieldPanel.setLayout(null);
        region.setBounds(20, 25, 70, 50);
        modality.setBounds(20, 100, 100, 20);
        patient.setBounds(20, 190, 130, 50);
        name.setBounds(20, 230, 200, 30);
        region.setFont(f);
        modality.setFont(f);
        patient.setFont(f);
        region.setForeground(text_color);
        modality.setForeground(text_color);
        patient.setForeground(text_color);
        r_choice.setForeground(text_color);
        r_choice.setBounds(100, 30, 150, 40);
        choice_MRI.setBounds(20, 130, 55, 20);
        choice_CT.setBounds(90, 130, 50, 20);
        choice_US.setBounds(150, 130, 105, 20);
        choice_XRay.setBounds(20, 160, 68, 20);
        //choice_ECG.setBounds(90, 160, 60, 20);
        choice_MRI.setForeground(text_color);
        choice_CT.setForeground(text_color);
        choice_US.setForeground(text_color);
        choice_XRay.setForeground(text_color);
        //choice_ECG.setForeground(text_color);
        fieldPanel.add(region);
        fieldPanel.add(modality);
        fieldPanel.add(patient);
        fieldPanel.add(r_choice);
        fieldPanel.add(choice_MRI);
        fieldPanel.add(choice_CT);
        fieldPanel.add(choice_US);
        fieldPanel.add(choice_XRay);
        //fieldPanel.add(choice_ECG);
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


        //confirm.addActionListener(new ActionListener() {
        //@Override
        //public void actionPerformed(ActionEvent ae) {
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
                    //choice_ECG.setForeground(fieldpanel_color);
                    //line.setBackground(fieldpanel_color);

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
                    //choice_ECG.setForeground(text_color);
                    //line.setBackground(line_color);
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
                        //region_choice = ;
                        //region_choice = {"Brain", "Heart", "Arm", "Chest", "Neck"};
                        //String[] region_choice = {};
                        //System.out.println("r_choice1 " + region_choice[0]);
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
                        //region_choice = null;
                        region_choice[0] = "Arm";
                        region_choice[1]= null;
                        region_choice[2]= null;
                        region_choice[3]= null;
                        region_choice[4]= null;
                        System.out.println("r_choice4 " + region_choice[0]);
                    } else if (r_choice.getSelectedItem().toString() == "Body") {
                        //region_choice = null;
                        region_choice[0] = "Body";
                        region_choice[1]= null;
                        region_choice[2]= null;
                        region_choice[3]= null;
                        region_choice[4]= null;
                        System.out.println("r_choice5 " + region_choice[0]);
                    } else if (r_choice.getSelectedItem().toString() == "Leg") {
                        //region_choice = null;
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
/*
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
*/
        /*
        boolean choice_mri_status = choice_MRI.isSelected();
        if (choice_mri_status) {
            modality_choice[0] = "MRI";
            System.out.println("modality_ "+modality_choice[0]);
        } else {
            modality_choice[0] = null;
        }

        boolean choice_CT_status = choice_CT.isSelected();
        if (choice_CT_status) {
            modality_choice[1] = "CT";
            System.out.println("modality_ "+modality_choice[1]);
        } else {
            modality_choice[1] = null;
        }

        boolean choice_US_status = choice_US.isSelected();
        if (choice_US_status) {
            modality_choice[2] = "US";
        } else {
            modality_choice[2] = null;
        }

        boolean choice_xray_status = choice_XRay.isSelected();
        if (choice_xray_status) {
            modality_choice[3] = "XRay";
        } else {
            modality_choice[3] = null;
        }
        */

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                display.removeAll();
                patient_name = name.getText();
                //System.out.println("patient_name"+patient_name);
                try {
                    patient_name = patient_name.trim();
                    patient_name_cap = patient_name.substring(0, 1).toUpperCase() + patient_name.substring(1).toLowerCase();

                } catch (Exception e) {
                    patient_name_cap = "";
                }

                //try {
                //display.removeAll();
                //patient_name = name.getText();
                //if(patient_name==""){
                //patient_name_cap = "";
                //}else {
                //patient_name = name.getText();
                //patient_name = patient_name.trim();
                //patient_name_cap = patient_name.substring(0, 1).toUpperCase() + patient_name.substring(1).toLowerCase();


                //patient_name_cap = null;
                System.out.println("region_choice " + Arrays.toString(region_choice));
                System.out.println("modality_choice " + Arrays.toString(modality_choice));
                System.out.println("patient_name_cap " + patient_name_cap);
                //String[] region_choice = {};
                //patient_name_cap = "peter";
                SearchInfo searchInfo = new SearchInfo(modality_choice, region_choice, patient_name_cap);
                //SearchInfo searchInfo = new SearchInfo(modality_a, region_a, patient_name_cap);

                Client cl = new Client();

                Img[] img_a;

                try {
                    img_a = cl.search(searchInfo);
                } catch (Exception e) {
                    e.printStackTrace();
                    img_a = new Img[]{};
                }


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

                    //JFrame frame = new JFrame();
                    ImageIcon imageIcon = new ImageIcon(image);
                    JLabel label = new JLabel(imageIcon);
                    //public String name(JLabel l){
                    //    String title = label.getText();
                    //  return title;
                    //}
                    label.setText(img.getFile_name());
                    //label.setBounds(200, 600, 1000, 1000);
                    //frame.getContentPane().add(label, BorderLayout.CENTER);
                    display.add(label);
                    //frame.pack();
                    //frame.setVisible(true);
                    label.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);

                            //ImageIcon image = new ImageIcon("image/b.jpg");
                            //JLabel image_label = new JLabel(image);

                            //String img_selected=img;
                            //img_selected.setFile_name("ct head 1.dcm");
                            //Client cl = new Client();
                            try {
                                InputStream img_stream=cl.getImg(img);
                                Image image = ImageIO.read(img_stream);
                                zoom z = new zoom(image);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }

                        }
                    });
                }


            }
        });
        /*
        if (confirm.getModel().isPressed()) {
            patient_name = name.getText();
            patient_name = patient_name.trim();
            String patient_name_cap = patient_name.substring(0, 1).toUpperCase() + patient_name.substring(1).toLowerCase();

            System.out.println(Arrays.toString(region_choice));
            System.out.println(Arrays.toString(modality_choice));

            SearchInfo searchInfo = new SearchInfo(modality_choice, region_choice, patient_name_cap);

            Client cl = new Client();

            Img[] img_a;

            try {
                img_a = cl.search(searchInfo);
            } catch (Exception e) {
                e.printStackTrace();
                img_a = new Img[]{};
            }
            for (Img img : img_a) {
                System.out.println("img.getFile_name() " + img.getFile_name());
                flag++;
                System.out.println("flag " + flag);
                //break;
            }
            /*
            //for test
            Image image = ImageIO.read(img.getThumbnail());
            JFrame frame = new JFrame();
            JLabel label = new JLabel(new ImageIcon(image));
            frame.getContentPane().add(label, BorderLayout.CENTER);
            frame.pack();
            frame.setVisible(true);
        }

        //click actionListener should set img_selected
        Img img_selected=new Img();
        img_selected.setFile_name("ct head 1.dcm");
        InputStream img_stream=cl.getImg(img_selected);

        status = true;
        region_choice = null;
        modality_choice = null;
    }
    /*
    public String[] return_modality(){
        return modality_choice;
}

    public String[] return_region() {
        return region_choice;
    }

    public String return_patient_name(){
        return patient_name;
    }

    public void display(){
        Main a = new Main();
        int image_number =a.flag;

    }


/*
    public static void main (String[]args){
        try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            new search();
        }
        */

    }
}
