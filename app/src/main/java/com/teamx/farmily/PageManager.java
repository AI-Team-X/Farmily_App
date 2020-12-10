package com.teamx.farmily;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageManager extends FragmentStatePagerAdapter {
    int behavior;
    public PageManager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.behavior = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                AllCropFragment tabOne = new AllCropFragment();
                return tabOne;
            case 1:
                ForSaleFragment tabTwo = new ForSaleFragment();
                return tabTwo;
            case 2:
                SoldFragment tabThree = new SoldFragment();
                return tabThree;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return behavior;
    }
}
