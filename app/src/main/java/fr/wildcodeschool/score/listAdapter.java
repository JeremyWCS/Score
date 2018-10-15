package fr.wildcodeschool.score;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class listAdapter extends ArrayAdapter<Player> {

    public listAdapter(Context context, ArrayList<Player> players) {
        super(context,0,players);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Player player = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView textname = (TextView) convertView.findViewById(R.id.name_view);
        textname.setText(player.getName());

        TextView textscore = (TextView) convertView.findViewById(R.id.score_view);
        textscore.setText(player.getScore());

        return convertView;
    }

}
