import UI.Zoom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class TestZoom {
    @Test
    public void testInit() throws Exception {
        File f = new File("img/whiteLogo.png");
        Image image = ImageIO.read(f);
        String file_name = "whiteLogo.png";

        Zoom z = new Zoom(image, file_name);
        JPanel p = z.init(image);
        JLabel label = new JLabel(new ImageIcon(image));
        JPanel imagePanel = new JPanel();
        imagePanel.add(label);
        Assertions.assertEquals(imagePanel,p);
    }
}
