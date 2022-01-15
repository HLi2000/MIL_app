package UI;

import Entities.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Objects;

/**
 * The UI.search is used to provide user a panel to search and display the images filtered by the chosen conditions
 *
 * @author  Shiyu Wang, Yurong Chen
 * @since   2021-12-05
 */

public class Search extends JFrame {

    Boolean light = false; // mode
    public static int flag = 0; //number of images shown

    JButton confirm = new JButton("confirm");
    JButton mode = new JButton("mode");
    JPanel line = new JPanel();
    private final JPanel numberPanel = new JPanel();

    // Region
    JLabel region = new JLabel("Region");
    String[] choice_r = new String[]{"All", "Heart", "Arm", "Body", "Head", "Leg"};
    JComboBox<String> r_choice = new JComboBox<>(choice_r);
    String[] region_choice = new String[5];

    // Modality
    JLabel modality = new JLabel("Modality:");
    JCheckBox choice_MRI = new JCheckBox("MRI");
    JCheckBox choice_CT = new JCheckBox("CT");
    JCheckBox choice_US = new JCheckBox("Ultrasound");
    JCheckBox choice_XRay = new JCheckBox("XRay");
    String[] modality_choice = new String[4];

    // Patient name
    JLabel patient = new JLabel("Patient Name:");
    private final JTextField name = new JTextField();
    private String patient_name = "";
    private String patient_name_cap = "";

    // Colors and fonts
    Color line_color = new Color(190, 190, 190);
    Color fieldpanel_color = new Color(54, 54, 54);
    Color text_color = new Color(181, 181, 181);
    Color displaypanel_color = new Color(130, 130, 130);
    Color lightmode = new Color(255, 255, 255);
    Color result_color = new Color(112, 128, 144);
    Color welcome_color = new Color(193,205,205);
    Color welcome_color_light = new Color(42,120,165);
    Font f = new Font(Font.DIALOG, Font.BOLD, 16);
    Font welcome_f = new Font(Font.DIALOG, Font.BOLD, 20);

    /**
     * The method Search() creates a frame without any component
     * */
    public Search() {
        super("Search");
        setBounds(300, 70, 900, 717);
        setMinimumSize(new Dimension(750,700));
        /* settings of basic components */
        Container search_c = getContentPane();
        search_c.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        init();
    }

