import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class Main {
    //public static int flag = 0;
    public static void main(String[] args) throws Exception {


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

        login_full l = new login_full();

/*
        //search s =new search();
        String[] modality_a= s.return_modality();
        String[] region_a=s.return_region();
        String patient_name=s.return_patient_name();

        patient_name=patient_name.trim();
        String patient_name_cap = patient_name.substring(0, 1).toUpperCase() + patient_name.substring(1).toLowerCase();
        SearchInfo searchInfo=new SearchInfo(modality_a,region_a,patient_name_cap);

        Client cl=new Client();

        Img[] img_a;
        try{
            img_a=cl.search(searchInfo);
        }catch (Exception e){
            e.printStackTrace();
            img_a= new Img[]{};
        }
        for (Img img : img_a) {
            System.out.println(img.getFile_name());
            flag++;
            System.out.println(flag);

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

        //for test
        Image image = ImageIO.read(img_stream);
        JFrame frame = new JFrame();
        JLabel label = new JLabel(new ImageIcon(image));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

    }
*/
    }
}