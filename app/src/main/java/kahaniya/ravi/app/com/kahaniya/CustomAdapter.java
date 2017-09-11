package kahaniya.ravi.app.com.kahaniya;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravi kumawat on 2017-09-09.
 */

public class CustomAdapter extends BaseAdapter {

    List<String> stringArrayList;
    Context context;

    public CustomAdapter(Context context, List<String> stringArrayList) {
        this.context = context;
        this.stringArrayList = stringArrayList;
    }

    @Override
    public int getCount() {
        return stringArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return stringArrayList.indexOf(getItem(position));
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.adptblockuser, null);
            holder = new ViewHolder();
            holder.txtUserName = (TextView) convertView.findViewById(R.id.txtUserName);
            holder.layout = (LinearLayout) convertView.findViewById(R.id.rootView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String[] result = stringArrayList.get(i).split(",");
        //name.setText(result[0]);

        holder.txtUserName.setText(result[0]);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Viewdetail.class);
                intent.putExtra("page", stringArrayList.get(i));
                CM.startActivity(intent, (Activity) context);
            }
        });

        return convertView;
    }

    /*private view holder class*/
    private class ViewHolder {
        TextView txtUserName;
        LinearLayout layout;

    }

}