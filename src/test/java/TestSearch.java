import UI.Search;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionListener;

public class TestSearch {
    @Test
    public void testRegion(){
    Search s = new Search();
    s.init();
    confirm.doclick();
    String[] region_choice = new String[5];
    region_choice[0]="Head";
    region_choice[1]="Heart";
    region_choice[2]="Arm";
    region_choice[3]="Body";
    region_choice[4]="Leg";
    String[] modality_choice= new String[5];
    modality_choice[0]="MRI";
    modality_choice[1]= null;
    modality_choice[2]= null;
    modality_choice[3]= null;
    modality_choice[4]= null;



        // validate
    }
}
}
