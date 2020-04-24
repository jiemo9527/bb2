import org.junit.Test;
import top.one.jiemo.util.GetThirdParse;
import top.one.jiemo.util.HttpProxy;

import java.io.IOException;

public class testThirdParse {
    @Test
    public void testparse(){
        try {
            String url="https://www.acfun.cn/v/ac11915175";

            String m3u8_url = GetThirdParse.httpGet(
                    "http://www.flvcd.com/parse.php?format=&kw="+url);
            System.out.println(m3u8_url);
            if (m3u8_url.contains("m3u8")){
                System.out.println("√");
            }else {
                System.out.println("×");
            }
        } catch (IOException e) {
            System.out.println("第三方解析超时："+e);
        }
    }
    @Test
    public void testHttpProxy() throws Exception {
        String m3u8 = new HttpProxy().getParse("https://www.acfun.cn/v/ac11915175");
        System.out.println(m3u8);
    }

}
