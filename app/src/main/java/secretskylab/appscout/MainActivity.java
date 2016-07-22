package secretskylab.appscout;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ListView mListView;
    List<App> apps = getApps();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //addition
        mListView = (ListView) findViewById(R.id.listView);


        AppAdapter adapter = new AppAdapter(MainActivity.this, apps);
        mListView.setAdapter(adapter);

        mListView.setClickable(true);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if (apps.get(position).isAppInstalled())
                {
                    Intent appli = getPackageManager().getLaunchIntentForPackage(apps.get(position).getApkName());
                    startActivity(appli);
                }
                else {
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + apps.get(position).getApkName())));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + apps.get(position).getApkName())));
                    }
                }


            }
        });

        areAppInstalled();

    }


    private List<App> getApps(){
        List<App> apps = new ArrayList<App>();

        apps.add(new App("Audioteka", "", "pl.k2.droidoaudioteka", R.drawable.audioteka));
        apps.add(new App("Aupeo!", "", "com.aupeo.AupeoNextGen", R.drawable.aupeo));
        apps.add(new App("miRoamer Internet Radio", "", "com.miroamer", R.drawable.miroamer));
        apps.add(new App("Glympse", "", "com.glympse.android.auto", R.drawable.glympse));
        apps.add(new App("iCoyote", "", "com.coyotesystems.android", R.drawable.icoyote));
        apps.add(new App("Sygic", "", "com.sygic.incar", R.drawable.sygic));
        apps.add(new App("RockScout", "", "com.carconnectivity.mlmediaplayer", R.drawable.rockscout));
        apps.add(new App("Spotify with RockScout", "", "com.spotify.music", R.drawable.spotify));
        apps.add(new App("Vanilla Music with RockScout", "", "ch.blinkenlights.android.vanilla", R.drawable.vanillamusic));
        apps.add(new App("Voice Infos with RockScout", "", "com.fabbro.voiceinfos.trial", R.drawable.voiceinfo));
        apps.add(new App("NPR One with RockScout", "", "org.npr.one", R.drawable.npr));
        apps.add(new App("Deezer Music with RockScout", "", "deezer.android.app", R.drawable.deezer));




        return apps;
    }
    private void areAppInstalled()
    {
        for (int i=0; i < apps.size();i++)
        {
            try {
                getPackageManager().getPackageInfo(apps.get(i).getApkName(), PackageManager.GET_ACTIVITIES);
                apps.get(i).changeDescription();
                apps.get(i).setInstalled();
            }
            catch (PackageManager.NameNotFoundException e) {
            }
        }
    }
}
