package secretskylab.appscout;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ContextMenu;



import android.widget.ArrayAdapter;

import java.util.List;

public class AppAdapter extends ArrayAdapter<App> {


    public AppAdapter(Context context, List<App> Apps) {
        super(context, 0, Apps);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_app,parent, false);
        }

        AppViewHolder viewHolder = (AppViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new AppViewHolder();
            viewHolder.appName = (TextView) convertView.findViewById(R.id.appName);
            viewHolder.appDescription = (TextView) convertView.findViewById(R.id.appDescription);
            viewHolder.appImage = (ImageView) convertView.findViewById(R.id.appImage);
            viewHolder.ok = (ImageView) convertView.findViewById(R.id.ok);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<App> Apps
        App app = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.appName.setText(app.getName());
        viewHolder.appDescription.setText(app.getDescription());
        viewHolder.appImage.setImageResource(app.getResourse());
        viewHolder.ok.setImageResource(R.drawable.ok);
        if (app.isAppInstalled())
        {
            viewHolder.ok.setVisibility(ImageView.VISIBLE);
            viewHolder.ok.setImageResource(R.drawable.ok);
        }
        else
        {
            viewHolder.ok.setImageResource(R.drawable.cart);
        }


        return convertView;
    }

    private class AppViewHolder{
        public TextView appName;
        public TextView appDescription;
        public ImageView appImage;
        public ImageView ok;
    }
}