    /**
     * The method init() is to put components(panel,button,combobox,textfield,label, checkbox)
     * on the frame created before
     *Then add listeners to the buttons and display images
     */
    public void init() {

        // top left search panel initialize
        JPanel fieldPanel = new JPanel();
        fieldPanel.setBackground(fieldpanel_color);
        fieldPanel.setBounds(0,0,295,getHeight()-150);
        fieldPanel.setLayout(null);

        // middle left number of images panel
        numberPanel.setBackground(fieldpanel_color);
        numberPanel.setBounds(0, getHeight()-150, 295, 50);

        // get system time to set relevant welcome label
        Calendar cal=Calendar.getInstance();
        int time = cal.get(Calendar.HOUR_OF_DAY);
        JLabel welcome_label = new JLabel();
        welcome_label.setBounds(20, 10, 200, 50);
        welcome_label.setFont(welcome_f);
        if (time>4 && time<12){
            welcome_label.setText("Good Morning!");
            welcome_label.setForeground(welcome_color_light);
            fieldPanel.add(welcome_label);
            light = true;
        }else if(time>=12 && time<20){
            welcome_label.setText("Good Afternoon!");
            welcome_label.setForeground(welcome_color);
            fieldPanel.add(welcome_label);
            light = false;
        }else{
            welcome_label.setText("Good Evening!");
            welcome_label.setForeground(welcome_color);
            fieldPanel.add(welcome_label);
            light = false;
        }

        // set bounds to components in top left search panel
        region.setBounds(20, 75, 70, 50);
        modality.setBounds(20, 133, 100, 20);
        patient.setBounds(20, 215, 130, 50);
        name.setBounds(20, 255, 215, 30);
        r_choice.setBounds(100, 83, 135, 35);
        choice_MRI.setBounds(20, 163, 55, 20);
        choice_CT.setBounds(90, 163, 50, 20);
        choice_US.setBounds(150, 163, 105, 20);
        choice_XRay.setBounds(20, 193, 68, 20);

        // set font
        region.setFont(f);
        modality.setFont(f);
        patient.setFont(f);

        // line panel
        line.setBounds(301, 0, 5, 800);
        line.setBackground(line_color);
        add(line);

        // confirm button and panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(0, getHeight()-100, 295, 100);
        confirm.setBounds(100, 30, 100, 40);
        buttonPanel.add(confirm);
        buttonPanel.add(mode);

        // mode color
        if (!light){
            getContentPane().setBackground(displaypanel_color);
            fieldPanel.setBackground(fieldpanel_color);
            numberPanel.setBackground(fieldpanel_color);
            buttonPanel.setBackground(fieldpanel_color);
            region.setForeground(text_color);
            modality.setForeground(text_color);
            patient.setForeground(text_color);
            r_choice.setForeground(text_color);
            choice_MRI.setForeground(text_color);
            choice_CT.setForeground(text_color);
            choice_US.setForeground(text_color);
            choice_XRay.setForeground(text_color);
            line.setBackground(line_color);
        }else{
            getContentPane().setBackground(line_color);
            fieldPanel.setBackground(lightmode);
            numberPanel.setBackground(lightmode);
            buttonPanel.setBackground(lightmode);
            region.setForeground(fieldpanel_color);
            modality.setForeground(fieldpanel_color);
            patient.setForeground(fieldpanel_color);
            r_choice.setForeground(fieldpanel_color);
            choice_MRI.setForeground(fieldpanel_color);
            choice_CT.setForeground(fieldpanel_color);
            choice_US.setForeground(fieldpanel_color);
            choice_XRay.setForeground(fieldpanel_color);
            line.setBackground(fieldpanel_color);
        }

        // add components to top left search panel
        fieldPanel.add(region);
        fieldPanel.add(modality);
        fieldPanel.add(patient);
        fieldPanel.add(r_choice);
        fieldPanel.add(choice_MRI);
        fieldPanel.add(choice_CT);
        fieldPanel.add(choice_US);
        fieldPanel.add(choice_XRay);
        fieldPanel.add(name);

        //add left panels to frame
        add(fieldPanel);
        add(numberPanel);
        add(buttonPanel);

        // region choice initialize
        region_choice[0] = "Head";
        region_choice[1] = "Heart";
        region_choice[2] = "Arm";
        region_choice[3] = "Body";
        region_choice[4] = "Leg";

        /* add listener to 'region choice' combobox to get the selected region */
        r_choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (Objects.equals(Objects.requireNonNull(r_choice.getSelectedItem()).toString(), "All")) {
                        region_choice[0] = "Head";
                        region_choice[1] = "Heart";
                        region_choice[2] = "Arm";
                        region_choice[3] = "Body";
                        region_choice[4] = "Leg";
                    } else if (Objects.equals(r_choice.getSelectedItem().toString(), "Head")) {
                        region_choice[0] = "Head";
                        region_choice[1] = null;
                        region_choice[2] = null;
                        region_choice[3] = null;
                        region_choice[4] = null;
                    } else if (Objects.equals(r_choice.getSelectedItem().toString(), "Heart")) {
                        region_choice[0] = "Heart";
                        region_choice[1] = null;
                        region_choice[2] = null;
                        region_choice[3] = null;
                        region_choice[4] = null;
                    } else if (Objects.equals(r_choice.getSelectedItem().toString(), "Arm")) {
                        region_choice[0] = "Arm";
                        region_choice[1] = null;
                        region_choice[2] = null;
                        region_choice[3] = null;
                        region_choice[4] = null;
                    } else if (Objects.equals(r_choice.getSelectedItem().toString(), "Body")) {
                        region_choice[0] = "Body";
                        region_choice[1] = null;
                        region_choice[2] = null;
                        region_choice[3] = null;
                        region_choice[4] = null;
                    } else if (Objects.equals(r_choice.getSelectedItem().toString(), "Leg")) {
                        region_choice[0] = "Leg";
                        region_choice[1] = null;
                        region_choice[2] = null;
                        region_choice[3] = null;
                        region_choice[4] = null;
                    }
                }
            }
        });

        /* add listeners to 'modality choice' checkboxes */
        choice_MRI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(choice_MRI.isSelected()){
                    modality_choice[0] = "MRI";
                }else{
                    modality_choice[0] = null;
                }
            }
        });
        choice_CT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(choice_CT.isSelected()){
                    modality_choice[1] = "CT";
                }else{
                    modality_choice[1] = null;
                }
            }
        });
        choice_US.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(choice_US.isSelected()){
                    modality_choice[2] = "Ultrasound";
                }else{
                    modality_choice[2] = null;
                }
            }
        });
        choice_XRay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(choice_XRay.isSelected()){
                    modality_choice[3] = "X Ray";
                }else{
                    modality_choice[3] = null;
                }
            }
        });

        // right panel for images searched
        JPanel p = new JPanel();
        p.setLayout(new WrapLayout());

        // right scroll panel that includes p panel
        JScrollPane scrollPane = new JScrollPane(p);
        scrollPane.setBounds(305,0,getWidth()-314,getHeight()-27);

        /* add listener to the 'mode' button and let user choose background color of the search frame */
        mode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!light) {
                    getContentPane().setBackground(line_color);
                    fieldPanel.setBackground(lightmode);
                    numberPanel.setBackground(lightmode);
                    p.setBackground(line_color);
                    buttonPanel.setBackground(lightmode);
                    region.setForeground(fieldpanel_color);
                    modality.setForeground(fieldpanel_color);
                    patient.setForeground(fieldpanel_color);
                    r_choice.setForeground(fieldpanel_color);
                    choice_MRI.setForeground(fieldpanel_color);
                    choice_CT.setForeground(fieldpanel_color);
                    choice_US.setForeground(fieldpanel_color);
                    choice_XRay.setForeground(fieldpanel_color);
                    line.setBackground(fieldpanel_color);
                    welcome_label.setForeground(welcome_color_light);
                    light = true;
                } else {
                    getContentPane().setBackground(displaypanel_color);
                    fieldPanel.setBackground(fieldpanel_color);
                    numberPanel.setBackground(fieldpanel_color);
                    p.setBackground(displaypanel_color);
                    buttonPanel.setBackground(fieldpanel_color);
                    region.setForeground(text_color);
                    modality.setForeground(text_color);
                    patient.setForeground(text_color);
                    r_choice.setForeground(text_color);
                    choice_MRI.setForeground(text_color);
                    choice_CT.setForeground(text_color);
                    choice_US.setForeground(text_color);
                    choice_XRay.setForeground(text_color);
                    line.setBackground(line_color);
                    welcome_label.setForeground(welcome_color);
                    light = false;
                }
            }
        });

        /* add listener to 'confirm' button to search required image(s) */
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //reset numbers of images panel
                numberPanel.removeAll();
                numberPanel.revalidate();
                numberPanel.repaint();

                //reset p panel displaying images
                p.removeAll();
                p.revalidate();
                p.repaint();

                // get patient name
                patient_name = name.getText();
                try {
                    patient_name = patient_name.trim();
                    patient_name_cap = patient_name.substring(0, 1).toUpperCase() + patient_name.substring(1).toLowerCase();

                } catch (Exception e) {
                    patient_name_cap = "";
                }

                //send search information
                SearchInfo searchInfo = new SearchInfo(modality_choice, region_choice, patient_name_cap);

                Client cl = new Client(); // initialize client to request images

                Img[] img_a; // container for images

                // store images searched
                try {
                    img_a = cl.search(searchInfo);
                } catch (Exception e) {
                    e.printStackTrace();
                    img_a = new Img[]{};
                }

                flag = 0; // reset number of images

                // displaying images
                for (Img img : img_a) {
                    flag++; // image count
                    Image image = null;

                    // get thumbnail of image
                    try {
                        image = ImageIO.read(img.getThumbnail());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    assert image != null;
                    ImageIcon imageIcon = new ImageIcon(image);
                    String file_name = img.getFile_name();

                    // create button containing image and filename
                    JButton image_button = new JButton(file_name, imageIcon);
                    image_button.setVerticalTextPosition(SwingConstants.BOTTOM);
                    image_button.setHorizontalTextPosition(SwingConstants.CENTER);
                    image_button.setSize(100, 100);

                    p.add(image_button);

                    /* add listeners to image button */
                    image_button.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            try {
                                InputStream img_stream = cl.getImg(img);
                                Image image = ImageIO.read(img_stream);
                                new Display(image, file_name);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                }

                // add image panel to scroll panel
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                add(scrollPane);

                // number of images
                JLabel result_text = new JLabel("found " + flag + " result(s)");
                result_text.setFont(f);
                result_text.setForeground(result_color);
                numberPanel.add(result_text);
            }
        });

        /* resizing frame */
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                scrollPane.setBounds(305, 0, getWidth() - 314, getHeight() - 27);
                fieldPanel.setBounds(0, 0, 295, getHeight() - 150);
                numberPanel.setBounds(0, getHeight() - 150, 295, 50);
                buttonPanel.setBounds(0, getHeight() - 100, 295, 100);
            }
        });
    }
}
