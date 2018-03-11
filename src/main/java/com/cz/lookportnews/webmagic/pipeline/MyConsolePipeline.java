package com.cz.lookportnews.webmagic.pipeline;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

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
