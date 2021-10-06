package com.geoffrey.model.Parking;

import java.util.ArrayList;
import java.util.List;

public class TypePlace {

    String forWho;
    int capacity = 10;
    int currentCapacity;

    public TypePlace(String forWho, int capacity, int currentCapacity){
        this.forWho = forWho;
        this.currentCapacity = currentCapacity;
        this.capacity = capacity;
    }

    public void addInList(TypePlace oneTypePlace){

    }

    public int getCapacity() { return this.capacity; }

    public String getForWho() { return this.forWho; }
}
