package com.example;

import java.util.List;

public class Lion {

    private String animalKind;
    boolean hasMane;

    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }
    public Lion(Kittens kittens){
        this.kittens = kittens;
    }

    Feline feline = new Feline();
    Kittens kittens;

    public int getKittens() {
        return kittens.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood(String animalKind) throws Exception {
        return feline.getFood(animalKind);
    }
}