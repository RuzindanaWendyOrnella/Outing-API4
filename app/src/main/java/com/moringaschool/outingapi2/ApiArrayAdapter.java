package com.moringaschool.outingapi2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.moringaschool.outingapi2.models.Event;
import com.squareup.picasso.Picasso;
import org.parceler.Parcels;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
public class ApiArrayAdapter extends RecyclerView.Adapter<ApiArrayAdapter.RestaurantViewHolder> {
    private List<Event> mEvents;
    private Context mContext;
    public ApiArrayAdapter(Context context, List<Event> events) {
        mContext = context;
        mEvents = events;
    }
    @Override
    public ApiArrayAdapter.RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_each, parent, false);
        RestaurantViewHolder viewHolder = new RestaurantViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ApiArrayAdapter.RestaurantViewHolder holder, int position) {
        holder.bindRestaurant(mEvents.get(position));
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.eventImageView)
        ImageView mEventImageView;
        @BindView(R.id.eventNameTextView) TextView mEventNameTextView;
        @BindView(R.id.categoryTextView) TextView mCategoryTextView;
        private Context mContext;

        public RestaurantViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindRestaurant(Event event) {
            Picasso.get().load(event.getImageUrl()).into(mEventImageView);
            mEventNameTextView.setText(event.getName());
            mCategoryTextView.setText(event.getDescription());

        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, EventInfoActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("events", Parcels.wrap(mEvents));
            mContext.startActivity(intent);
        }
    }
}