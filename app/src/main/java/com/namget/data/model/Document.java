package com.namget.data.model;

import java.util.ArrayList;

public class Document<T> {
    ArrayList<T> list;

    public ArrayList<T> getList() {
        return list;
    }

    public void setList(ArrayList<T> list) {
        this.list = list;
    }
}
