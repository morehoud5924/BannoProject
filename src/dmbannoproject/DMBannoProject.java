
package dmbannoproject;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Morehoud
 */
public class DMBannoProject {


 
    public static void main(String[] args) throws IOException {
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://banno.com");
        CloseableHttpResponse response1 = httpclient.execute(httpGet);
        BannoFunctions bannoFunctions = new BannoFunctions();
        
        try
        {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            String webpagehtml = EntityUtils.toString(entity1);
            System.out.println("Platform Features Count : " + bannoFunctions.platformFeaturesCount(webpagehtml));
            System.out.println("Top Alpha Characters : \n" + bannoFunctions.topAlphaChar(webpagehtml));
            System.out.println("png Count : " + bannoFunctions.pngImagesCount(webpagehtml));
            System.out.println("Twitter Handle : " + bannoFunctions.bannoTwitterHandle(webpagehtml));
            System.out.println("Financial Institution Count : " + bannoFunctions.financialinstitutionCount(webpagehtml));
            EntityUtils.consume(entity1);
        }
        finally{response1.close();}
    }
    
}
