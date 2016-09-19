package com.example.moham.library;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class LibaryActivity extends SingleFragmentActivity {
  private static final String BOOK_ID="com.example.moham.library.id";

 public static Intent newIntent(Context context,UUID uuid){
     Intent intent=new Intent(context,LibaryActivity.class);
     intent.putExtra(BOOK_ID,uuid);
     return intent;
 }
    @Override
    public Fragment CreateFragment() {
        UUID uuid= (UUID) getIntent().getSerializableExtra(BOOK_ID);
        return LibraryFragment.newInstance(uuid);
    }
}
