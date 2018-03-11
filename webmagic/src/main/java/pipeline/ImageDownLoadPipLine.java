package pipeline;

import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import utils.HttpUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

public class ImageDownLoadPipLine implements Pipeline {

    String imgDir = "";

    String path = "E://img//";

    StringBuffer sb = new StringBuffer(path);

    @Override
    public void process(ResultItems resultItems, Task task) {

        List<String>  imgUrlList = resultItems.get("imgUrl");
        String pageDir = resultItems.get("imgDir");
        String imgName = resultItems.get("imgName");
        //没有图片直接返回
        if(imgUrlList==null)
            return ;
        String dir = path+pageDir+"//";
        //下载图片
        int i = 0;
        for (String s : imgUrlList) {
            i++;
            try {
                HttpConfig httpConfig = HttpUtils.getHttpConfig();
                File file = new File(dir+imgName+i+".jpg" );
                FileOutputStream fileOutputStream=new FileOutputStream(file);
                httpConfig.url(s)
                        .out(fileOutputStream);
                HttpClientUtil.down(httpConfig);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (HttpProcessException e) {
                e.printStackTrace();
            }
        }
    }
}
