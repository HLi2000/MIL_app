import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class TestImg {
    @Test
    public void TestImgSet(){
        int id=1;
        String modality="CT";
        String region="Arm";
        String patient_name="Peter";
        String file_name="ct arm 2.png";
        Img img=new Img();
        img.setId(id);
        img.setModality(modality);
        img.setRegion(region);
        img.setPatient_name(patient_name);
        img.setFile_name(file_name);
        Assert.assertEquals(img.getId(),id);
        Assert.assertEquals(img.getModality(),modality);
        Assert.assertEquals(img.getRegion(),region);
        Assert.assertEquals(img.getPatient_name(),patient_name);
        Assert.assertEquals(img.getFile_name(),file_name);
    }
}
