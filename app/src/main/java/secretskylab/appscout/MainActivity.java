package secretskylab.appscout;

import android.content.Intent;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //addition
        mListView = (ListView) findViewById(R.id.listView);

        List<App> apps = getApps();
        AppAdapter adapter = new AppAdapter(MainActivity.this, apps);
        mListView.setAdapter(adapter);

        mListView.setClickable(true);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.carconnectivity.mlmediaplayer")));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.carconnectivity.mlmediaplayer")));
                }


            }
        });
    }


    private List<App> getApps(){
        List<App> apps = new ArrayList<App>();

        for (int i =0; i < 200; i++) {
            apps.add(new App("RockScout 1", "BBBBB", "CCCCC", R.drawable.rockscouticon));
            apps.add(new App("RockScout 2", "BBBBB", "CCCCC", R.drawable.rockscouticon));
        }
        return apps;
    }

    public void appClick(View view) {

        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.carconnectivity.mlmediaplayer")));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.carconnectivity.mlmediaplayer")));
        }
    }


}
