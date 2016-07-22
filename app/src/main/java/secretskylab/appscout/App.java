package secretskylab.appscout;


import android.media.Image;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Context;

public class App {

    public String appName;
    public String appDescription;
    public String apkName;
    public boolean isInstalled;
    public int resourse;

    public App(String name, String descritionText, String apkName, int resourse )
    {
        this.apkName = apkName;
        this.appDescription = descritionText;
        this.appName = name;
        this.resourse = resourse;
        this.isInstalled = false;

    }
    public App(String name, String descritionText, String apkName, int resourse, boolean isInstalled)
    {
        this.apkName = apkName;
        this.appDescription = descritionText;
        this.appName = name;
        this.resourse = resourse;
        this.isInstalled = isInstalled;
    }

    public boolean isAppInstalled()
    {
        return isInstalled;
    }

    public String getName()
    {
        return appName;
    }

    public String getDescription()
    {
        return appDescription;
    }

    public int getResourse()
    {
        return resourse;
    }

    public String getApkName()
    {
        return apkName;
    }

    public void changeDescription()
    {
        appDescription ="INSTALLED";
        return;
    }
    public void setInstalled()
    {
        isInstalled =true;
        return;
    }
}
