import org.junit.Test;
import top.one.jiemo.util.PaByDocument;
import top.one.jiemo.util.PaByXhr;

import java.io.IOException;

public class testXhrDownload {
    @Test
    public void testXhr() throws IOException {
        new PaByXhr().XhrParse(new PaByXhr().getXhr());
    }



    @Test
    public void testDocument() throws IOException {
        new PaByDocument().JsoupParse();

    }
}
