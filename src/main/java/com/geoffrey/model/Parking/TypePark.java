package com.geoffrey.model.Parking;

public class TypePark {

    final String forWho;
    final int capacity;

    int currentCapacity = 0;

    public TypePark(String forWho, int capacity) {
        this.forWho = forWho;
        this.capacity = capacity;
    }

    public void addInList(TypePark oneTypePark) {

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
        int reste = capacity - currentCapacity;
        System.out.println("Il reste " + reste + " places de '" + forWho + "'.");
        boolean availablePlaces = capacity > currentCapacity + 1;
        if (availablePlaces) {
            currentCapacity = currentCapacity++;
            return true;
        }
        return false;
    }

    public void unPark() {
        currentCapacity = currentCapacity--;
    }

    //retourne la capacité actuelle d'un type de parking
    private int getCurrentCapacityForOneTypePark(TypePark oneTypePark) {
        int capacity = oneTypePark.getCapacity();
        int currentCapacity = oneTypePark.getCurrentCapacity() + 1;
        int gap = capacity - currentCapacity;
        if (gap >= 0) {
            System.out.println("Il reste " + gap + " places de '" + oneTypePark.getForWho() + "'.");
        }
        return currentCapacity;
    }

    //a utilse quand un vehicule entre ou sort
    private void changeCurrentCapacityByOne(TypePark theGoodType, boolean moreOrLess) {
        int newCurrentCapacity = theGoodType.getCurrentCapacity();
        if (moreOrLess)  // true for +1
        {
            newCurrentCapacity += 1;
            theGoodType.setCurrentCapacity(newCurrentCapacity);
        } else { //false for -1
            newCurrentCapacity -= 1;
            theGoodType.setCurrentCapacity(newCurrentCapacity);
        }
    }

}
