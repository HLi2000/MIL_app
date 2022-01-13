import Entities.Img;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test the Img object class
 */

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

        Assert.assertEquals(id,img.getId());
        Assert.assertEquals(modality,img.getModality());
        Assert.assertEquals(region,img.getRegion());
        Assert.assertEquals(patient_name,img.getPatient_name());
        Assert.assertEquals(file_name,img.getFile_name());
    }
}
