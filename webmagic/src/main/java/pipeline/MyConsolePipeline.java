package pipeline;

import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import org.apache.http.util.TextUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import utils.HttpUtils;

import java.io.*;
import java.util.Date;
import java.util.List;

public class MyConsolePipeline  extends ConsolePipeline{



    public MyConsolePipeline() {
        super();

    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        System.out.println(resultItems.get("title").toString());
        String s = resultItems.get("pageSource").toString();


    }

    public void writeHtml(String page){
        File file = new File("E://img//index.html");
        try {
            PrintWriter writer = new PrintWriter(file,"utf-8");
            writer.write(page);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void replaceImgSrc(String content){
        //content.replace("")
    }

}
