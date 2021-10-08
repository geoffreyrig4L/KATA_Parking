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

    public boolean incrementCurrentCapacity() {
        displayPlaceRemaining();
        boolean availablePlaces = capacity > currentCapacity;
        if (availablePlaces) {
            currentCapacity = currentCapacity++;
            return true;
        }else{
            return false;
        }
    }

    private void displayPlaceRemaining() {
        int reste = capacity - currentCapacity ;
        if(reste>1){
            System.out.println("Il y a " + reste + " places de '" + forWho + "' disponibles.");
        }else {
            System.out.println("Il ne reste aucune place disponible.");
        }
    }

    public void decrementCurrentCapacity() {
        if(currentCapacity!=0)
        {
            currentCapacity = currentCapacity --;
        }
        displayPlaceRemaining();
    }
}
