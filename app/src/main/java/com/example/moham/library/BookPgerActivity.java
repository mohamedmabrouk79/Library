package com.example.moham.library;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

/**
 * Created by moham on 18/09/2016.
 */
public class BookPgerActivity extends AppCompatActivity {
    public static final String ARG_BOOK_ID="com.example.moham.library.arg_book_id";
  private ViewPager mViewPager;
    private List<Book> mBooks;

    public static Intent newIntent(Context context,UUID uuid){
      Intent intent=new Intent(context,BookPgerActivity.class);
        intent.putExtra(ARG_BOOK_ID,uuid);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_view_pager);
        UUID mId= (UUID) getIntent().getSerializableExtra(ARG_BOOK_ID);
        mBooks=LibraryLab.getInstance(this).getBooks();
        mViewPager=(ViewPager)findViewById(R.id.activity_book_view_pager);
        FragmentManager fragmentManager=getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                LibraryFragment fragment=LibraryFragment.newInstance(mBooks.get(position).getBookId());
                return fragment;
            }

            @Override
            public int getCount() {
                return mBooks.size();
            }
        });
        for(int i=0 ; i<mBooks.size();i++){
            if (mBooks.get(i).getBookId().equals(mId)){
                mViewPager.setCurrentItem(i);
                break;
            }

        }

    }
}
