package com.bignerdranch.android.todolist;

public class DataHolder {

    private Task data;
    private Task data2;
    private int dhPositionMax = 0;
    private int dhPosition;
    private static final DataHolder holder = new DataHolder();

    public int getDhPosition() { return dhPosition; }
    public void setDhPosition(int dhPosition) { this.dhPosition = dhPosition; }

    public int getDhPositionMax() { return dhPositionMax; }
    public void setDhPositionMax(int dhPositionMax) { this.dhPositionMax = dhPositionMax; }

    public Task getTask() { return data; }
    public Task getTask2() { return data2; }

    public void setTask(Task data) { this.data = data; /*this.dhPosition = data.getPosition();*/ }
    public void setTask2(Task data2) { this.data2 = data2; /*this.dhPosition = data.getPosition();*/ }


    public static DataHolder getInstance() { return holder; }
}
