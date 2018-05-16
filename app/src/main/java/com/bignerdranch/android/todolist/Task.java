package com.bignerdranch.android.todolist;

public class Task {

    private String name;
    private String subname;
    private int position;

    public Task(String name, String subname) {
        this.name = name;
        this.subname = subname;
        this.position = DataHolder.getInstance().getDhPositionMax();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
