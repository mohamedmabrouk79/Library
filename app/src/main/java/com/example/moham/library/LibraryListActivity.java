package com.example.moham.library;

import android.support.v4.app.Fragment;

/**
 * Created by moham on 18/09/2016.
 */
public class LibraryListActivity extends  SingleFragmentActivity {
    @Override
    public Fragment CreateFragment() {
        return new LibraryListFragment();
    }
}
