package com.example.moham.library;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by moham on 18/09/2016.
 */
public class LibraryLab {
    private  static LibraryLab mLab;
    List<Book> mBooks;
    public static LibraryLab getInstance(Context context){
      if (mLab==null){
          mLab=new LibraryLab(context);
      }
          return mLab;
      }

    public void addBook(Book book){
        mBooks.add(book);
    }

    public void deleteBook(Book book){
        for (int i=0 ; i<mBooks.size() ; i++){
            if (mBooks.get(i).getBookId().equals(book.getBookId())){
                mBooks.remove(i);
            }
        }
    }
    private LibraryLab(Context context){
    mBooks=new ArrayList<>();
    }

    public List<Book> getBooks(){
        return mBooks;
    }

    public Book getBook(UUID uuid){
        for (Book book:mBooks){
            if (book.getBookId().equals(uuid)){
                return book;
            }
        }
        return null;
    }
}
