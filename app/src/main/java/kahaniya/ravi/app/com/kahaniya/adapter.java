package kahaniya.ravi.app.com.kahaniya;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Elixir on 08-Aug-2016.
 */
public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder> {


    private String[] dataSet;
    Context context;
    public OnItemClickListener listener;

    public adapter(Context context, String[] data) {
        this.dataSet = data;
        this.context = context;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CardView rootView;
        public TextView txtUserName;


        public MyViewHolder(View itemView) {
            super(itemView);
            rootView = (CardView) itemView.findViewById(R.id.rootView);
            txtUserName = (TextView) itemView.findViewById(R.id.txtUserName);


        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.rootView:
                    listener.onItemClick("", dataSet[getAdapterPosition()]);
                    break;

            }

        }
    }

    public void SetOnItemClickListener(OnItemClickListener mItemClickListener) {

        this.listener = mItemClickListener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adptblockuser, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TextView userName = holder.txtUserName;
        userName.setText(dataSet[position]);
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }


}
