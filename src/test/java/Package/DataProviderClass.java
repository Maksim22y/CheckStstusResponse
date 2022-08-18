package Package;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name ="LoginPass" )
    public Object [][] getData() {
        Object [][] data={
                {"https://www.youtube.com/?hl=RU"},
                {"hps://wwwyouubhl=RU"},
                {"egrgrg"}};
        return data;
    }
}
