package com.company;

public class Rocket extends PhysObject implements Armored {

    private Human[] passengers = new Human[10];
    private float armor;
    private Armor armorType;

    {
        type = "Ракета";
        status = Status.AIR;
        heaviness = 24;
    }

    Rocket(){
        setArmor(20);
        setArmorType(Armor.STEEL);
    }

    Rocket(Armor armorType){
        setArmor(20);
        setArmorType(armorType);
    }

    Rocket(float armorValue, Armor armorType){
        setArmor(armorValue);
        setArmorType(armorType);
    }


    void addPassenger(Human ... humans){
        int index = 0;
        int indexMax = humans.length;

        for(int i=0;i<this.passengers.length;i++){
            if (this.passengers[i] == null){
                this.passengers[i] = humans[index];
            }
            if (++index == indexMax){
                break;
            }
        }
    }

    private void setPassengersState(State state){
        for (Human passenger: passengers
             ) {
            if (passenger != null) {
                passenger.setState(state);
                passenger.update();
            }
        }
    }

    @Override
    Boolean update() {

        // Инертность тела падает, когда она в воздухе
        if (status == Status.AIR) {
            heaviness /= 1.4;
        }

        switch (event) {
            case COLLISION:
                System.out.println("Послышался звонкий удар.");
                System.out.println("Ракета вздрогнула.");
                state = State.FLINCH;
                break;
            case BREAK:
                System.out.println("Ракету пробили!");
                state = State.EXPLODE;
                break;

        }
        event = Event.NONE;

        switch (state){
            case FLINCH:
                System.out.println("Ракета потеряв управление начала переворачиваться!");
                state = State.FLIP;
                setPassengersState(State.FLIP);
                break;
            case EXPLODE:
                System.out.println("Ракета взорволась!");
                setPassengersState(State.EXPLODE);
                break;

        }
        for (Human passenger:passengers
             ) {

            if (passenger != null) {
                passenger.update();
                if (passenger.state != State.FALL) return true;
            }
        }
        System.out.println("Все космонавты упали!");
        return false;

    }

    @Override
    public void setArmor(float value) {
        armor = value;
    }

    @Override
    public void setArmorType(Armor armorType) {
        this.armorType = armorType;
    }

    @Override
    public float getArmorValue(float armor) {
        return armor;
    }

    @Override
    public Armor getArmorType(Armor armorType) {
        return armorType;
    }

    @Override
    public float calculateDefence() {
        switch (this.armorType){
            case NONE:
                return armor;
            case WOOD:
                return (float) (armor*1.1);
            case STEEL:
                return (float) (armor*1.4);
            case DIAMOND:
                return (float) (armor*1.6);
            case VIBRANIUM:
                return (float) (armor*2.3);
            case OVT:
                return Float.MAX_VALUE;
            default:
                return 0;

        }
    }

}
