package com.example.moham.library;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moham on 18/09/2016.
 */
public class LibraryListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private BookAdapter mBookAdapter;
    private boolean mSubtitleVisible;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu, menu);
        MenuItem subtitle=menu.findItem(R.id.menu_item_show_subtitle);
        if (mSubtitleVisible){
            subtitle.setTitle(R.string.hide_subtitle);
        }else{
            subtitle.setTitle(R.string.show_subtitle);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_book:
               Book book=new Book();
                LibraryLab.getInstance(getActivity()).addBook(book);
                Intent intent=BookPgerActivity.newIntent(getActivity(),book.getBookId());
                startActivity(intent);
              return true;
            case R.id.menu_item_show_subtitle:
                mSubtitleVisible= !mSubtitleVisible;
                getActivity().invalidateOptionsMenu();
                updateSubTitle();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.library_list_fragment, container, false);
        mRecyclerView=(RecyclerView)view.findViewById(R.id.book_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
     UpdateUI();
        return view;
    }

    /******* to update view we it come in my forentground **********/
    @Override
    public void onResume() {
        super.onResume();
        UpdateUI();
    }

    /******************* for add Adapter to Recycler view and update it ****************/
  public void UpdateUI() {
      List<Book> mBooks = LibraryLab.getInstance(getActivity()).getBooks();
      if (mBookAdapter == null) {
          mBookAdapter = new BookAdapter(mBooks);
          mRecyclerView.setAdapter(mBookAdapter);
      } else {
          mBookAdapter.notifyDataSetChanged();
      }
  }
 public void updateSubTitle(){
     int booksNum=LibraryLab.getInstance(getActivity()).getBooks().size();
     String title=getString(R.string.subtitle_format, booksNum);
     if (!mSubtitleVisible){
         title=null;
     }
     AppCompatActivity activity= (AppCompatActivity) getActivity();
     activity.getSupportActionBar().setSubtitle(title);


 }

    private class BookHolder extends RecyclerView.ViewHolder {
        private Book mBook;
        private TextView mBookName;
        private TextView mBookType;
        public BookHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=BookPgerActivity.newIntent(getActivity(),mBook.getBookId());
                    startActivity(intent);
                }
            });
            mBookName=(TextView)itemView.findViewById(R.id.mBook_name);
            mBookType=(TextView)itemView.findViewById(R.id.mBook_type);
        }

        public void bindBook(Book book){
            mBook=book;
            mBookName.setText(mBook.getBookName());
            mBookType.setText(mBook.getBookTaype());
        }
    }

    private class BookAdapter extends RecyclerView.Adapter<BookHolder>{
        private List<Book> mBooks;
        public BookAdapter(List<Book> books){
            this.mBooks=books;
        }
        @Override
        public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View  view=LayoutInflater.from(getActivity()).inflate(R.layout.book_item_view,parent,false);

            return new BookHolder(view);
        }

        @Override
        public void onBindViewHolder(BookHolder holder, int position) {
       Book book=mBooks.get(position);
            holder.bindBook(book);
        }

        @Override
        public int getItemCount() {
            return mBooks.size();
        }
    }
}
