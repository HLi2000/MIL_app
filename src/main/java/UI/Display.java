package UI;

import java.awt.*;
import javax.swing.*;

/**
 * The UI.Zoom is used to let user see the image that they are interested at in its original size
 *
 * @author  Shiyu Wang, Yurong Chen
 * @since   2021-12-05
 */
public class Display {
    private String fileName;


    public Display(Image image, String file_name) throws Exception {

        fileName = file_name;
        JFrame zoom = new JFrame(fileName);
        zoom.setLocation(500, 20);

        zoom.setLayout(new BorderLayout());
        zoom.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        zoom.setVisible(true);
        JPanel imagepanel = init(image);
        zoom.add(imagepanel);
        zoom.pack();
    }

    public JPanel init(Image image) throws Exception {
        int w = image.getWidth(null)*10;
        int h = image.getHeight(null)*10;
        JLabel label = new JLabel(new ImageIcon(image));
        JPanel imagepanel = new JPanel();
        imagepanel.add(label);

        return imagepanel;

    }


}
