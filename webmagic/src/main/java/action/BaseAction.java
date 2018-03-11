package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import us.codecraft.webmagic.Page;

import java.util.List;

public abstract class BaseAction  {

   protected String btnName = "load_more_btn";
   protected  int clickTime = 6;



    protected long clickSleepTime = 2*1000L;

    /**
     *  执行完加载按钮后，WebDriver
     * @param webDriver
     * @return
     * @throws InterruptedException
     */
    public abstract void loadMoreBtn(WebDriver webDriver) throws InterruptedException;

    public int getClickTime() {
        return clickTime;
    }

    public void setClickTime(int clickTime) {
        this.clickTime = clickTime;
    }

    public long getClickSleepTime() {
        return clickSleepTime;
    }

    public void setClickSleepTime(long clickSleepTime) {
        this.clickSleepTime = clickSleepTime;
    }
}
