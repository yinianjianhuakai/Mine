package sdkdemo.demo.com.utils;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by  sjx  on 2020/8/26
 */
public class NetRequest {

    public void getRequestJson(){
        String jsonStr = request("https://m.ting22.com/api.php?c=Json&a=mlink&id=1751&pid=89");
        System.out.println("jsonStr : " + jsonStr);
//        decode();
    }

    private void decode(){
        String str = "NEVDL3A1MmswT241V1FRQUlBN1NKbGNZdnV6M203bGtiK2tjY3NvVjZQVXFSWTFwY2hCZjF5dm9wUXM2QUVlOWV4WUVvVk5jU2J0bXloZzZLU1BBRjNxU2JDRDZ5cThEUE1oUVFhOHkyaTBLN0YxelhRRzhNbDBqOTA0QUFqcUVncVErVDgrdWN0a1hEY01BenFybDJBPT0mJiZlc0pyMEdKYVdLVGNnb1lr";
        System.out.println(str.contains("*"));
    }

    private String request(String str) {
        try {
            URL                url           = new URL(str);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setReadTimeout(5000);
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
            urlConnection.setRequestProperty("Charset", "UTF-8");
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            InputStream inputStream = urlConnection.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder  sb             = new StringBuilder();

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
                System.out.println(line);
            }

            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
