package com.moringaschool.outingapi2;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.moringaschool.outingapi2.models.Event;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventInfoFragment extends Fragment implements View.OnClickListener{

    @BindView(R.id.eventImageView) ImageView mEventImageView;
    @BindView(R.id.websiteTextView) TextView mWebsiteTextView;
    @BindView(R.id.eventNameTextView) TextView mEventNameTextView;

    @BindView(R.id.descriptionTextView) TextView mDescriptionLabel;

    @BindView(R.id.addressTextView) TextView mAddressLabel;



    private Event mEvent;

    public EventInfoFragment(){
        // Required empty public constructor
    }

    public static EventInfoFragment newInstance(Event event) {
        EventInfoFragment restaurantDetailFragment = new EventInfoFragment();
        Bundle args = new Bundle();
        args.putParcelable("event", Parcels.wrap(event));
        restaurantDetailFragment.setArguments(args);
        return restaurantDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEvent = Parcels.unwrap(getArguments().getParcelable("event"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_info, container, false);
        ButterKnife.bind(this, view);
        Picasso.get().load(mEvent.getImageUrl()).into(mEventImageView);
        mEventNameTextView.setText(mEvent.getName());
        mDescriptionLabel.setText(mEvent.getDescription());
        mAddressLabel.setText(mEvent.getLocation().toString());
        mWebsiteTextView.setOnClickListener(this);
        mDescriptionLabel.setOnClickListener(this);
        mAddressLabel.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v) {
        if (v == mWebsiteTextView) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mEvent.getEventSiteUrl()));
            startActivity(webIntent);
        }

        if (v == mAddressLabel) {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:" + mEvent.getLatitude()
                            + "," + mEvent.getLongitude()
                            + "?q=(" + mEvent.getName() + ")"));
            startActivity(mapIntent);
        }
    }
}
