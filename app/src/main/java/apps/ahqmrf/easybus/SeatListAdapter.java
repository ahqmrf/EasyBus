package apps.ahqmrf.easybus;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bsse0 on 11/7/2017.
 */

public class SeatListAdapter extends RecyclerView.Adapter {

    private int                 itemSize;
    private List<Seat>          items;
    private OnSeatClickCallback callback;

    public SeatListAdapter(int itemWidth, List<Seat> items, OnSeatClickCallback callback) {
        this.itemSize = itemWidth;
        this.items = new ArrayList<>();
        this.items.addAll(items);
        this.callback = callback;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_seat, parent, false);
        return new SeatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class SeatViewHolder extends RecyclerView.ViewHolder {

        public SeatViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.getLayoutParams().height = itemSize;
            itemView.getLayoutParams().width = itemSize;
        }

        @OnClick(R.id.seat)
        void onSeatClick() {
            if (callback != null) callback.onSeatClick(items.get(getAdapterPosition()));
        }
    }
}
