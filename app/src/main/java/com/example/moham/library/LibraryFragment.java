package com.example.moham.library;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.Date;
import java.util.UUID;

/**
 * Created by moham on 18/09/2016.
 */
public class LibraryFragment extends Fragment {
    private static final String BOOK_ID_FRAGMENT="com.example.moham.library.FRAGMENT.ID";
    private static  final String Date_dailog="Date_dailog";
    private static final int REQUEST_DATE = 0;
    private Book mBook;
    private EditText mbookName;
    private EditText mbookPrice;
    private EditText mbookType;
    private EditText mbookAth;

    public static LibraryFragment newInstance(UUID id){
        Bundle bundle=new Bundle();
        bundle.putSerializable(BOOK_ID_FRAGMENT, id);
        LibraryFragment fragment=new LibraryFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID uuid=(UUID)getArguments().getSerializable(BOOK_ID_FRAGMENT);
        mBook=LibraryLab.getInstance(getActivity()).getBook(uuid);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.delete,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete_item:
                LibraryLab.getInstance(getActivity()).deleteBook(mBook);
                getActivity().finish();
                return true;
                default:
                    return super.onOptionsItemSelected(item);

        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.library_fragment,container,false);
        mbookName= (EditText) view.findViewById(R.id.Book_Name);
        mbookAth=(EditText)view.findViewById(R.id.Book_Ath);
        mbookPrice=(EditText)view.findViewById(R.id.book_price);
        mbookType=(EditText)view.findViewById(R.id.Book_Type);
        mbookName.setText(mBook.getBookName());
        mbookAth.setText(mBook.getBookAth());
        mbookType.setText(mBook.getBookTaype());
        mbookPrice.setText(mBook.getBookPrice());

        /************************* Edit Text Actions **********/
        //****** m book Name  *****//
        mbookName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
              String  text = s.toString();
                mBook.setBookName(text);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //******* m book price ******//
        mbookPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBook.setBookPrice(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //***** m book type *****//
        mbookType.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               mBook.setBookTaype(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //******** m book ath  ******//
        mbookAth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBook.setBookAth(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }

}
