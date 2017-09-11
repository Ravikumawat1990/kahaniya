package kahaniya.ravi.app.com.kahaniya;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elixir on 08-Aug-2016.
 */
public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder> {


    private List<String> dataSet;
    Context context;
    public OnItemClickListener listener;

    public adapter(Context context, List<String> data) {
        this.dataSet = data;
        this.context = context;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CardView rootView;
        public TextView name;
        LinearLayout layout;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.txtUserName);
            layout = (LinearLayout) itemView.findViewById(R.id.rootView);
            layout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.rootView:
                    listener.onItemClick("", dataSet.get(getAdapterPosition()));
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
        TextView name = holder.name;

        String[] result = dataSet.get(position).split(",");
        name.setText(result[0]);


    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


}
