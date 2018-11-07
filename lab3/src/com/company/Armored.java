package com.company;

public interface Armored {
    void setArmor(float value);
    void setArmorType(Armor armorType);
    float getArmorValue(float armor);
    Armor getArmorType(Armor armorType);

    float calculateDefence();
}
