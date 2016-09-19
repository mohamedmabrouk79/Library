package com.example.moham.library;

import java.util.Date;
import java.util.UUID;

/**
 * Created by moham on 18/09/2016.
 */
public class Book {
    private String bookTaype;
    private String bookName;
    private String bookPrice;
    private String bookAth;
    private UUID bookId;

    public Book(){
        bookId=UUID.randomUUID();

    }



    public String getBookTaype() {
        return bookTaype;
    }

    public void setBookTaype(String bookTaype) {
        this.bookTaype = bookTaype;
    }

    public UUID getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookAth() {
        return bookAth;
    }

    public void setBookAth(String bookAth) {
        this.bookAth = bookAth;
    }
}
