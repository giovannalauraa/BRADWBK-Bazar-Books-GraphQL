package com.bazar.bazarbooks.dto;

public class NotificationInput {
    private int idUser;
    private int bookId;

    public NotificationInput() {}

    public NotificationInput(int idUser, int bookId) {
        this.idUser = idUser;
        this.bookId = bookId;
    }

    public int getidUser() {
        return idUser;
    }
    public void setidUser(int idUser) {
        this.idUser = idUser;
    }
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
