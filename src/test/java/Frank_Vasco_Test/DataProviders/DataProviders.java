package Frank_Vasco_Test.DataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {


    @DataProvider(name="UserCredentials")
    public Object[][] userCredentials(){
        Object [][] credentials = new Object[1][2];
        {
            credentials[0][0] = "standard_user";
            credentials[0][1] = "secret_sauce";
        }

        return credentials;
    }


}
