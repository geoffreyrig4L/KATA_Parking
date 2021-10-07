package com.geoffrey.model.Parking;

public class TypePark {

    final String forWho;
    final int capacity;

    int currentCapacity = 0;

    public TypePark(String forWho, int capacity) {
        this.forWho = forWho;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getForWho() {
        return this.forWho;
    }

    public void setCurrentCapacity(int newNumberVehicules) {
        this.currentCapacity = newNumberVehicules;
    }

    public int getCurrentCapacity() {
        return this.currentCapacity;
    }

    public boolean park() {
        int reste = capacity - currentCapacity ;
        if(reste>1){
            System.out.println("Il reste " + reste + " places de '" + forWho + "'.");
        }else {
            System.out.println("Il ne reste aucune place disponible.");
        }
        boolean availablePlaces = capacity > currentCapacity + 1;
        if (availablePlaces) {
            currentCapacity = currentCapacity++;
            return true;
        }else{
            unPark();
        }
        return false;
    }

    public void unPark() {
        currentCapacity = currentCapacity--;
    }
}
