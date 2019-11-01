package com.moringaschool.outingapi2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.outingapi2.models.Event;

import java.util.List;

public class EventPagerAdapter  extends FragmentPagerAdapter {
    private List<Event> mEvents;

    public EventPagerAdapter(FragmentManager fm, int behavior, List<Event> events) {
        super(fm, behavior);
        mEvents = events;
    }

    @Override
    public Fragment getItem(int position) {
        return EventInfoFragment.newInstance(mEvents.get(position));
    }

    @Override
    public int getCount() {
        return mEvents.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mEvents.get(position).getName();
    }
}
