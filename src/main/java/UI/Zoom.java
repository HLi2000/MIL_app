package UI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;

public class Zoom {
    //private String modality;
    //private String part;
    //private String patientname;
    private String fileName;
    //private JFrame zoom = new JFrame("Modality:"+modality+"   "+"Part:"+part+"   "+"Patient name:"+patientname);

    //private ImageIcon logo = new ImageIcon("D:/Year_3/programming3/group_project/image/logo_w.png");
    //private ImageIcon image = new ImageIcon("image/b.jpg");
    //private JLabel image_label = new JLabel(image);

    //private JLabel z_image = new JLabel(new ImageIcon("D:/Year_3/programming3/group_project/UI/material/naughty_test.jpg"));


    int ratio;
    int flag = 0;

/*
    BufferedImage image_f;
    {
        try {
            image_f = ImageIO.read((ImageInputStream) image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */

    //int width = image_f.getWidth();
    //int height = image_f.getHeight();
    //int width_n;
    //int height_n;

    public Zoom(Image image, String file_name) throws Exception {
        //zoom.setBounds(20,20,1000,800);
        fileName = file_name;
        JFrame zoom = new JFrame(fileName);
        zoom.setLocation(500, 20);
        Container zoom_c = zoom.getContentPane();

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
        Image bImage = image.getScaledInstance(w, h, Image.SCALE_DEFAULT);
        //BufferedImage bImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        ImageIcon imageIcon= new ImageIcon(bImage);
        //JLabel image_label = new JLabel(image);
        //JFrame frame = new JFrame();
        JLabel label = new JLabel(new ImageIcon(image));
        //frame.getContentPane().add(label, BorderLayout.CENTER);
        //frame.pack();
        //frame.setVisible(true);
        JPanel imagepanel = new JPanel();
        //logopanel.setBounds(0, 0, 400, 130);
        //logopanel.setBackground(panel_color);
        //logo_label.setBounds(0, 0, 400, 130);
        imagepanel.add(label);

        return imagepanel;
        //zoom.MAXIMIZED_BOTH;

    }
/*
    public static Img scale(Img raw, File destImageFile,float scale){
        try {
            //获取缩放后的宽高
            BufferedImage bimg = ImageIO.read(new File(raw.getFile_name()));
            int width = (int) (bimg.getWidth()*scale);
            int height = (int) (bimg.getHeight()*scale);
            //调用缩放方法获取缩放后的图片
            Image img = bimg.getScaledInstance(width , height, Image.SCALE_DEFAULT);
            //创建一个新的缓存图片
           /* BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            //获取画笔
            Graphics2D graphics = image.createGraphics();
            //将Image对象画在画布上,最后一个参数,ImageObserver:接收有关 Image 信息通知的异步更新接口,没用到直接传空
            graphics.drawImage(img, 0, 0,null);
            //一定要释放资源
            graphics.dispose();
            //获取到文件的后缀名
            String fileName = srcImageFile.getName();
            String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
            //使用ImageIO的write方法进行输出
            ImageIO.write(image,formatName,destImageFile);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
        return

 */

 /*
    public static void main(String[] args) {
        /*
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
        new zoom();
    }
*/

}
