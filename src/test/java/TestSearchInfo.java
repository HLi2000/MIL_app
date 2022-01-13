import org.junit.Assert;
import org.junit.Test;

import Entities.*;

/**
 * Test the SearchInfo object class
 */

public class TestSearchInfo {
    @Test
    public void TestSearchInfoIni(){
        String[] modality_a={"CT"};
        String[] region_a={"Arm"};
        String patient_name="Peter";
        SearchInfo searchInfo=new SearchInfo(modality_a,region_a,patient_name);

        Assert.assertArrayEquals(modality_a,searchInfo.getModality_a());
        Assert.assertArrayEquals(region_a,searchInfo.getRegion_a());
        Assert.assertEquals(patient_name,searchInfo.getPatient_name());
    }

    @Test
    public void TestSearchInfoSet(){
        String[] modality_a={"CT"};
        String[] region_a={"Arm"};
        String patient_name="Peter";
        SearchInfo searchInfo=new SearchInfo(null,null,null);
        searchInfo.setModality(modality_a);
        searchInfo.setRegion(region_a);
        searchInfo.setPatient_name(patient_name);

        Assert.assertArrayEquals(modality_a,searchInfo.getModality_a());
        Assert.assertArrayEquals(region_a,searchInfo.getRegion_a());
        Assert.assertEquals(patient_name,searchInfo.getPatient_name());
    }
}
