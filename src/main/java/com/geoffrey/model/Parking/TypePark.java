package com.geoffrey.model.Parking;

public class TypePark {

    final String forWho;
    final int capacity;

    int currentCapacity = 0;

    public TypePark(String forWho, int capacity){
        this.forWho = forWho;
        this.capacity = capacity;
    }

    public void addInList(TypePark oneTypePark){

    }

    public int getCapacity() { return this.capacity; }

    public String getForWho() { return this.forWho; }

    public void setCurrentCapacity(int newNumberVehicules) {this.currentCapacity=newNumberVehicules;}

    public int getCurrentCapacity() { return this.currentCapacity; }
}
